$(function () {
    $("#jqGrid").jqGrid({
        url: '/admin/order/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true, hidden: true},
            {label: '收货人姓名', name: 'recName', index: 'recName', width: 45},
            {label: '收货人电话', name: 'recPhone', index: 'recPhone', width: 45},
            {label: '收货人地址', name: 'recAddress', index: 'recAddress', width: 50},
            {label: '数量', name: 'number', index: 'number', width: 20},
            {label: '类型', name: 'type', index: 'type', width: 20},
            {label: '样式', name: 'style', index: 'style', width: 30},
            {label: '价格', name: 'price', index: 'price', width: 30},
            {label: '文件链接', name: 'fileName', index: 'fileName', width: 60 },
            {label: '文件链接', name: 'file', index: 'file', width: 60 ,hidden:true},
            {label: '取件方式', name: 'deliver', index: 'deliver', width: 40},
            {label: '状态', name: 'status', index: 'status', width: 30},
            {label: '订单创建时间', name: 'createTime', index: 'createTime', width: 70 ,formatter: timeFormatter}
        ],
        height: 700,
        rowNum: 10,
        rowList: [10, 20, 50],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: false,
        rownumWidth: 20,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});

            var ids = $("#jqGrid").getDataIDs();
            for(var i=0;i<ids.length;i++){
                var fileName = $("#jqGrid").jqGrid('getCell',ids[i],'fileName');
                var file = $("#jqGrid").jqGrid('getCell',ids[i],'file');
                // console.log(fileName + "," +file)
                $("#jqGrid").jqGrid('setCell', ids[i] , 'fileName' , '<a href="'+file+'" target="_blank">'+fileName+'</a>');
            }

        }
    });

    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });

    // function coverImageFormatter(cellvalue) {
    //     return "<img src='" + cellvalue + "' height=\"120\" width=\"160\" alt='coverImage'/>";
    // }

    function timeFormatter(timeValue) {
        return new Date(+new Date(new Date(timeValue).toJSON())+8*3600*1000).toISOString().replace(/T/g,' ').replace(/\.[\d]{3}Z/,'') ;
    }

    function statusFormatter(cellvalue) {
        if (cellvalue == '已完成') {
            return "";
        }
        else if (cellvalue == '已付款') {
            return "<button type=\"button\" class=\"btn btn-block btn-success btn-sm\" style=\"width: 50%;\">已付款</button>";
        }
    }

    function getHref(cellvalue){
        return "<a href=\"http://www.w3school.com.cn\" target=\"_blank\">cellvalue</a>"
    }

});

/**
 * 搜索功能
 */
function search() {
    //标题关键字
    var keyword = $('#keyword').val();
    if (!validLength(keyword, 20)) {
        swal("搜索字段长度过大!", {
            icon: "error",
        });
        return false;
    }
    //数据封装
    var searchData = {keyword: keyword};
    //传入查询条件参数
    $("#jqGrid").jqGrid("setGridParam", {postData: searchData});
    //点击搜索按钮默认都从第一页开始
    $("#jqGrid").jqGrid("setGridParam", {page: 1});
    //提交post并刷新表格
    $("#jqGrid").jqGrid("setGridParam", {url: '/admin/order/listWithKey'}).trigger("reloadGrid");
}

/**
 * jqGrid重新加载
 */
function reload() {
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        page: page
    }).trigger("reloadGrid");
}

