package com.yeyangshu.service.base.impl;

import com.yeyangshu.bean.TblTodo;
import com.yeyangshu.mapper.TblTodoMapper;
import com.yeyangshu.service.base.TblTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author yeyangshu
 * @since 2020-06-06
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements TblTodoService {

}
