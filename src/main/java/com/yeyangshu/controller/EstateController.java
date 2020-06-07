/**
 * Copyright (C), 2018-2020
 * FileName: EstateController
 * Author:   11077
 * Date:     2020/6/7 11:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yeyangshu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yeyangshu.bean.FcEstate;
import com.yeyangshu.bean.TblCompany;
import com.yeyangshu.returnjson.ReturnObject;
import com.yeyangshu.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 房地产公司列表请求
 * @author yeyangshu
 * @version 1.0
 * @date 2020/6/7 11:07
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")
public class EstateController {

    @Autowired
    private EstateService estateService;
    /**
     * 查找房地产公司
     * @return
     */
    @RequestMapping("/estate/selectCompany")
    public String selectCompany() {
        List<TblCompany> tblCompanies = estateService.selectCompany();
        return JSONObject.toJSONString(new ReturnObject(tblCompanies));
    }

    /**
     * 添加房地产
     * @param fcEstate
     * @return
     */
    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate) {
        Integer integer = estateService.insertEstate(fcEstate);
        return JSONObject.toJSONString(new ReturnObject("插入房产成功"));
    }
}
