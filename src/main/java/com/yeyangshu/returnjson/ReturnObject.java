/**
 * Copyright (C), 2018-2020
 * FileName: ReturnObject
 * Author:   11077
 * Date:     2020/6/6 19:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yeyangshu.returnjson;

/**
 * @author yeyangshu
 * @version 1.0
 * @date 2020/6/6 19:00
 */
public class ReturnObject {
    private String code = "200";
    private String message = "";
    private Object result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ReturnObject() {
    }

    public ReturnObject(String message, Object result) {
        this.message = message;
        this.result = result;
    }

    public ReturnObject(String code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ReturnObject(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ReturnObject{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
