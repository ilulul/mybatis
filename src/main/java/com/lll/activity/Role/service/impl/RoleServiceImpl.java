package com.lll.activity.Role.service.impl;

import com.lll.activity.Role.entity.Role;
import com.lll.activity.Role.mapper.RoleMapper;
import com.lll.activity.Role.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private  RoleMapper roleMapper;
    @Override
    public int queryCount() {
        return roleMapper.queryCount();
    }


}
