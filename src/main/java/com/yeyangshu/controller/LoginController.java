package com.yeyangshu.controller;

import com.alibaba.fastjson.JSONObject;
import com.yeyangshu.bean.TblUserRecord;
import com.yeyangshu.mapper.TblUserRecordMapper;
import com.yeyangshu.returnjson.Permission;
import com.yeyangshu.returnjson.Permissions;
import com.yeyangshu.returnjson.ReturnObject;
import com.yeyangshu.returnjson.UserInfo;
import com.yeyangshu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户登录Controller
 * @author yeyangshu
 * @version 1.0
 * @date 2020/6/6 15:29
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    TblUserRecordMapper tblUserRecordMapper;

    /**
     * 前端默认请求，可以不做处理，可忽略。
     * @return
     */
    @RequestMapping("/auth/2step-code")
    public boolean test() {
        System.out.println("/auth/2step-code");
        return true;
    }

    /**
     * 用户登录方法
     * @param username
     * @param password
     * @param session
     * @return String
     */
    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        TblUserRecord tblUserRecord = loginService.login(username, password);
        tblUserRecord.setToken(tblUserRecord.getUserName());
        // 将用户数据写入到session
        session.setAttribute("userRecord", tblUserRecord);
        ReturnObject returnObject = new ReturnObject(tblUserRecord);
        System.out.println(returnObject);
        return JSONObject.toJSONString(returnObject);
//        return JSONObject.parseObject(JSONObject.toJSONString(returnObject));
    }

    /**
     * 用户权限信息查询
     * @param session
     * @return
     */
    @RequestMapping("/user/info")
    public String getInfo(HttpSession session) {
        TblUserRecord tblUserRecord = (TblUserRecord) session.getAttribute("userRecord");
        // 获取模块信息
        String[] rolePrivileges = tblUserRecord.getTblRole().getRolePrivileges().split("-");
        Permissions permissions  = new Permissions();
        List<Permission> permissionList = new ArrayList<>();
        for (String rolePrivilege : rolePrivileges) {
            permissionList.add(new Permission(rolePrivilege));
        }
        permissions.setPermissions(permissionList);
        UserInfo userInfo = new UserInfo(tblUserRecord.getUserName(), permissions);
        System.out.println(userInfo);
        ReturnObject returnObject = new ReturnObject(userInfo);
        return JSONObject.toJSONString(returnObject);
//        return JSONObject.parseObject(JSONObject.toJSONString(returnObject));
    }

    @RequestMapping("/auth/logout")
    public JSONObject loginOut(HttpSession session){
        System.out.println("退出登录");
        // 退出设置session无效
        session.invalidate();
        return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject(null)));
    }

}