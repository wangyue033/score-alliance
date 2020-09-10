package cn.stylefeng.guns.modular.score.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.score.entity.EventItem;
import cn.stylefeng.guns.modular.score.model.params.EventItemParam;
import cn.stylefeng.guns.modular.score.service.EventItemService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 事件类型控制器
 *
 * @author wangyeu
 * @Date 2020-09-10 09:32:19
 */
@Controller
@RequestMapping("/eventItem")
public class EventItemController extends BaseController {

    private String PREFIX = "/score/eventItem";

    @Autowired
    private EventItemService eventItemService;

    /**
     * 跳转到主页面
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/eventItem.html";
    }

    /**
     * 新增页面
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/eventItem_add.html";
    }

    /**
     * 编辑页面
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/eventItem_edit.html";
    }

    /**
     * 新增接口
     *
     * @author wangyeu
     * @Date 2020-09-10
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(EventItemParam eventItemParam) {
        this.eventItemService.add(eventItemParam);
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
    public ResponseData editItem(EventItemParam eventItemParam) {
        this.eventItemService.update(eventItemParam);
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
    public ResponseData delete(EventItemParam eventItemParam) {
        this.eventItemService.delete(eventItemParam);
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
    public ResponseData detail(EventItemParam eventItemParam) {
        EventItem detail = this.eventItemService.getById(eventItemParam.getId());
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
    public LayuiPageInfo list(EventItemParam eventItemParam) {
        return this.eventItemService.findPageBySpec(eventItemParam);
    }

}


