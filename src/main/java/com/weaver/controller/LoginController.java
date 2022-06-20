package com.weaver.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.IOUtils;
import com.weaver.resopnse.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author lzy
 * @version v1.0
 * @description
 * @date:21/07/21 11:24
 */
@Controller
@RestController
@RequestMapping("/")
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        BaseResponse res = BaseResponse.success();
        Cookie cookie = new Cookie("sessionId", UUID.randomUUID().toString());
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        return JSONObject.toJSONString(res);
    }

    @RequestMapping("/userInfo")
    public String userInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject userInfo = new JSONObject();

        userInfo.put("name", "lizunyi");

        JSONArray role = new JSONArray();
        role.add("admin");
        role.add("manager");

        userInfo.put("roles", role);
        JSONArray permissions = new JSONArray();
        permissions.add("*");

        InputStream is = request.getServletContext().getClassLoader().getResourceAsStream("routes.json");
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        JSONArray routes = JSONArray.parseArray(new String(bytes));
        userInfo.put("routes", routes);
        userInfo.put("permissions", permissions);
        userInfo.put("name", "lizunyi");
        BaseResponse res = BaseResponse.success(userInfo);
        return JSONObject.toJSONString(res);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        BaseResponse res = BaseResponse.success();
        return JSONObject.toJSONString(res);
    }
}
