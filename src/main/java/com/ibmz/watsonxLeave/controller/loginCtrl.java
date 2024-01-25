package com.ibmz.watsonxLeave.controller;

import com.alibaba.fastjson2.JSON;
import com.ibmz.watsonxLeave.pojo.LoginUser;
import com.ibmz.watsonxLeave.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginCtrl {
    @Autowired
    TokenService tokenService;
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public String getToken(@RequestBody String param){
        LoginUser loginUser = JSON.parseObject(param, LoginUser.class);


        String token = tokenService.getToken(loginUser);
        return token;
    }

}
