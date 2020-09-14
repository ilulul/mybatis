package com.lll.activity.Role.controller;


import com.lll.activity.Role.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
@RestController
@RequestMapping("/Role/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("query")
    public int roleCount(){
        int count =roleService.queryCount();
        return count;
    }
}
