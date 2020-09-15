package com.lll.activity.user.controller;


import com.lll.activity.Role.vo.RoleVo;
import com.lll.activity.user.VO.UserVo;
import com.lll.activity.user.entity.User;
import com.lll.activity.user.service.IUserService;
import com.lll.activity.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
@RestController
@RequestMapping("/user/user/")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("list")
    public Map RoleList(@RequestBody UserVo user) {
        //接收前端的map
        HashMap<String, Object> map = new HashMap();
        map.put("page", user.getPage());
        map.put("limit",user.getLimit());
        map.put("username", user.getUsername());
        map.put("name", user.getName());
        PageUtils pageUtils = userService.queryList(map);
        //返给前端的map
        HashMap<String, Object> retmap = new HashMap();
        retmap.put("data", pageUtils);

        return retmap;
    }


}