function changeFinish() {
    // window.location.href = "/admin/blogs/edit";

    var ids = getSelectedRows();
    if (ids == null) {
        return;
    }
    for(var i=0;i<ids.length;i++){
        var status = $("#jqGrid").jqGrid('getCell',ids[i],'status');
        if(status == '未付款'||status == '已取消'||status == '已完成'||status == '已打印'){
            swal("选中记录状态不能有“"+status+"”", {
                icon: "warning",
            });
        }else {
            $.ajax({
                type: "POST",
                url: "/admin/order/finish",
                contentType:"application/json",
                async:false,  //同步方式发起请求
                data: JSON.stringify(ids),
                success: function (result) {
                    if (result.resultCode == 200) {
                        swal("修改成功", {
                            icon: "success",
                        });
                    }else {
                        swal(result.message, {
                            icon: "error",
                        });
                    }
                },
                error: function () {
                    swal("修改失败", {
                        icon: "error",
                    });
                }
            });
        }
    }

    // for(var i=0;i<ids.length;i++){
    //     console.log($("#jqGrid").jqGrid('getRowData',ids[i]))
    // }
}

function changeDeliver() {
    var ids = getSelectedRows();
    if (ids == null) {
        return;
    }
    for(var i=0;i<ids.length;i++){
        var status = $("#jqGrid").jqGrid('getCell',ids[i],'status');
        var deliver = $("#jqGrid").jqGrid('getCell',ids[i],'deliver');
        if(deliver !='送货上门' || status != '已付款'){
            swal("选中记录需取件方式为”送货上门“且状态是”已付款“", {
                icon: "warning",
            });
        }else {
            $.ajax({
                type: "POST",
                url: "/admin/order/deliver",
                contentType:"application/json",
                async:false,  //同步方式发起请求
                data: JSON.stringify(ids),
                success: function (result) {
                    if (result.resultCode == 200) {
                        swal("修改成功", {
                            icon: "success",
                        });
                    }else {
                        swal(result.message, {
                            icon: "error",
                        });
                    }
                },
                error: function () {
                    swal("修改失败", {
                        icon: "error",
                    });
                }
            });
        }
    }
}

function changeCancel() {
    var ids = getSelectedRows();
    if (ids == null) {
        return;
    }
    for(var i=0;i<ids.length;i++){
        var status = $("#jqGrid").jqGrid('getCell',ids[i],'status');
        if(status == '已取消'||status == '已完成'){
            swal("选中记录状态不能有“"+status+"”", {
                icon: "warning",
            });
        }else {
            $.ajax({
                type: "POST",
                url: "/admin/order/cancel",
                contentType:"application/json",
                async:false,  //同步方式发起请求
                data: JSON.stringify(ids),
                success: function (result) {
                    if (result.resultCode == 200) {
                        swal("修改成功", {
                            icon: "success",
                        });
                    }else {
                        swal(result.message, {
                            icon: "error",
                        });
                    }
                },
                error: function () {
                    swal("修改失败", {
                        icon: "error",
                    });
                }
            });
        }
    }
    // swal({
    //     title: "确认弹框",
    //     text: "确认要删除数据吗?",
    //     icon: "warning",
    //     buttons: true,
    //     dangerMode: true,
    // }).then((flag) => {
    //         if (flag) {
    //             $.ajax({
    //                 type: "POST",
    //                 url: "/admin/blogs/delete",
    //                 contentType: "application/json",
    //                 data: JSON.stringify(ids),
    //                 success: function (r) {
    //                     if (r.resultCode == 200) {
    //                         swal("删除成功", {
    //                             icon: "success",
    //                         });
    //                         $("#jqGrid").trigger("reloadGrid");
    //                     } else {
    //                         swal(r.message, {
    //                             icon: "error",
    //                         });
    //                     }
    //                 }
    //             });
    //         }
    //     }
    // );
}


function checkboxOnclick(checkbox) {

    if ( checkbox.checked == true){
        // console.log("触发选中事件")
        var ids = $("#jqGrid").getDataIDs();
        for(var i=0;i<ids.length;i++){
            var status = $("#jqGrid").jqGrid('getCell',ids[i],'status');
            if(status == '已取消'||status == '已完成'){
                $("#jqGrid").jqGrid("delRowData", ids[i]);
            }
        }
    }else{
        // console.log("触发取消选中事件")
        reload();
    }


}