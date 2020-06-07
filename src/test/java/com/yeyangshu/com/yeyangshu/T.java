/**
 * Copyright (C), 2018-2020
 * FileName: T
 * Author:   11077
 * Date:     2020/6/6 17:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yeyangshu.com.yeyangshu;

import com.yeyangshu.service.EstateService;
import com.yeyangshu.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class T {
    @Autowired
    LoginService loginService;

    @Autowired
    EstateService estateService;
    @Test
    public void test() {
        System.out.println(estateService.selectCompany());
    }
}
