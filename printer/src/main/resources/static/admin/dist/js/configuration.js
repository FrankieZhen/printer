$(function () {
    //修改店铺信息
    $('#updateShopButton').click(function () {
        // $("#updateWebsiteButton").attr("disabled", true);
        //ajax提交数据
        var iscolorful = $('#iscolorful').val();
        var shopName = $('#shopName').val();
        var shopLocation = $('#shopLocation').val();

        if (validShopInfo(shopName,shopLocation,iscolorful)){

        var params = $("#shopInfoForm").serialize();
        $.ajax({
            type: "POST",
            url: "/admin/configurations/shopInfo",
            data: params,
            success: function (result) {
                if (result.resultCode == 200) {
                    swal("保存成功", {
                        icon: "success",
                    });
                }else {
                    swal(result.message, {
                        icon: "error",
                    });
                }
                ;
            },
            error: function () {
                swal("操作失败", {
                    icon: "error",
                });
            }
        });
        }
    });

    //新增店铺
    $('#addShopButton').click(function () {
        // $("#updateWebsiteButton").attr("disabled", true);
        //ajax提交数据
        var iscolorful = $('#iscolorful').val();
        var shopName = $('#shopName').val();
        var shopLocation = $('#shopLocation').val();

        if (validShopInfo(shopName,shopLocation,iscolorful)){

            var params = $("#shopInfoForm").serialize();
            $.ajax({
                type: "POST",
                url: "/admin/configurations/shopAdd",
                data: params,
                success: function (result) {
                    if (result.resultCode == 200) {
                        swal("保存成功", {
                            icon: "success",
                        });
                    }else {
                        swal(result.message, {
                            icon: "error",
                        });
                    }
                    ;
                },
                error: function () {
                    swal("操作失败", {
                        icon: "error",
                    });
                }
            });
        }
    });

    //价格信息
    $('#updatePriceButton').click(function () {
        // $("#updateUserInfoButton").attr("disabled", true);
        var params = $("#userInfoForm").serialize();
        // var singlePure = $('#singlePure').val();
        // var doublePure = $('#doublePure').val();
        // var singleColor = $('#singleColor').val();
        // var doubleColor = $('#doubleColor').val();
        // if(validPriceInfo(singlePure,doublePure,singleColor,doubleColor)){
            $.ajax({
                type: "POST",
                url: "/admin/configurations/price",
                data: params,
                success: function (result) {
                    if (result.resultCode == 200&& result.data) {
                        swal("保存成功", {
                            icon: "success",
                        });
                    }
                    else {
                        swal(result.message, {
                            icon: "error",
                        });
                    }
                    ;
                },
                error: function () {
                    swal("操作失败", {
                        icon: "error",
                    });
                }
            });
        // }
    });
    //修改底部设置
    $('#updateFooterButton').click(function () {
        // $("#updateFooterButton").attr("disabled", true);
        // var params = $("#footerForm").serialize();


//         if(navigator.geolocation){
//             navigator.geolocation.getCurrentPosition(onSuccess , onError);
//         }else{
//             alert("您的浏览器不支持使用HTML 5来获取地理位置服务");
//         }
// //定位数据获取成功响应
//         function  onSuccess(position){
//             alert('纬度: '          + position.coords.latitude          + '\n' +
//                 '经度: '         + position.coords.longitude         + '\n' +
//                 '海拔: '          + position.coords.altitude          + '\n' +
//                 '水平精度: '          + position.coords.accuracy          + '\n' +
//                 '垂直精度: ' + position.coords.altitudeAccura)
//         }
// //定位数据获取失败响应
//         function onError(error) {
//             switch(error.code)
//             {
//                 case error.PERMISSION_DENIED:
//                     alert("您拒绝对获取地理位置的请求");
//                     break;
//                 case error.POSITION_UNAVAILABLE:
//                     alert("位置信息是不可用的");
//                     break;
//                 case error.TIMEOUT:
//                     alert("请求您的地理位置超时");
//                     break;
//                 case error.UNKNOWN_ERROR:
//                     alert("未知错误");
//                     break;
//             }
//         }


        $.ajax({
            type: "POST",
            url: "/admin/configurations/map",
            data: {
                lat:$('li').attr('lat'),
                lng:$('li').attr('lng')
            },
            success: function (result) {
                if (result.resultCode == 200&& result.data) {
                    swal("保存成功", {
                        icon: "success",
                    });
                }
                else {
                    swal(result.message, {
                        icon: "error",
                    });
                }
                ;
            },
            error: function () {
                swal("操作失败", {
                    icon: "error",
                });
            }
        });
    });

})

