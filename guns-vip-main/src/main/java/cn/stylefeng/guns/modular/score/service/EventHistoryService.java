package cn.stylefeng.guns.modular.score.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.score.entity.EventHistory;
import cn.stylefeng.guns.modular.score.model.params.EventHistoryParam;
import cn.stylefeng.guns.modular.score.model.result.EventHistoryResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 历史事件 服务类
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
public interface EventHistoryService extends IService<EventHistory> {

    /**
     * 新增
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    void add(EventHistoryParam param);

    /**
     * 删除
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    void delete(EventHistoryParam param);

    /**
     * 更新
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    void update(EventHistoryParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    EventHistoryResult findBySpec(EventHistoryParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    List<EventHistoryResult> findListBySpec(EventHistoryParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
     LayuiPageInfo findPageBySpec(EventHistoryParam param);

}
