package cn.stylefeng.guns.modular.score.mapper;

import cn.stylefeng.guns.modular.score.entity.EventItem;
import cn.stylefeng.guns.modular.score.model.params.EventItemParam;
import cn.stylefeng.guns.modular.score.model.result.EventItemResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 事件类型 Mapper 接口
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
public interface EventItemMapper extends BaseMapper<EventItem> {

    /**
     * 获取列表
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    List<EventItemResult> customList(@Param("paramCondition") EventItemParam paramCondition);

    /**
     * 获取map列表
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") EventItemParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    Page<EventItemResult> customPageList(@Param("page") Page page, @Param("paramCondition") EventItemParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") EventItemParam paramCondition);

}
