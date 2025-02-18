$(document).ready(function () {
    var oTable = $('#waste-collection-table').dataTable({
        "aaSorting": [[0, "asc"]],
        "bProcessing": false,
        "bServerSide": true,
        "bInfo": false,
        "sAjaxSource": "/waste/transportation/pagination",
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
            {"mData": "transportId"},
            {"mData": "wasteType"},
            {"mData": "weight"},
            {"mData": "transportusername"},
            {"mData": "collectionPoint"},
            {"mData": "disposalPoint"},
            {"mData": "transportVehicle"},
            {"mData": "transportTime"},
            {
                "mData": null,
                "fnRender": function (oObj, sType, sValue) {
                    var transportId = oObj.aData.transportId;
                    var buttonHtml = '<button class="btn btn-info  btn-sm">查看详情</button>';

                    return buttonHtml; // 返回按钮的 HTML
                }
            }
        ]
    });

    /* 为打开和关闭详细信息添加事件侦听器 */
    $(document).on('click', '#waste-collection-table tbody td img', function () {
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

    $('#waste-collection-table tbody').on('click', 'button', function () {
        var button = $(this);
        var nTr = button.closest('tr')[0];
        var aData = oTable.fnGetData(nTr); // 获取整行数据
        var transportId = aData.transportId;

        $.ajax({
            type: "GET",
            url: "/waste/transportation/" + transportId,
            contentType: "application/json",
            data: JSON.stringify({
            }),
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
