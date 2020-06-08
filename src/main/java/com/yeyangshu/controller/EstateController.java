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
import com.yeyangshu.bean.FcBuilding;
import com.yeyangshu.bean.FcEstate;
import com.yeyangshu.bean.TblCompany;
import com.yeyangshu.returnjson.ReturnObject;
import com.yeyangshu.service.EstateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(getClass());
    /**
     * 查找房地产公司
     * @return
     */
    @RequestMapping("/estate/selectCompany")
    public String selectCompany() {
        log.info("start get companies");
        List<TblCompany> tblCompanies = estateService.selectCompany();
        return JSONObject.toJSONString(new ReturnObject(tblCompanies));
    }

    /**
     * 添加房地产
     * @param fcEstate
     * @return jsonString
     */
    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate) {
        log.info("start insert estate");
        Integer result = estateService.insertEstate(fcEstate);
        if (result == 0) {
            log.info("estate already exists");
            return JSONObject.toJSONString(new ReturnObject("0", "房产编码已经存在"));
        } else {
            log.info("insert estate success");
            return JSONObject.toJSONString(new ReturnObject("1", "插入房产成功"));
        }
    }

    /**
     * 楼宇的查询功能
     * 数据库表中没有任何楼宇的数据，因此再编写的时候需要进行插入且返回插入的数据
     * @param buildingNumber
     * @param estateCode
     * @return
     */
    @RequestMapping("estate/selectBuilding")
    public String selectBuilding(Integer buildingNumber, String estateCode) {
        log.info("start select building");
        List<FcBuilding> fcBuildingList = estateService.selectBuilding(buildingNumber, estateCode);
        log.info("end insert building, return fcBuilding list");
        return JSONObject.toJSONString(new ReturnObject(fcBuildingList));
    }
}
