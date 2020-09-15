package com.lll.activity.user.service;

import com.lll.activity.user.VO.UserVo;
import com.lll.activity.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lll.activity.utils.PageUtils;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
public interface IUserService extends IService<User> {

    PageUtils queryList(HashMap<String, Object> map);
}
