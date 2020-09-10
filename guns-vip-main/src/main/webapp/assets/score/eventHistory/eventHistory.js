layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 历史事件管理
     */
    var EventHistory = {
        tableId: "eventHistoryTable"
    };

    /**
     * 初始化表格的列
     */
    EventHistory.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: 'ID'},
            {field: 'createTime', sort: true, title: '操作时间'},
            {field: 'itemId', sort: true, hide: true, title: '事件ID'},
            {field: 'itemName', sort: true, title: '事件名称'},
            {field: 'userId', sort: true, hide: true, title: '加分对象'},
            {field: 'userName', sort: true, title: '加分对象'},
            {field: 'preScore', sort: true, title: '历史积分'},
            {field: 'optScore', sort: true, title: '本次操作积分'},
            {field: 'sufScore', sort: true, title: '结果积分'},
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
            {field: 'createUser', sort: true, hide: true, title: '操作人员'},
            {field: 'createUserName', sort: true, title: '操作人员'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    EventHistory.search = function () {
        var queryData = {};


        table.reload(EventHistory.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    EventHistory.openAddDlg = function () {
        func.open({
            title: '添加历史事件',
            content: Feng.ctxPath + '/eventHistory/add',
            tableId: EventHistory.tableId
        });
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    EventHistory.openEditDlg = function (data) {
        func.open({
            title: '修改历史事件',
            content: Feng.ctxPath + '/eventHistory/edit?id=' + data.id,
            tableId: EventHistory.tableId
        });
    };


    /**
     * 导出excel按钮
     */
    EventHistory.exportExcel = function () {
        var checkRows = table.checkStatus(EventHistory.tableId);
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
    EventHistory.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/eventHistory/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(EventHistory.tableId);
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
        elem: '#' + EventHistory.tableId,
        url: Feng.ctxPath + '/eventHistory/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: EventHistory.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        EventHistory.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

        EventHistory.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        EventHistory.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + EventHistory.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            EventHistory.openEditDlg(data);
        } else if (layEvent === 'delete') {
            EventHistory.onDeleteItem(data);
        }
    });
});
