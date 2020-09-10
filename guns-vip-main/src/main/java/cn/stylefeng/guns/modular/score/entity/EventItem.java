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
 * 事件类型
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
@TableName("tb_event_item")
public class EventItem implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 事件项
     */
    @TableField("name")
    private String name;

    /**
     * 分值
     */
    @TableField("score")
    private Integer score;

    /**
     * 事件类型(1：积极事件-加分项；0：消极事件-减分项)
     */
    @TableField("event_type")
    private Integer eventType;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
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
        return "EventItem{" +
        "id=" + id +
        ", name=" + name +
        ", score=" + score +
        ", eventType=" + eventType +
        ", remark=" + remark +
        ", state=" + state +
        ", createUser=" + createUser +
        ", createTime=" + createTime +
        "}";
    }
}
