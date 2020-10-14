package com.lll.activity.lll.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lll.activity.lll.entity.SysUser;
import com.lll.activity.lll.mapper.SysUserMapper;
import com.lll.activity.lll.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lll.activity.utils.PageUtils;
import com.lll.activity.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;



    @Override
    public PageUtils queryList(SysUser sysUser) {
        HashMap map=new HashMap();
        map.put("page","1");
        map.put("limit","10");
        map.put("username",sysUser.getUsername());
        String username = (String) map.get("username");
        IPage<SysUser> pages = this.page(
                new Query<SysUser>().getPage(map),
                new QueryWrapper<SysUser>()
                        .like(StringUtils.isNotBlank(username), "username", username)
        );
        return new PageUtils(pages);
    }

    @Override
    public int querycount() {
//        int integer = sysUserMapper.selectCount(new QueryWrapper<SysUser>());
        int integer = sysUserMapper.Count();

        return integer;
    }




}
