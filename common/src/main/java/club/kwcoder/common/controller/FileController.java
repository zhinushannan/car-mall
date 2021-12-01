package club.kwcoder.common.controller;

import club.kwcoder.server.bean.ResultBean;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {

    @RequestMapping(value = "/upload/img")
    public ResultBean<Map<String,String>> uploadImg(MultipartFile file) {
        Map<String,String> outMap = new HashMap<>();

        String imgName = file.getOriginalFilename();

        outMap.put("name", imgName);

        try {
            LocalDateTime now = LocalDateTime.now();

            // 生成新的文件名 （取图片名称+当前上传时间）
            String fileName = now + "-" + imgName;

            InputStream input = file.getInputStream();

            // 初始化阿里云oss链接，上传图片到服务器
            String endPoint = "oss-cn-shanghai.aliyuncs.com";
            String accessKeySecret = "Ud3MYKKA3wmX8j9Whtl9pp2uOsSyrU";
            String accessKeyId = "LTAI4Fzp84ANwV2WEGyZAh4d";
            OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
            // 上传文件流
            ObjectMetadata objectMetadata = new ObjectMetadata();
            String[] split = fileName.split("\\.");
            if (split[split.length - 1].equals("jpeg") || split[split.length - 1].equals("jpg")) {
                objectMetadata.setContentType("image/jpg");
            } else if (split[split.length - 1].equals("png")) {
                objectMetadata.setContentType("image/png");
            }


            String bucketName = "kwcoder";
            ossClient.putObject(new PutObjectRequest(bucketName, fileName, input, objectMetadata));

            // 设置图片链接有效期，十年
            LocalDateTime time = LocalDateTime.now().plusYears(10);
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = time.atZone(zoneId);
            Date expiration = Date.from(zdt.toInstant());
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, fileName, HttpMethod.GET);
            request.setExpiration(expiration);

            ossClient.shutdown();

            outMap.put("url", "http://img.kwcoder.cn/" + fileName);

        } catch (IOException e) {
            e.printStackTrace();
            outMap.put(imgName, "上传失败！");
            return ResultBean.getError("上传失败，请重试！");
        }
        return ResultBean.getSuccess("上传成功", outMap);
    }

}
