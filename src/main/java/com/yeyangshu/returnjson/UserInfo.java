/**
 * Copyright (C), 2018-2020
 * FileName: UserInfo
 * Author:   11077
 * Date:     2020/6/7 8:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yeyangshu.returnjson;

/**
 * 接口返回个人权限信息，前端需要的结构
 * @author yeyangshu
 * @version 1.0
 * @date 2020/6/7 8:33
 */
public class UserInfo {
    /** 用户名*/
    private String name;
    /** 头像*/
    private String avatar = "/avatar2.jpg";
    /** 角色*/
    private Permissions role;

    public UserInfo(String name, Permissions role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Permissions getRole() {
        return role;
    }

    public void setRole(Permissions role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role=" + role +
                '}';
    }
}
