/**
 * Copyright (C), 2018-2020
 * FileName: Permissions
 * Author:   11077
 * Date:     2020/6/7 8:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yeyangshu.returnjson;

import java.util.List;

/**
 * 权限管理集合
 * @author yeyangshu
 * @version 1.0
 * @date 2020/6/7 8:31
 */
public class Permissions {
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "permissions=" + permissions +
                '}';
    }
}
