$(document).ready(function() {
    var oTable = $('#employee-work-table').dataTable({
        "aaSorting": [[0, "asc"]],
        "bProcessing": false,
        "bServerSide": true,
        "bInfo": false,
        "sAjaxSource": "/employee/work/pagination",
        "fnServerData": function(sSource, aoData, fnCallback) {
            $.ajax({
                "url": sSource,
                "type": "GET",
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                }
            });
        },
        "aoColumns": [
            { "mData": "accountId" },
            { "mData": "username" },
            { "mData": "role" },
            { "mData": "todayTotal" },
            { "mData": "monthTotal" },
            {
                "mData": null,
                "fnRender": function (oObj, sType, sValue) {
                    var buttonHtml = '<a class="btn btn-info  btn-sm" href="/user/' + oObj.aData.accountId + '">查看详情</a>';

                    return buttonHtml; // 返回按钮的 HTML
                }
            }
        ]
    });

    /* 为打开和关闭详细信息添加事件侦听器 */
    $(document).on('click', '#dynamic-table tbody td img', function() {
        var nTr = $(this).parents('tr')[0]; // 获取当前行的 DOM 元素
        if (oTable.fnIsOpen(nTr)) {
            // 如果当前行已经展开，关闭它
            this.src = "/images/details_open.png"; // 更改图标为展开图标
            oTable.fnClose(nTr);
        } else {
            // 如果当前行未展开，展开它
            this.src = "/images/details_close.png"; // 更改图标为折叠图标
            //oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details'); // 调用 fnFormatDetails 函数生成展开行的内容
        }
    });

    // TODO 为查看详情添加事件
    $('#dynamic-table tbody').on('click', 'button', function() {
        var button = $(this);
        var nTr = button.closest('tr')[0];
        var aData = oTable.fnGetData(nTr); // 获取整行数据
        var status = button.data('status'); // 从按钮的 data-status 属性获取状态值

        var accountId = button.data('accountid');

        if (status === "disable") {
            //alert('解禁用户按钮被点击');
            // 执行解禁用户的逻辑
            $.ajax({
                type: "POST",
                url: "/employee/updateStatus",
                contentType: "application/json",
                data: JSON.stringify({
                    accountId: accountId,
                    status: "enable"
                }),
                success: function(response) {
                    if (response.code === 200) {
                        // 操作成功，更改按钮样式和内容
                        button.removeClass('btn-success').addClass('btn-danger');
                        button.text('禁用用户');
                        button.data('status', 'enable'); // 更新 data-status 属性
                        alert('用户已成功解禁');
                    } else {
                        // 操作失败，弹出错误信息
                        alert(response.message || '解禁用户失败');
                    }
                },
                dataType: "json"
            });
        } else if (status === "enable") {
            //alert('禁用用户按钮被点击');
            // 执行禁用用户的逻辑
            $.ajax({
                type: "POST",
                url: "/employee/updateStatus", // 修改为你的禁用接口
                contentType: "application/json",
                data: JSON.stringify({
                    accountId: accountId,
                    status: "disable"
                }),
                success: function(response) {
                    if (response.code === 200) {
                        // 操作成功，更改按钮样式和内容
                        button.removeClass('btn-danger').addClass('btn-success');
                        button.text('解禁用户');
                        button.data('status', 'disable'); // 更新 data-status 属性
                        alert('用户已成功禁用');
                    } else {
                        // 操作失败，弹出错误信息
                        alert(response.message || '禁用用户失败');
                    }
                },
                error: function() {
                    alert('网络错误，请稍后再试');
                }
            });
        }
    });
});
