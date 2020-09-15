package com.lll.activity.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lll.activity.Role.entity.Role;
import com.lll.activity.user.VO.UserVo;
import com.lll.activity.user.entity.User;
import com.lll.activity.user.mapper.UserMapper;
import com.lll.activity.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lll.activity.utils.PageUtils;

import com.lll.activity.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private  UserMapper userMapper;
    @Override
    public PageUtils queryList(HashMap<String, Object> map) {

        String username = (String) map.get("username");
        String name = (String) map.get("name");
//        //分页
//        Page userPage = new Page(page, limit);
//        //查询构造器
//        User user =new User();
//        Wrapper userQueryWrapper = new QueryWrapper();
//        ((QueryWrapper) userQueryWrapper).like(StringUtils.isNotBlank(username), "username", username);
//        ((QueryWrapper) userQueryWrapper).like(StringUtils.isNotBlank(name), "name", name);
//        IPage<User> ordersIPage = userMapper.selectPage(userPage, userQueryWrapper);

        IPage<User> pages = this.page(
                new Query<User>().getPage(map),
                new QueryWrapper<User>()
                        .like(StringUtils.isNotBlank(name), "name", name)
        );
        return new PageUtils(pages);
    }
}
