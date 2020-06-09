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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yeyangshu.bean.FcBuilding;
import com.yeyangshu.bean.FcEstate;
import com.yeyangshu.bean.TblCompany;
import com.yeyangshu.mapper.FcBuildingMapper;
import com.yeyangshu.mapper.FcEstateMapper;
import com.yeyangshu.mapper.TblCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private FcBuildingMapper fcBuildingMapper;
    /**
     * 选择公司服务
     * @return List<TblCompany>
     */
    public List<TblCompany> selectCompany() {
        List<TblCompany> companyNames = tblCompanyMapper.selectCompany();
        return companyNames;
    }


    /**
     * 插入房地产信息
     * 在插入数据之前，对当前信息做判断，判断住宅编码是否存在，如果踩在不允许插入
     * 如果不存在才允许插入
     * @param fcEstate
     * @return Integer 是否插入成功，1：成功，0：失败
     */
    public Integer insertEstate(FcEstate fcEstate) {
        // 定义查询包装类
        QueryWrapper<FcEstate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("estate_code", fcEstate.getEstateCode());
        FcEstate findResult = fcEstateMapper.selectOne(queryWrapper);
        // 定义返回的结果
        int result = 0;
        if (findResult != null) {
            return result;
        } else {
            result = fcEstateMapper.insert(fcEstate);
            return result;
        }
    }

    /**
     * 先插入数据，再查询数据
     * @param buildingNumber
     * @param estateCode
     * @return List<FcBuilding>
     */
    public List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode) {
        List<FcBuilding> fcBuildingList = new ArrayList<>();
        for (int i = 0; i < buildingNumber; i++) {
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setBuildingCode("A" + (i +1));
            fcBuilding.setBuildingName("第" + (i + 1) + "号楼");
            fcBuilding.setEstateCode(estateCode);
            fcBuildingMapper.insert(fcBuilding);
            fcBuildingList.add(fcBuilding);
        }
        return fcBuildingList;
    }

    /**
     * 楼宇更新
     * @param fcBuilding
     * @return result
     */
    public Integer updateBuilding(FcBuilding fcBuilding) {
        int result = fcBuildingMapper.updateById(fcBuilding);
        return result;
    }
}
