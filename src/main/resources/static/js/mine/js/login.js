// 登录函数
function login() {
    // 获取用户输入的 email 和 password
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // 发送 POST 请求到后端进行登录
    $.ajax({
        type: "POST",
        url: "/login",
        contentType: "application/json",
        data: JSON.stringify({
            "email": email,
            "password": password
        }),
        success: function (response) {
            if (response.code === 200) {
                window.location.href = "/";
            } else {
                alert(response.message);
            }
        },
        dataType: "json"
    });
}
