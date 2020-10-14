package com.lll.activity.lll.controller;


import com.lll.activity.Result.ResponseResult;
import com.lll.activity.lll.entity.SysUser;
import com.lll.activity.lll.service.ISysUserService;
import com.lll.activity.lll.service.impl.SysUserServiceImpl;
import com.lll.activity.utils.PageUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/lll/sys-user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/query")
    public ResponseEntity queryUser(@RequestBody SysUser user,Integer page,Integer limit){
        ResponseResult responseResult=new ResponseResult();

        PageUtils pageUtils = sysUserService.queryList(user);
        if (page == null)
            page = 1;
        if (limit == null)
            limit = 10;
//        Map sysUserList=  sysUserService.querySysUser(user,page,limit);
//        Object list = sysUserList.get("list");

        responseResult.setData(pageUtils);

        return new ResponseEntity(responseResult, HttpStatus.OK);
    }


    @RequestMapping("/queryCOUNT")
public int querycount(){
        int s=sysUserService.querycount();
        return s;
}



}
