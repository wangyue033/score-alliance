package cn.stylefeng.guns.modular.score.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.score.entity.EventHistory;
import cn.stylefeng.guns.modular.score.entity.EventItem;
import cn.stylefeng.guns.modular.score.mapper.EventHistoryMapper;
import cn.stylefeng.guns.modular.score.model.params.EventHistoryParam;
import cn.stylefeng.guns.modular.score.model.result.EventHistoryResult;
import cn.stylefeng.guns.modular.score.service.EventHistoryService;
import cn.stylefeng.guns.modular.score.service.EventItemService;
import cn.stylefeng.guns.sys.modular.system.entity.User;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.RollbackException;
import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 历史事件 服务实现类
 * </p>
 *
 * @author wangyeu
 * @since 2020-09-10
 */
@Service
public class EventHistoryServiceImpl extends ServiceImpl<EventHistoryMapper, EventHistory> implements EventHistoryService {

    @Autowired
    private EventItemService eventItemService;

    @Autowired
    private UserService userService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(EventHistoryParam param) {
        EventHistory entity = getEntity(param);
        EventItem eventItem = eventItemService.getById(param.getItemId());
        entity.setItemName(eventItem.getName());
        Integer score = eventItem.getScore();

        User user = userService.getById(param.getUserId());
        Integer totalScore = null == user.getTotalScore() ? 0 : user.getTotalScore();

        if (ObjectUtil.isNotNull(totalScore)) {
            entity.setPreScore(totalScore);
            Integer sufScore = totalScore + score;
            entity.setSufScore(sufScore);
            entity.setOptScore(score);
            user.setTotalScore(sufScore);
        }
        userService.updateById(user);
        entity.setState(1);
        this.save(entity);
    }

    @Override
    public void delete(EventHistoryParam param) {
        this.removeById(getKey(param));
    }

    @Override
    public void update(EventHistoryParam param) {
        EventHistory oldEntity = getOldEntity(param);
        EventHistory newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public EventHistoryResult findBySpec(EventHistoryParam param) {
        return null;
    }

    @Override
    public List<EventHistoryResult> findListBySpec(EventHistoryParam param) {
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(EventHistoryParam param) {
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(EventHistoryParam param) {
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private EventHistory getOldEntity(EventHistoryParam param) {
        return this.getById(getKey(param));
    }

    private EventHistory getEntity(EventHistoryParam param) {
        EventHistory entity = new EventHistory();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
