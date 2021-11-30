package club.kwcoder.server.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * browse
 *
 * @author
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class BrowseDOKey implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 汽车的id，为该表的主键
     */
    private String carId;
    /**
     * 用户的邮箱
     */
    private String userEmail;
}