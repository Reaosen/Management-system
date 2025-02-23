$(document).ready(function() {
    $('#disposalPointId').change(function() {
        const selectedDisposalPointId = $(this).val();
        const wasteRecordSelect = $('#wasteRecordId');

        // 清空第二个下拉菜单
        wasteRecordSelect.empty().append('<option value="">请选择收集编号</option>');

        // 如果有选中的处置点 ID，则通过 AJAX 请求获取对应的废弃物记录
        if (selectedDisposalPointId) {
            $.ajax({
                url: '/waste/disposal/form/secondaryMenu',
                type: 'GET',
                data: { disposalPointId: selectedDisposalPointId },
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
