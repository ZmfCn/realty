package com.zmf.realty.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

/**
 * @author zmf
 * @description
 * @timestamp 2018-07-11 18:02
 */
public class JwtUtil {
    /**
     * decrypt jwt
     *
     * @param jwt       jwt token
     * @param secretKey the key used when generate the jwt.
     * @return claims
     * @throws Exception when the token is expired.
     */
    public static Claims parseJWT(String jwt, SecretKey secretKey) throws Exception {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt).getBody();
    }

    /**
     * create jwt
     *
     * @param jwtId         JWT id
     * @param timeoutMillis the millisecond for time out.
     * @return jwt string
     * @throws Exception exception
     */
    public static String createJWT(String jwtId, long timeoutMillis, Map<String, Object> claims, SecretKey secretKey) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        long nowMillis = System.currentTimeMillis();//生成JWT的时间
        Date now = new Date(nowMillis);
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims)          //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setId(jwtId)                  //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(now)           //iat: jwt的签发时间
                .signWith(signatureAlgorithm, secretKey);//设置签名使用的签名算法和签名使用的秘钥
        if (timeoutMillis >= 0) {
            long expMillis = nowMillis + timeoutMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);     //设置过期时间
        }
        return builder.compact();           //就开始压缩为xxxxxxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxxxxx这样的jwt
    }

    /**
     * generate key from string
     *
     * @param secret the secret string
     * @return the key jwt needs.
     */
    public static SecretKey generalKey(String secret) {
        byte[] encodedKey = Base64.decodeBase64(secret);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }
}