package com.ibmz.watsonxLeave.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ibmz.watsonxLeave.dto.LoginUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    public static int EXPIRE_DATE=60*60;
    public static String TOKEN_SECRET = "secretKey";
    public String getToken(LoginUser user) {
        String token = "";
        try {
            Date date = new Date(System.currentTimeMillis() + (EXPIRE_DATE * 100000));
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", user.getUsername())
                    .withClaim("password", user.getPassword()).withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    public  boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            log.info("jwt token is {},header is {},payload is {} ",jwt.getToken(),jwt.getHeader(),jwt.getPayload());
            return true;
        } catch (Exception e) {
            log.info("we get error msg in verify{}",e);
            return false;
        }
    }

}