package com.lll.activity.Role.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lll.activity.Role.entity.Role;
import com.lll.activity.Role.mapper.RoleMapper;
import com.lll.activity.Role.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private  RoleMapper roleMapper;
    @Override
    public int queryCount() {
        return roleMapper.queryCount();
    }

    @Override
    public int add(Role role) {
        int insert = roleMapper.insert(role);

        return insert;
    }

    @Override
    public void updateRoleById(Role role) {
        roleMapper.updateById(role);
    }

    @Override
    public Map queryList(Role role, Integer page, Integer limit) {
        HashMap map=new HashMap();
        //开启分页
        Page ordersPage = new Page(page,limit);
        //查询构造器
        Wrapper wrapper = new QueryWrapper();

        IPage<Role> ordersIPage = roleMapper.selectPage(ordersPage, wrapper);
              map.put("list",ordersIPage);

        return map;
    }


}
