function deleteCollection(id) {
    $.ajax({
        url: `/waste/collection/delete/${id}`, // 请求的 URL
        type: 'DELETE', // 请求方法
        contentType: 'application/json', // 请求头的 Content-Type
        success: function(response) {
            // 请求成功的回调
            if(response.code === 200){
                window.location.href = "/waste/collection";
            } else {
                alert(response.message);
            }
        },
        error: function(xhr, status, error) {
            // 请求失败的回调
            if (xhr.responseJSON) {
                alert(xhr.responseJSON.message); // 提示后端返回的错误信息
            } else {
                alert("发生错误，请稍后再试");
            }
        }
    });
}

function deleteTransportation(id) {
    $.ajax({
        url: `/waste/transportation/delete/${id}`, // 请求的 URL
        type: 'DELETE', // 请求方法
        contentType: 'application/json', // 请求头的 Content-Type
        success: function(response) {
            // 请求成功的回调
            if(response.code === 200){
                window.location.href = "/waste/collection";
            } else {
                alert(response.message);
            }
        },
        error: function(xhr, status, error) {
            // 请求失败的回调
            if (xhr.responseJSON) {
                alert(xhr.responseJSON.message); // 提示后端返回的错误信息
            } else {
                alert("发生错误，请稍后再试");
            }
        }
    });
}

function deleteDisposal(id) {
    $.ajax({
        url: `/waste/disposal/delete/${id}`, // 请求的 URL
        type: 'DELETE', // 请求方法
        contentType: 'application/json', // 请求头的 Content-Type
        success: function(response) {
            // 请求成功的回调
            if(response.code === 200){
                window.location.href = "/waste/collection";
            } else {
                alert(response.message);
            }
        },
        error: function(xhr, status, error) {
            // 请求失败的回调
            if (xhr.responseJSON) {
                alert(xhr.responseJSON.message); // 提示后端返回的错误信息
            } else {
                alert("发生错误，请稍后再试");
            }
        }
    });
}
