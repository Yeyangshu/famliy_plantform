/**
 * Copyright (C), 2018-2020
 * FileName: Permission
 * Author:   11077
 * Date:     2020/6/7 8:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yeyangshu.returnjson;

/**
 * 权限管理角色
 * @author yeyangshu
 * @version 1.0
 * @date 2020/6/7 8:29
 */
public class Permission {
    private String permissionId;

    public Permission(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                '}';
    }
}
