$(document).ready(function() {
    $('#collectionPointId').change(function() {
        const selectedCollectionPointId = $(this).val();
        const wasteRecordSelect = $('#wasteRecordId');

        // 清空第二个下拉菜单
        wasteRecordSelect.empty().append('<option value="">请选择收集编号</option>');

        // 如果有选中的处置点 ID，则通过 AJAX 请求获取对应的废弃物记录
        if (selectedCollectionPointId) {
            $.ajax({
                url: '/waste/transportation/form/secondaryMenu',
                type: 'GET',
                data: { collectionPointId: selectedCollectionPointId },
                success: function(data) {
                    data.forEach(function(record) {
                        wasteRecordSelect.append(`<option value="${record.wasteRecordId}">${record.wasteRecordId}</option>`);
                    });
                },
                error: function() {
                    alert("加载失败，请稍后再试！");
                }
            });
        }
    });
});
