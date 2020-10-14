package com.lll.activity.sys.controller;


import com.lll.activity.sys.entity.Role;
import com.lll.activity.sys.service.IRoleService;
import com.lll.activity.sys.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/Role/role/")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("query")
    public String roleCount() {
//        int count =roleService.queryCount();
        return "it'ok,hello world";
    }

    @PostMapping("add")
    public Boolean addRole(Role role) {
        int b = roleService.add(role);
        if (b == 1) {
            return true;
        } else {
            return false;
        }
    }


    @PostMapping("update")
    public void updateRoleById(Role role) {
        roleService.updateRoleById(role);
    }

    @GetMapping("list")
    public Map RoleList(RoleVo role, Integer page, Integer limit) {
        if (page == null)
            page = 1;
        if (limit == null)
            limit = 10;
        Map map = roleService.queryList(role, page, limit);

        return map;
    }

}
