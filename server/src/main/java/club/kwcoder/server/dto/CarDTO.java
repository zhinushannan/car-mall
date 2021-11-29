package club.kwcoder.server.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CarDTO  implements Serializable {
    /**
     * 汽车的id，唯一标识符，由后端代码自动生成，不可修改
     */
    private String id;

    /**
     * 汽车的品牌
     */
    private String brand;

    /**
     * 车系
     */
    private String model;

    /**
     * 上牌日期
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate registerDate;

    /**
     * 里程数，万公里
     */
    private Integer mileage;

    /**
     * 排量
     */
    private Integer displacement;

    /**
     * 变速箱
     */
    private String gearbox;

    /**
     * 售价，万元
     */
    private Double price;

    /**
     * 标价，万元
     */
    private Double showPrice;

    /**
     * 图片列表，以json格式保存
     */
    private String imgList;

    /**
     * 图片的 json 格式
     */
    private List<ImageDTO> img;

    /**
     * 车主的邮箱
     */
    private String userEmail;

    /**
     * 汽车的状态，0在售，-1待审核，1被预约，-2被驳回，2已售出
     */
    private Integer status;

    /**
     * 汽车的创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createdGmt;

    /**
     * 汽车的修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime modifiedGmt;

    public boolean isLegal() {
        return !StringUtils.isNotBlank(this.brand) ||
                !StringUtils.isNotBlank(this.model) ||
                null == this.registerDate || !this.registerDate.isBefore(LocalDate.now()) ||
                this.mileage <= 0 ||
                this.displacement <= 0 ||
                !StringUtils.isNotBlank(this.gearbox) || (!StringUtils.equals(this.gearbox, "手动") && !StringUtils.equals(this.gearbox, "自动") && !StringUtils.equals(this.gearbox, "手自一体")) ||
                this.price <= 0 ||
                this.showPrice <= 0 || this.price > this.showPrice;
    }


    public void setImgList(String imgList) {
        this.imgList = imgList;
        this.img = JSONArray.parseArray(this.imgList, ImageDTO.class);
    }

    private static final long serialVersionUID = 1L;
}