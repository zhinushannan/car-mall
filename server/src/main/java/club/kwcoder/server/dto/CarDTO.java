package club.kwcoder.server.dto;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

    public boolean isLegal() {
        return StringUtils.isNotBlank(this.brand) &&
                StringUtils.isNotBlank(this.model) &&
                null != this.registerDate && this.registerDate.isBefore(LocalDate.now()) &&
                this.mileage > 0 &&
                this.displacement > 0 &&
                StringUtils.isNotBlank(this.gearbox) && (StringUtils.equals(this.gearbox, "手动") || StringUtils.equals(this.gearbox, "自动") || StringUtils.equals(this.gearbox, "手自一体")) &&
                this.price > 0 &&
                this.showPrice > 0 && this.price <= this.showPrice;
    }


    private static final long serialVersionUID = 1L;
}