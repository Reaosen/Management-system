// 引入 axios 库
import axios from 'https://unpkg.com/axios/dist/axios.min.js';

// 登录函数
function login() {
    // 获取用户输入的 email 和 password
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // 发送 POST 请求到后端进行登录
    axios({
        method: "POST",
        url: "http://localhost:8080/login",
        data: {
            "email": email,
            "password": password
        },
        withCredentials: true
    }).then(result => {
        if (result.data.code === 200) {
            // 登录成功，跳转到首页
            window.location.href = '/';
        } else {
            // 登录失败，显示错误信息
            alert(result.data.message);
        }
    }).catch(error => {
        // 处理请求错误，例如网络问题、服务器错误等
        if (error.response) {
            // 请求成功但状态码不在 2xx 范围
            alert(error.response.data.message);  // 使用 error.response.data.message 弹出错误信息
        } else if (error.request) {
            // 请求发出但没有收到响应
            alert('请求发出但没有收到响应，请稍后再试');
        } else {
            // 在设置请求时发生了错误
            alert('请求设置错误，请稍后再试');
        }
    });
}

// 绑定登录按钮的点击事件
document.addEventListener('DOMContentLoaded', () => {
    const loginButton = document.getElementById('loginButton');
    loginButton.addEventListener('click', login);
});
