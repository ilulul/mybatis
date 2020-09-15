package com.lll.activity.Role.controller;


import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.lll.activity.Role.entity.Role;
import com.lll.activity.Role.service.IRoleService;
import com.lll.activity.Role.vo.RoleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.T;

/**
 * <p>
 *  前端控制器
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
    public int roleCount(){
        int count =roleService.queryCount();
        return count;
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

    @PostMapping("list")
    public Map RoleList(@RequestBody RoleVo role, Integer page , Integer limit) {
        if (page==null)
            page=1;
        if(limit==null)
            limit=10;
        Map map = roleService.queryList(role, page, limit);

        return map;
    }

}
