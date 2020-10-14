package com.lll.activity.sys.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2020-09-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 菜单名称
     */
    private String authName;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 菜单URL
     */
    private String menuUrl;

    /**
     * icon
     */
    private String menuIcon;

    /**
     * 权限标志
     */
    private String auth;

    /**
     * 是否折叠  0展开 1折叠
     */
    private Integer checked;

    /**
     * 是否菜单  0是  1 按钮  -1目录
     */
    private Integer isMenu;

    /**
     * 父级菜单ID
     */
    private Integer parentId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改数据
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 状态 0禁言  1启用
     */
    private String status;


}
