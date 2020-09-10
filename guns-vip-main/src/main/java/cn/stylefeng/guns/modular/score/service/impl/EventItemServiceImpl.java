package cn.stylefeng.guns.modular.score.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.score.entity.EventItem;
import cn.stylefeng.guns.modular.score.mapper.EventItemMapper;
import cn.stylefeng.guns.modular.score.model.params.EventItemParam;
import cn.stylefeng.guns.modular.score.model.result.EventItemResult;
import  cn.stylefeng.guns.modular.score.service.EventItemService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 事件类型 服务实现类
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
@Service
public class EventItemServiceImpl extends ServiceImpl<EventItemMapper, EventItem> implements EventItemService {

    @Override
    public void add(EventItemParam param){
        EventItem entity = getEntity(param);
        entity.setState(1);
        this.save(entity);
    }

    @Override
    public void delete(EventItemParam param){
//        this.removeById(getKey(param));
        EventItem oldEntity = getOldEntity(param);
        EventItem newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        newEntity.setState(0);
        this.updateById(newEntity);
    }

    @Override
    public void update(EventItemParam param){
        EventItem oldEntity = getOldEntity(param);
        EventItem newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public EventItemResult findBySpec(EventItemParam param){
        return null;
    }

    @Override
    public List<EventItemResult> findListBySpec(EventItemParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(EventItemParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(EventItemParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private EventItem getOldEntity(EventItemParam param) {
        return this.getById(getKey(param));
    }

    private EventItem getEntity(EventItemParam param) {
        EventItem entity = new EventItem();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
