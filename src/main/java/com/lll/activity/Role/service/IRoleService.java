package com.lll.activity.Role.service;

import com.lll.activity.Role.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
