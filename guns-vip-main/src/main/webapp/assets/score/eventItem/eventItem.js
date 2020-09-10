layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 事件类型管理
     */
    var EventItem = {
        tableId: "eventItemTable"
    };

    /**
     * 初始化表格的列
     */
    EventItem.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: 'ID'},
            {field: 'name', sort: true, title: '事件项'},
            {field: 'score', sort: true, title: '分值'},
            // {field: 'eventType', sort: true, title: '事件类型(1：积极事件-加分项；0：消极事件-减分项)'},
            {
                field: 'eventType', sort: true, align: "center", title: '事件类型', templet: function (d) {
                    if (d.eventType === 1) {
                        return "积极事件-加分项";
                    } else {
                        return "消极事件-减分项";
                    }
                }
            },
            {field: 'remark', sort: true, title: '说明'},
            // {field: 'state', sort: true, title: '状态(1:有效，0：无效)'},
            {
                field: 'state', sort: true, align: "center", title: '状态', templet: function (d) {
                    if (d.state === 1) {
                        return "有效";
                    } else {
                        return "无效";
                    }
                }
            },
            {field: 'createUserName', sort: true, title: '模型创建者'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    EventItem.search = function () {
        var queryData = {};


        table.reload(EventItem.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    EventItem.openAddDlg = function () {
        func.open({
            title: '添加事件类型',
            content: Feng.ctxPath + '/eventItem/add',
            tableId: EventItem.tableId
        });
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    EventItem.openEditDlg = function (data) {
        func.open({
            title: '修改事件类型',
            content: Feng.ctxPath + '/eventItem/edit?id=' + data.id,
            tableId: EventItem.tableId
        });
    };


    /**
     * 导出excel按钮
     */
    EventItem.exportExcel = function () {
        var checkRows = table.checkStatus(EventItem.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    EventItem.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/eventItem/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(EventItem.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + EventItem.tableId,
        url: Feng.ctxPath + '/eventItem/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: EventItem.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        EventItem.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

        EventItem.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        EventItem.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + EventItem.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            EventItem.openEditDlg(data);
        } else if (layEvent === 'delete') {
            EventItem.onDeleteItem(data);
        }
    });
});
