$(document).ready(function() {
    var oTable = $('#dynamic-table').dataTable({
        "aaSorting": [[0, "asc"]],
        "bProcessing": false,
        "bServerSide": true,
        "sAjaxSource": "/employee/pagination",
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
            { "mData": "username" },
            { "mData": "role" },
            { "mData": "phone" },
            { "mData": "email" },
            {
                "mData": "status",
                "fnRender": function(aData, type, full) {
                    var status = aData.aData.status;
                    var buttonHtml = '';
                    if (status === "disable") {
                        buttonHtml = '<button class="btn btn-success btn-sm">解禁用户</button>';
                    } else if (status === "enable") {
                        buttonHtml = '<button class="btn btn-danger btn-sm">禁用用户</button>';
                    } else {
                        buttonHtml = status;
                    }
                    return buttonHtml;
                }
            }
        ],
        "fnDrawCallback": function() {
            oTable.$('tr').each(function() {
                var nTr = this;
                if (!oTable.fnIsOpen(nTr)) {
                    oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
                }
            });
        }
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
            oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details'); // 调用 fnFormatDetails 函数生成展开行的内容
        }
    });

    // TODO 为权限设置按钮添加事件监听器
    $('#dynamic-table tbody').on('click', 'button', function() {
        var nTr = $(this).closest('tr')[0];
        var aData = oTable.fnGetData(nTr);
        var status = aData.status;
        if (status === "disable") {
            alert('解禁用户按钮被点击');
            // 执行解禁用户的逻辑
        } else if (status === "enable") {
            alert('禁用用户按钮被点击');
            // 执行禁用用户的逻辑
        }
    });
});
