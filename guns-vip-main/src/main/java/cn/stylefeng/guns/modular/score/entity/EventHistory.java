package cn.stylefeng.guns.modular.score.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 历史事件
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
@TableName("tb_event_history")
public class EventHistory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 事件ID
     */
    @TableField("item_id")
    private Integer itemId;

    /**
     * 事件名称
     */
    @TableField("item_name")
    private String itemName;

    /**
     * 加分对象
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 历史积分
     */
    @TableField("pre_score")
    private Integer preScore;

    /**
     * 本次操作积分
     */
    @TableField("opt_score")
    private Integer optScore;

    /**
     * 结果积分
     */
    @TableField("suf_score")
    private Integer sufScore;

    /**
     * 说明
     */
    @TableField("remark")
    private String remark;

    /**
     * 状态(1:有效，0：无效)
     */
    @TableField("state")
    private Integer state;

    /**
     * 模型创建者
     */
      @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPreScore() {
        return preScore;
    }

    public void setPreScore(Integer preScore) {
        this.preScore = preScore;
    }

    public Integer getOptScore() {
        return optScore;
    }

    public void setOptScore(Integer optScore) {
        this.optScore = optScore;
    }

    public Integer getSufScore() {
        return sufScore;
    }

    public void setSufScore(Integer sufScore) {
        this.sufScore = sufScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "EventHistory{" +
        "id=" + id +
        ", itemId=" + itemId +
        ", itemName=" + itemName +
        ", userId=" + userId +
        ", preScore=" + preScore +
        ", optScore=" + optScore +
        ", sufScore=" + sufScore +
        ", remark=" + remark +
        ", state=" + state +
        ", createUser=" + createUser +
        ", createTime=" + createTime +
        "}";
    }
}
