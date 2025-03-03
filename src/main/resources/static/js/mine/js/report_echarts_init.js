function initCollectionPieChart(year, month) {
    // 初始化图表
    var chartDom = document.getElementById('collectionPieChart');
    var myChart1 = echarts.init(chartDom);

    // 定义初始配置
    var option = {
        tooltip: {
            trigger: 'item'
        },
        legend: {
            top: '5%',
            left: 'center'
        },
        series: [
            {
                name: 'Access From',
                type: 'pie',
                radius: ['40%', '70%'],
                center: ['50%', '70%'],
                startAngle: 180,
                endAngle: 360,
                data: [] // 初始数据为空
            }
        ]
    };

    // 设置初始配置
    myChart1.setOption(option);

    // 使用 $.ajax 获取数据
    $.ajax({
        type: "GET",
        url: '/chart/reportCollectionPointsChartByMonth?year=' + year + '&month=' + month, // 后端接口地址
        contentType: "application/json",
        success: function (response) {
            if (response.code === 200) {
                // 使用后端返回的数据更新图表
                myChart1.setOption({
                    series: [
                        {
                            data: response.data // 使用后端返回的数据
                        }
                    ]
                });
            } else {
                alert(response.message); // 如果返回错误，弹出提示
            }
        },
        error: function (xhr, status, error) {
            alert("请求失败：" + error); // 网络或接口错误提示
        },
        dataType: "json"
    });

}

function initDisposalPieChart(year, month) {
    // 初始化图表
    var chartDom = document.getElementById('disposalPieChart');
    var myChart = echarts.init(chartDom);

    // 定义初始配置（不包含数据）
    var option = {
        title: {
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left'
        },
        series: [
            {
                name: 'Access From',
                type: 'pie',
                radius: '50%',
                data: [], // 初始数据为空
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 设置初始配置
    myChart.setOption(option);

    // 使用 $.ajax 获取数据
    $.ajax({
        type: "GET",
        url: '/chart/reportDisposalMethodsChartByMonth?year=' + year + '&month=' + month, // 后端接口地址
        contentType: "application/json",
        success: function (response) {
            if (response.code === 200) {
                // 使用后端返回的数据更新图表
                myChart.setOption({
                    series: [
                        {
                            data: response.data // 使用后端返回的数据
                        }
                    ]
                });
            } else {
                alert(response.message); // 如果返回错误，弹出提示
            }
        },
        error: function (xhr, status, error) {
            alert("请求失败：" + error); // 网络或接口错误提示
        },
        dataType: "json"
    });


}

function initTimeBarChart() {
    var chartDom = document.getElementById('TimeBarChart');
    var myChart = echarts.init(chartDom);
    var initialOption;

    // 定义初始配置
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['Total Waste'],
            orient: 'vertical',
            left: 'left'
        },
        xAxis: {
            type: 'category',
            data: [] // 初始数据为空
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name: 'Total Waste',
                type: 'bar',
                data: [] // 初始数据为空
            }
        ]
    };

    // 设置初始配置
    myChart.setOption(option);

    // 使用 $.ajax 获取初始数据
    $.ajax({
        type: "GET",
        url: "/chart/reportTimeBarChart", // 后端接口地址
        success: function (response) {
            if (response.code === 200) {
                var initialData = response.data;
                initialOption = {
                    xAxis: {
                        data: initialData.categories
                    },
                    series: [
                        {
                            name: 'Total Waste',
                            type: 'bar',
                            data: initialData.seriesData
                        }
                    ]
                };
                myChart.setOption(initialOption);
            } else {
                alert(response.message); // 如果返回错误，弹出提示
            }
        },
        error: function (xhr, status, error) {
            alert("请求失败：" + error); // 网络或接口错误提示
        },
        dataType: "json"
    });

    // 监听点击事件，实现钻取功能
    myChart.on('click', function (event) {

        if (myChart.getOption().graphic && myChart.getOption().graphic.length > 0) {
            // 已经处于二级图表，不再下钻
            return;
        }
        if (event.name) {
            // 使用 $.ajax 获取钻取数据
            $.ajax({
                type: "GET",
                url: '/chart/drilldownReportTimeBarChartData?groupId=' + event.name, // 后端接口地址
                success: function (drilldownResponse) {
                    if (drilldownResponse.code === 200) {
                        var drilldownData = drilldownResponse.data;
                        myChart.setOption({
                            xAxis: {
                                data: drilldownData.categories
                            },
                            series: [
                                {
                                    name: 'Total Waste',
                                    type: 'bar',
                                    data: drilldownData.seriesData
                                }
                            ],
                            graphic: [
                                {
                                    type: 'text',
                                    left: 50,
                                    top: 20,
                                    style: {
                                        text: 'Back',
                                        fontSize: 18
                                    },
                                    onclick: function () {
                                        // 返回初始数据
                                        myChart.setOption(initialOption);
                                    }
                                }
                            ]
                        });
                    } else {
                        alert(drilldownResponse.message);
                    }
                },
                error: function (xhr, status, error) {
                    alert("请求失败：" + error);
                },
                dataType: "json"
            });
        }
    });
}

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

        initCollectionPieChart(year, month);
        initDisposalPieChart(year, month);
        initTimeBarChart(year, month);

    });

    // 设置默认值为当前月份
    $('#datePickerInput').datepicker('setDate', currentDate);
    $('#datePickerInput').val(currentDate); // 手动更新输入框的值

    // 触发一次事件以处理默认值
    $('#datePickerInput').trigger('changeDate');
});




