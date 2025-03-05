// 初始化饼图实例
function initDonutChart() {
    var chartDom = document.getElementById('wasteType-PieChart');
    var myChart1 = echarts.init(chartDom);

    var myData;
    $.ajax({
        type: "GET",
        url: "/chart/indexWasteTypePieChartData",
        contentType: "application/json",
        success: function (response) {
            if (response.code === 200) {
                myData = response.data;
                myChart1.setOption({
                    series: [
                        {
                            data: myData  // 使用后端返回的数据
                        }
                    ]
                });
            } else {
                alert(response.message);
            }
        },
        dataType: "json"
    });

    var option1 = {
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
                type: 'pie',
                radius: '50%',
                data: [
                    myData
                ],
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

    // 使用配置项设置饼图
    myChart1.setOption(option1);
}

// 初始化折线图实例
function initLineChart(chartType) {
    var myChart2 = echarts.init(document.getElementById('main-chart-container'));

    // 默认配置（不包含动态数据）
    var option2 = {
        title: {
            text: '周对比折线图'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: []  // 动态加载
        },
        xAxis: {
            type: 'category',
            data: []  // 动态加载
        },
        yAxis: {
            type: 'value'
        },
        series: []  // 动态加载
    };

    // 设置默认配置
    myChart2.setOption(option2);

    var dataType = "collection";
    if (chartType === "transport") {
        dataType = "transport";
    } else if (chartType === "disposal") {
        dataType = "disposal";
    }

    // 从后端获取数据
    $.ajax({
        type: "GET",
        url: "/chart/indexLineChartData/" + dataType,
        success: function (response) {
            if (response.code === 200) {
                var data = response.data;

                // 动态更新图表配置
                myChart2.setOption({
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
                alert(response.message);
            }
        },
        error: function (xhr, status, error) {
            alert("请求失败：" + error);
        }
    });
}

// 在页面加载完成后初始化图表
document.addEventListener('DOMContentLoaded', function () {
    initDonutChart();
    initLineChart();
});

// 绑定按钮点击事件
$(document).ready(function () {
    $(".revenue-nav li a").click(function (e) {
        e.preventDefault(); // 阻止默认行为
        // 移除所有按钮的active类
        $(".revenue-nav li").removeClass("active");
        // 为当前点击的按钮添加active类
        $(this).parent().addClass("active");
        var chartType = $(this).data("chart-type"); // 获取按钮的data-chart-type属性
        initLineChart(chartType); // 根据按钮类型初始化图表
    });
});
