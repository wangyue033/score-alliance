package cn.stylefeng.guns.modular.score.mapper;

import cn.stylefeng.guns.modular.score.entity.EventHistory;
import cn.stylefeng.guns.modular.score.model.params.EventHistoryParam;
import cn.stylefeng.guns.modular.score.model.result.EventHistoryResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 历史事件 Mapper 接口
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
public interface EventHistoryMapper extends BaseMapper<EventHistory> {

    /**
     * 获取列表
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    List<EventHistoryResult> customList(@Param("paramCondition") EventHistoryParam paramCondition);

    /**
     * 获取map列表
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") EventHistoryParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    Page<EventHistoryResult> customPageList(@Param("page") Page page, @Param("paramCondition") EventHistoryParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") EventHistoryParam paramCondition);

}
