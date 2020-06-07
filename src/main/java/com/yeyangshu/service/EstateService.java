/**
 * Copyright (C), 2018-2020
 * FileName: EstateService
 * Author:   11077
 * Date:     2020/6/7 11:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yeyangshu.service;

import com.yeyangshu.bean.FcEstate;
import com.yeyangshu.bean.TblCompany;
import com.yeyangshu.mapper.FcEstateMapper;
import com.yeyangshu.mapper.TblCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 房地产服务
 * @author yeyangshu
 * @version 1.0
 * @date 2020/6/7 11:12
 */
@Service
public class EstateService {

    @Autowired
    private TblCompanyMapper tblCompanyMapper;
    @Autowired
    private FcEstateMapper fcEstateMapper;
    /**
     * 选择公司服务
     * @return
     */
    public List<TblCompany> selectCompany() {
        List<TblCompany> companyNames = tblCompanyMapper.selectCompany();
        return companyNames;
    }

    /**
     * 插入房地产信息
     */
    public Integer insertEstate(FcEstate fcEstate) {
        int result = fcEstateMapper.insert(fcEstate);
        return result;
    }
}