function validShopInfo(shopName,shopLocation,iscolorful) {
    if (isNull(shopName) || shopName.trim().length < 1) {
        $('#updateShop-info').css("display", "block");
        $('#updateShop-info').html("请输入店铺名称");
        return false;
    }
    if (!validCN_ENString2_18(shopName)) {
        $('#updateShop-info').css("display", "block");
        $('#updateShop-info').html("请输入规范的店铺名称！(限2-18位的中英文数字)");
        return false;
    }
    if (isNull(shopLocation) || shopLocation.trim().length < 1) {
        $('#updateShop-info').css("display", "block");
        $('#updateShop-info').html("请输入店铺地址");
        return false;
    }
    if (isNull(iscolorful) || iscolorful.trim().length < 1) {
        $('#updateShop-info').css("display", "block");
        $('#updateShop-info').html("请输入彩色打印机栏！有输入1，无输入0");
        return false;
    }
    if (iscolorful != 1 && iscolorful != 0) {
        $('#updateShop-info').css("display", "block");
        $('#updateShop-info').html("彩色打印机栏仅能输入0或1！");
        return false;
    }

    return true;
}


function validPriceInfo(singlePure,doublePure,singleColor,doubleColor) {
    var iscolorful = $('#iscolorful').val();

    if (isNull(singlePure) || singlePure.trim().length < 1) {
        $('#updateShop-price').css("display", "block");
        $('#updateShop-price').html("请输入黑白单面的价格");
        return false;
    }

    if (isNull(doublePure) || doublePure.trim().length < 1) {
        $('#updateShop-price').css("display", "block");
        $('#updateShop-price').html("请输入黑白双面的价格");
        return false;
    }

    if (isNull(iscolorful) || iscolorful.trim().length < 1) {
        $('#updateShop-price').css("display", "block");
        $('#updateShop-price').html("请先设置是否有彩色打印机");
        return false;
    }

    if (iscolorful == 1 && (isNull(singleColor) || singleColor.trim().length < 1)) {
        $('#updateShop-price').css("display", "block");
        $('#updateShop-price').html("您设置了有彩色打印机，请输入彩色单面的价格");
        return false;
    }

    if (iscolorful == 1 && (isNull(doubleColor) || doubleColor.trim().length < 1)) {
        $('#updateShop-price').css("display", "block");
        $('#updateShop-price').html("您设置了有彩色打印机，请输入彩色双面的价格");
        return false;
    }

    if (isNull(iscolorful) || iscolorful.trim().length < 1) {
        $('#updateShop-price').css("display", "block");
        $('#updateShop-price').html("请输入彩色打印机栏！有输入1，无输入0");
        return false;
    }
    if (iscolorful != 1 && iscolorful != 0) {
        $('#updateShop-price').css("display", "block");
        $('#updateShop-price').html("彩色打印机栏仅能输入0或1！");
        return false;
    }
    //singlePure,doublePure,singleColor,doubleColor
    if (!validPrice(singlePure)||!validPrice(doublePure)||(!isNull(singleColor)&&!validPrice(singleColor))||(!isNull(doubleColor)&&!validPrice(doubleColor))) {
        $('#updateShop-price').css("display", "block");
        $('#updateShop-price').html("请输入规范的价格！（仅为数字，最长两位小数）");
        return false;
    }

}


