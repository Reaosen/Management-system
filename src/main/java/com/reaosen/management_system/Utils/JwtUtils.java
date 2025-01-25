package com.reaosen.management_system.Utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.RegisteredPayload;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 工具类
 * 封装了 JWT 的生成、验证和解析功能
 */
public class JwtUtils {

    // 密钥（建议从配置文件中读取，不要硬编码）
    private static final byte[] SECRET_KEY = "Reaosen".getBytes(StandardCharsets.UTF_8);

    /**
     * 生成 JWT
     *
     * @param subject  主题（通常是用户ID）
     * @param claims   自定义 claims（键值对）
     * @param expireIn 过期时间（秒）
     * @return 生成的 JWT
     */
    public static String createToken(String subject, Map<String, Object> claims, long expireIn) {
        Map<String, Object> payload = new HashMap<>(claims); // 复制自定义 claims
        payload.put(RegisteredPayload.SUBJECT, subject); // 设置主题
        payload.put(RegisteredPayload.ISSUED_AT, System.currentTimeMillis() / 1000); // 签发时间
        payload.put(RegisteredPayload.EXPIRES_AT, System.currentTimeMillis() / 1000 + expireIn); // 过期时间

        return JWTUtil.createToken(payload, SECRET_KEY);
    }

    /**
     * 验证 JWT 是否有效
     *
     * @param token JWT
     * @return 是否有效
     */
    public static boolean validateToken(String token) {
        return JWTUtil.verify(token, SECRET_KEY);
    }

    /**
     * 解析 JWT
     *
     * @param token JWT
     * @return 解析后的 JWT 对象
     */
    public static JWT parseToken(String token) {
        return JWTUtil.parseToken(token);
    }

    /**
     * 从 JWT 中获取指定 claim 的值
     *
     * @param token JWT
     * @param claim claim 名称
     * @return claim 的值
     */
    public static Object getClaim(String token, String claim) {
        JWT jwt = parseToken(token);
        return jwt.getPayload(claim);
    }

    /**
     * 从 JWT 中获取主题（subject）
     *
     * @param token JWT
     * @return 主题（通常是用户ID）
     */
    public static String getSubject(String token) {
        return (String) getClaim(token, RegisteredPayload.SUBJECT);
    }

    /**
     * 从 JWT 中获取过期时间
     *
     * @param token JWT
     * @return 过期时间（秒）
     */
    public static Long getExpiration(String token) {
        return (Long) getClaim(token, RegisteredPayload.EXPIRES_AT);
    }

    /**
     * 检查 JWT 是否已过期
     *
     * @param token JWT
     * @return 是否已过期
     */
    public static boolean isTokenExpired(String token) {
        Long expiration = getExpiration(token);
        return expiration != null && expiration < System.currentTimeMillis() / 1000;
    }
}
