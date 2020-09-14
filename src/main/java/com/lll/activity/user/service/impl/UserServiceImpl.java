package com.lll.activity.user.service.impl;

import com.lll.activity.user.entity.User;
import com.lll.activity.user.mapper.UserMapper;
import com.lll.activity.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
