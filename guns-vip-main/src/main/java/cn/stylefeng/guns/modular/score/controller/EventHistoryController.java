package cn.stylefeng.guns.modular.score.controller;

import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.score.entity.EventHistory;
import cn.stylefeng.guns.modular.score.entity.EventItem;
import cn.stylefeng.guns.modular.score.model.params.EventHistoryParam;
import cn.stylefeng.guns.modular.score.service.EventHistoryService;
import cn.stylefeng.guns.modular.score.service.EventItemService;
import cn.stylefeng.guns.sys.modular.system.entity.User;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.guns.sys.modular.system.warpper.UserWrapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.datascope.DataScope;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * 历史事件控制器
 *
 * @author wangyeu
 * @Date 2020-09-10 09:34:21
 */
@Controller
@RequestMapping("/eventHistory")
public class EventHistoryController extends BaseController {

    private String PREFIX = "/score/eventHistory";

    @Autowired
    private EventHistoryService eventHistoryService;

    @Autowired
    private EventItemService eventItemService;

    @Autowired
    private UserService userService;


    /**
     * 跳转到主页面
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/eventHistory.html";
    }

    /**
     * 新增页面
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("/add")
    public String add(Model model) {
        /*事件列表*/
        QueryWrapper<EventItem> eventItemQueryWrapper = new QueryWrapper<EventItem>();
        eventItemQueryWrapper.eq("state", 1);
        final List<EventItem> eventItemList = eventItemService.list(eventItemQueryWrapper);
        model.addAttribute("eventItemList", eventItemList);

        /*人员列表*/
        Long deptId = LoginContextHolder.getContext().getUser().getDeptId();
        DataScope dataScope = new DataScope(LoginContextHolder.getContext().getDeptDataScope());
        List<User> users = userService.selectUsersWithList(dataScope, "", "beginTime", "endTime", deptId);
        model.addAttribute("users", users);

        return PREFIX + "/eventHistory_add.html";
    }

    /**
     * 编辑页面
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/eventHistory_edit.html";
    }

    /**
     * 新增接口
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(EventHistoryParam eventHistoryParam) {
        this.eventHistoryService.add(eventHistoryParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(EventHistoryParam eventHistoryParam) {
        this.eventHistoryService.update(eventHistoryParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(EventHistoryParam eventHistoryParam) {
        this.eventHistoryService.delete(eventHistoryParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(EventHistoryParam eventHistoryParam) {
        EventHistory detail = this.eventHistoryService.getById(eventHistoryParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(EventHistoryParam eventHistoryParam) {
        return this.eventHistoryService.findPageBySpec(eventHistoryParam);
    }

}


