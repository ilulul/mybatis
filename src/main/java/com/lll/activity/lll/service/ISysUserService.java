package com.lll.activity.lll.service;

import com.lll.activity.lll.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lll.activity.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-13
 */
public interface ISysUserService extends IService<SysUser> {

    PageUtils queryList(SysUser user);

    int querycount();

}
