export default {
    parseJwt(token) {
    try {
        // 1. 分割 JWT
        const [headerBase64, payloadBase64, signature] = token.split('.');

        // 2. Base64 解码
        const decodeBase64 = (str) => {
        // 替换 URL 安全的 Base64 字符
        str = str.replace(/-/g, '+').replace(/_/g, '/');
        // 补全 Base64 长度
        while (str.length % 4) {
            str += '=';
        }
        // 解码
        return decodeURIComponent(atob(str).split('').map((c) => {
            return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        }).join(''));
        };

        // 3. 解析 Header 和 Payload
        const header = JSON.parse(decodeBase64(headerBase64));
        const payload = JSON.parse(decodeBase64(payloadBase64));

        return { header, payload, signature };
    } catch (e) {
        console.error("Invalid JWT", e);
        return null;
    }
    },
    isTimestampExpired(timestamp) {
    // 将秒级时间戳转换为毫秒
    const expirationTime = timestamp * 1000;

    // 获取当前时间的毫秒数
    const currentTime = Date.now();

    // 判断是否过期
    return currentTime > expirationTime;
}
}