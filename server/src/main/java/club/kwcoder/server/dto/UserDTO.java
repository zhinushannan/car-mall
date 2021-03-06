package club.kwcoder.server.dto;

import club.kwcoder.server.utils.ValidatorUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户的email，用户唯一标识符
     */
    private String email;
    /**
     * 用户的盐
     */
    private String salt;

    /**
     * 邮箱验证码，注册时会使用到
     */
    private String code;

    /**
     * 原密码，修改密码时会用到
     */
    private String oldPassword;
    /**
     * 用户的密码，当管理员对其进行重置时，密码为邮箱
     */
    private String password;
    /**
     * 用户的重复密码，在注册和修改密码时会用到
     */
    private String repeatPassword;
    /**
     * 用户创建的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdGmt;
    /**
     * 用户上次修改个人信息的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime modifiedGmt;
    /**
     * 用户上次登录的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastLogin;

    /**
     * 判断邮箱是否为标准格式
     *
     * @return 是返回 FALSE， 不是返回 TRUE
     */
    public boolean isEmailLegal() {
        return !ValidatorUtil.validateEmail(this.email);
    }

    public boolean isPasswordEqualRepeat() {
        return !StringUtils.equals(this.password, this.repeatPassword);
    }

    public boolean isPasswordCorrect(String password) {
        return StringUtils.equals(DigestUtils.md5DigestAsHex((salt + this.oldPassword).getBytes()), password);
    }
}