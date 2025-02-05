// 引入 js-cookie 库
import Cookies from '/js/mine/js/js.cookie.min.mjs';

// 引入 jwtUtils 工具（假设你已经有一个 jwtUtils.js 文件）
import jwtUtils from '/js/mine/utils/jwtUtils.js';

// 引入 axios 库
import axios from '/js/mine/js/axios.min.js';

//TODO 三个文件导入失败

// 检查 Token 的函数
function checkToken() {
    const token = Cookies.get('token');
    if (!token) {
        // 如果没有 token，跳转到登录页面
        window.location.href = '/login';
    } else {
        axios({
            method: "POST",
            url: "http://localhost:8080/index",
            data: {
                "token": token
            },
            withCredentials: true
        }).then(result => {
            if (result.data.code === 200) {
                // 获取成功，设置 name
                const parsed = jwtUtils.parseJwt(token);
                const nameElement = document.getElementById('username');
                if (nameElement) {
                    nameElement.textContent = parsed.payload.username;
                }
            } else {
                // 登录失败，显示错误信息
                alert(result.data.message);
            }
        }).catch(error => {
            // 处理请求错误，例如网络问题、服务器错误等
            if (error.response) {
                // 请求成功但状态码不在 2xx 范围
                alert(error.response.data.message);
            } else if (error.request) {
                // 请求发出但没有收到响应
                alert('请求发出但没有收到响应，请稍后再试');
            } else {
                // 在设置请求时发生了错误
                alert('请求设置错误，请稍后再试');
            }
        });
    }
}

// 页面加载完成后执行检查 Token
document.addEventListener('DOMContentLoaded', checkToken);
