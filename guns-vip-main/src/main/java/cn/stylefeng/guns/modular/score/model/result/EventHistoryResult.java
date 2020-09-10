package cn.stylefeng.guns.modular.score.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 历史事件
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
@Data
public class EventHistoryResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    private Integer id;

    /**
     * 事件ID
     */
    private Integer itemId;

    /**
     * 事件名称
     */
    private String itemName;

    /**
     * 加分对象
     */
    private Integer userId;
    private String userName;

    /**
     * 历史积分
     */
    private Integer preScore;

    /**
     * 本次操作积分
     */
    private Integer optScore;

    /**
     * 结果积分
     */
    private Integer sufScore;

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
    private String createUserName;

    /**
     * 创建时间
     */
    private Date createTime;

}
