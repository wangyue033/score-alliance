package cn.stylefeng.guns.modular.score.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 事件类型
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
@Data
public class EventItemParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    private Integer id;

    /**
     * 事件项
     */
    private String name;

    /**
     * 分值
     */
    private Integer score;

    /**
     * 事件类型(1：积极事件-加分项；0：消极事件-减分项)
     */
    private Integer eventType;

    /**
     * 说明
     */
    private String remark;

    /**
     * 状态(1:有效，0：无效)
     */
    private Integer state;

    /**
     * 模型创建者
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    @Override
    public String checkParam() {
        return null;
    }

}
