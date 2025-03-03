function initLineChart(year, month) {
    var chartDom = document.getElementById('waste-chart');
    var myChart = echarts.init(chartDom);

    // 默认的图表配置（在数据加载完成前显示）
    var option = {
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: [] // 初始为空，稍后动态设置
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: [] // 初始为空，稍后动态设置
        },
        yAxis: {
            type: 'value'
        },
        series: [] // 初始为空，稍后动态设置
    };

    // 设置默认配置
    myChart.setOption(option);

    if (year === undefined || month === undefined) {
        year = 2025;
        month = 3;
    }


    // 使用 jQuery 的 $.ajax 方法从后端获取数据
    $.ajax({
        url: '/chart/wasteChartByMonth?year=' + year + '&month=' + month,
        type: 'GET',
        dataType: 'json', // 指定返回的数据类型为 JSON
        success: function(response) {
            // 检查后端返回的状态码
            if (response.code === 200) {
                var data = response.data;

                // 动态更新图表配置
                myChart.setOption({
                    legend: {
                        data: data.series.map(series => series.name)
                    },
                    xAxis: {
                        data: data.categories
                    },
                    series: data.series.map(series => ({
                        name: series.name,
                        type: 'line',
                        data: series.data,
                        areaStyle: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                { offset: 0, color: 'rgba(90, 188, 223, 0.4)' },
                                { offset: 1, color: 'rgba(90, 188, 223, 0)' }
                            ])
                        }
                    }))
                });
            } else {
                // 如果后端返回的状态码不是 200，显示错误信息
                alert(response.message || "Failed to load data.");
            }
        },
        error: function(xhr, status, error) {
            // 网络请求失败时的处理
            alert("请求失败：" + (xhr.responseText || error));
        }
    });
}

// // 在页面加载完成后初始化图表
// $(document).ready(function () {
//     initLineChart();
// });

$(document).ready(function () {

    // 获取当前日期并格式化为 yyyy/mm
    const today = new Date();
    const currentYear = today.getFullYear();
    const currentMonth = ("0" + (today.getMonth() + 1)).slice(-2); // 月份从 0 开始，需要加 1，并确保是两位数字

    // 使用传统的字符串拼接
    const currentDate = currentYear + "/" + currentMonth;


    // 初始化日期选择器
    $('#datePickerInput').datepicker({
        format: 'yyyy/mm', // 设置日期格式为年/月
        minViewMode: 1,    // 仅选择月份
        autoclose: true,   // 选择后自动关闭
        language: 'zh-CN'  // 设置语言为中文
    }).on('changeDate', function (e) {
        // 获取输入框的值
        const selectedDate = $('#datePickerInput').val();

        // 解析年份和月份
        const [year, month] = selectedDate.split('/').map(Number);

        // 调用其他函数进行处理
        initLineChart(year, month);
    });

    // 设置默认值为当前月份
    $('#datePickerInput').datepicker('setDate', currentDate);
    $('#datePickerInput').val(currentDate); // 手动更新输入框的值

    // 触发一次事件以处理默认值
    $('#datePickerInput').trigger('changeDate');
});




