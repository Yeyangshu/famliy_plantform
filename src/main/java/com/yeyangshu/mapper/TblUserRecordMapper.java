package com.yeyangshu.mapper;

import com.yeyangshu.bean.TblUserRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户档案 Mapper 接口
 * </p>
 *
 * @author yeyangshu
 * @since 2020-06-06
 */
@Component
public interface TblUserRecordMapper extends BaseMapper<TblUserRecord> {
    public TblUserRecord login(@Param("userName") String username, @Param("userPassword") String password);
}
