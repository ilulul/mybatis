package com.lll.activity.sys.service;

import com.lll.activity.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lll.activity.utils.PageUtils;

import java.util.HashMap;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
public interface IUserService extends IService<User> {

    PageUtils queryList(HashMap<String, Object> map);
}
