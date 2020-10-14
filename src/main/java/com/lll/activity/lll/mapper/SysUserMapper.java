package com.lll.activity.lll.mapper;

import com.lll.activity.lll.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-10-13
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select count(*) from sys_user")
    int Count();
}
