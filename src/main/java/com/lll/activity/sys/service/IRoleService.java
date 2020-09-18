package com.lll.activity.sys.service;

import com.lll.activity.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lll.activity.sys.vo.RoleVo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
public interface IRoleService extends IService<Role> {

    int queryCount();

    int add(Role role);

    void updateRoleById(Role role);

    Map queryList(RoleVo role, Integer page, Integer limit);
}
