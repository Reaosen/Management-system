$(document).ready(function () {
    var oTable = $('#waste-disposal-table').dataTable({
        "aaSorting": [[0, "asc"]],
        "bProcessing": false,
        "bServerSide": true,
        "bInfo": false,
        "sAjaxSource": "/waste/unpaid/pagination",
        "fnServerData": function (sSource, aoData, fnCallback) {
            $.ajax({
                "url": sSource,
                "type": "GET",
                "data": aoData,
                "success": function (json) {
                    fnCallback(json);
                }
            });
        },
        "aoColumns": [
            {"mData": "wasteRecordId"},
            {"mData": "wasteType"},
            {"mData": "disposalMethod"},
            {"mData": "budget"},
            {
                "mData": "payStatus",
                "fnRender": function (oObj, sType, sValue) {
                    if (oObj.aData.payStatus == "未支付"){
                        var html = '<span class="badge badge-important">未支付</span><a href="/weChatPay/'+ oObj.aData.wasteRecordId + '">  去支付>></a>';
                    }else if (oObj.aData.payStatus == "已支付"){
                        var html = '<span class="badge badge-success">已支付</span>'
                    }else if (oObj.aData.payStatus == "已入账"){
                        var html = '<span class="badge badge-success">已入账</span>'
                    }else if (oObj.aData.payStatus == "未入账"){
                        var html = '<span class="badge badge-warning">未入账</span>'
                    }


                    return html; // 返回按钮的 HTML
                }
            },
            {"mData": "disposalPoint"},
            {"mData": "disposalusername"},
            {"mData": "disposalTime"},
            {
                "mData": null,
                "fnRender": function (oObj, sType, sValue) {
                    var buttonHtml = '<a class="btn btn-info  btn-sm" href="/waste/' + oObj.aData.wasteRecordId + '">查看详情</a>';

                    return buttonHtml; // 返回按钮的 HTML
                }
            }
        ]
    });

    /* 为打开和关闭详细信息添加事件侦听器 */
    $(document).on('click', '#waste-disposal-table tbody td img', function () {
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

    $('#waste-disposal-table tbody').on('click', 'button', function () {
        var button = $(this);
        var nTr = button.closest('tr')[0];
        var aData = oTable.fnGetData(nTr); // 获取整行数据
        var wasteRecordId = aData.wasteRecordId;

        $.ajax({
            type: "GET",
            url: "/waste/" + wasteRecordId,
            contentType: "application/json",
            data: JSON.stringify({}),
            success: function (response) {
                if (response.code === 200) {

                } else {
                    // 操作失败，弹出错误信息
                    alert(response.message || '禁用用户失败');
                }
            },
            error: function () {
                alert('网络错误，请稍后再试');
            }
        });
    });
});
