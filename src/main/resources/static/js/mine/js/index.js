// 引入 js-cookie 库
import Cookies from '/js/mine/js/js.cookie.min.mjs';
// 引入 jwtUtils 工具
import jwtUtils from '/js/mine/utils/jwtUtils.js';

document.addEventListener('DOMContentLoaded', function () {
    // 检查 Token, 加载即运行
    const token = Cookies.get('token');
    if (!token) {
        // 如果没有 token，跳转到登录页面
        window.location.href = '/login';
    } else {
        $.ajax({
            type: "POST",
            url: "/index",
            contentType: "application/json",
            data: JSON.stringify({
                "token": token
            }),
            success: function (response) {
                if (response.code === 200) {
                    // 获取成功，设置 name
                    const parsed = jwtUtils.parseJwt(token);
                    const nameElement = document.getElementById('username');
                    if (nameElement) {
                        nameElement.textContent = parsed.payload.username;
                    }
                } else {
                    alert(response.message);
                }
            },
            dataType: "json"
        });
    }
});



