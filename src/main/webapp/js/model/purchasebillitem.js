function formatStatus(value) {
    switch (value) {
        case -1:
            return "<span style='color: grey;'><del>&nbsp;作&emsp;废&nbsp;</del></span>";
            break;
        case 0:
            return "<span style='color: red;'>&nbsp;待&emsp;审&nbsp;</span>";
            break;
        case 1:
            return "<span style='color: green;'>&nbsp;已&emsp;审&nbsp;</span>";
            break;
    }
}

$(function () {


    /*拿到常用的组件*/
    let purchasebillitemGrid = $("#purchasebillitemGrid");
    let searchForm = $("#searchForm");
    let chartDialog = $("#chartDialog");


    purchasebillitemGrid.datagrid({
        rownumbers: true, // 行号
        remoteSort: false, //远程排序
        nowrap: false,
        fit: true,
        fitColumns: true,
        toolbar: "#gridTools",
        url: '/purchasebillitem/findItems',
        //所有的列的字段
        columns: [[
            {field: 'id', title: '编号', width: 100, align: "center"},
            {field: 'supplierName', title: '供应商', width: 100, align: "center"},
            {field: 'buyerName', title: '采购员', width: 100, align: "center"},
            {field: 'productName', title: '产品', width: 100, align: "center"},
            {field: 'productTypeName', title: '产品类型', width: 100, align: "center"},
            {field: 'vdate', title: '日期', width: 100, align: "center"},
            {field: 'price', title: '单价', width: 100, align: "center"},
            {field: 'num', title: '数量', width: 100, align: "center"},
            {field: 'amount', title: '小计', width: 100, align: "center"},
            {field: 'status', title: '状态', formatter: formatStatus, width: 100, align: "center"}
        ]],
        //分组字段
        groupField: 'groupField',
        view: groupview, //支持分组视图功能
        //分组格式化
        // value:就是当前groupField分组的值
        // rows:当前这一组的所有行
        groupFormatter: function (value, rows) {
            var totalNum = 0;
            var totalAmount = 0;
            for (let r of rows) {
                totalNum += r.num;
                totalAmount += r.amount;
            }
            return `${value} - 共${rows.length}条记录 <span style="color: green">共${totalNum}个商品 </span>
                    <span style="color: red">总金额:${totalAmount}</span>`;
        }
    });

    /*为每一个带有data-method属性的a标签绑定click事件*/
    $("a[data-method]").on("click", function () {
        /*获取方法的名称*/
        let methodName = $(this).data("method");
        /*调用方法*/
        window.mymethod[methodName]();
    });
    /*方法的定义*/
    mymethod = {
        search() {
            /**
             * serializeObject是easyui/plugin/jquery.jdirk.js下的方法，
             * 功能就是拿到一个form表单中的所有数据，（根据name属性）封装成json对象
             */
            let params = searchForm.serializeObject();
            purchasebillitemGrid.datagrid("load", params);/*重新加载数据（重新发送请求）*/
        },
        chartMethod(){
            //打开咱们的弹出框
            chartDialog.dialog("center").dialog("open");
            //获取到表单中的所有值
            var params = searchForm.serializeObject();
            //请求的时候把值传到后台
            $.post("/purchasebillitem/findCharts",params,function(result){
                //展示图表
                Highcharts.chart('container', {
                    chart: {
                        type: 'pie',
                        options3d: {
                            enabled: true,
                            alpha: 45, //倾斜度
                            beta: 0
                        }
                    },
                    title: {
                        text: ''
                    },
                    //鼠标移上去后显示的数据
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            //是否自己可以选择
                            allowPointSelect: true,
                            //鼠标指上来后的样式
                            cursor: 'pointer',
                            depth: 35, //深度
                            dataLabels: {
                                enabled: true,
                                format: '{point.name}'
                            }
                        }
                    },
                    series: [{
                        type: 'pie',
                        name: '当前项目占比',
                        data: result
                    }]
                });
            })
        }
    };
});



