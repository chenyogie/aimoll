function deptFormat(value,row,index){
    return value?value.name:"";
}
function imgFormat(value,row,index){
    return `<img src='${value}' alt='无图片' width="50px" height="50px"/>`;
}

$(function () {

    /*为每一个带有data-method属性的a标签绑定click事件*/
    $("a[data-method]").on("click",function () {
        /*获取方法的名称*/
        let methodName = $(this).data("method");
        /*调用方法*/
        window.mymethod[methodName]();
    });

    /*拿到常用的组件*/
    let $employeeGrid = $("#employeeGrid");
    let $searchForm = $("#searchForm");

    /*方法的定义*/
    mymethod={
        search(){
            /**
             * serializeObject是easyui/plugin/jquery.jdirk.js下的方法，
             * 功能就是拿到一个form表单中的所有数据，（根据name属性）封装成json对象
             */
           let params = $searchForm.serializeObject();
           $employeeGrid.datagrid("load",params);/*重新加载数据（重新发送请求）*/
        }
    };
});