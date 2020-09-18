package com.lll.activity.sys.mapper;

import com.lll.activity.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select count(*) from role")
    int queryCount();
}
