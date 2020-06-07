package com.yeyangshu.service;

import com.yeyangshu.bean.TblUserRecord;
import com.yeyangshu.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登陆服务
 * @author yeyangshu
 * @version 1.0
 * @date 2020/6/6 11:22
 */
@Service
public class LoginService {

    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username, String password){
        return tblUserRecordMapper.login(username, password);
    }


}
