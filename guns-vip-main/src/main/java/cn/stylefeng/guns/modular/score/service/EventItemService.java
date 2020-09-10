package cn.stylefeng.guns.modular.score.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.score.entity.EventItem;
import cn.stylefeng.guns.modular.score.model.params.EventItemParam;
import cn.stylefeng.guns.modular.score.model.result.EventItemResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 事件类型 服务类
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
public interface EventItemService extends IService<EventItem> {

    /**
     * 新增
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    void add(EventItemParam param);

    /**
     * 删除
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    void delete(EventItemParam param);

    /**
     * 更新
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    void update(EventItemParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    EventItemResult findBySpec(EventItemParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    List<EventItemResult> findListBySpec(EventItemParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
     LayuiPageInfo findPageBySpec(EventItemParam param);

}
