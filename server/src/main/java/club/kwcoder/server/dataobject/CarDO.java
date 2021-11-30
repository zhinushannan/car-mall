package club.kwcoder.server.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * car
 *
 * @author
 */
@Data
@Accessors(chain = true)
public class CarDO implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private LocalDateTime createdGmt;
    /**
     * 汽车的修改时间
     */
    private LocalDateTime modifiedGmt;
}