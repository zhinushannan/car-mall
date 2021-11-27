package club.kwcoder.server.dto;

import club.kwcoder.server.utils.ValidatorUtil;
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
    private LocalDateTime createdGmt;
    /**
     * 用户上次修改个人信息的时间
     */
    private LocalDateTime modifiedGmt;
    /**
     * 用户上次登录的时间
     */
    private LocalDateTime lastLogin;

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