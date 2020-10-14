package com.lll.activity.sys.controller;


import com.lll.activity.sys.vo.UserVo;
import com.lll.activity.sys.service.IUserService;
import com.lll.activity.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        map.put("page", String.valueOf(user.getPage()));
        map.put("limit", String.valueOf(user.getLimit()));
        map.put("username", user.getUsername());
        map.put("name", user.getName());
        PageUtils pageUtils = userService.queryList(map);
        //返给前端的map
        HashMap<String, Object> retmap = new HashMap();
        retmap.put("data", pageUtils);

        return retmap;
    }


}
