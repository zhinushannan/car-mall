package club.kwcoder.server.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * browse
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class BrowseDO extends BrowseDOKey implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 浏览次数
     */
    private Integer frequency;
    /**
     * 上次浏览时间
     */
    private LocalDateTime lastBrowse;
}