package com.example.sso.modular.util.tokenUtil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxinyu
 * @date 2022/05/26 15:32
 **/
public class TokenUtil {
    private static final long EXPIRE_TIME = 15*60*1000;
    private static final String TOKEN_SECRET = "thisIsToken";


    //token的生成15分钟过期
    public static  String sign(String name,String passWord){
        try{
            //设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部header
            Map<String,Object> map = new HashMap<>();
            map.put("type","Jwt");
            map.put("alg","HS256");
            //token字符串
            return JWT.create()
                    .withHeader(map)
                    .withClaim("name",name)
                    .withClaim("password",passWord)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //token的检验
    public static boolean verify(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
