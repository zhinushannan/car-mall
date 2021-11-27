package club.kwcoder.server.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * user
 *
 * @author
 */
@Data
@Accessors(chain = true)
public class UserDO implements Serializable {
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
     * 用户的密码，当管理员对其进行重置时，密码为邮箱
     */
    private String password;
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
}