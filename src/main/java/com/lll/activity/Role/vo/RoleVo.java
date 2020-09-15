package com.lll.activity.Role.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
public class RoleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String des;

    /**
     * 创建人
     */
    private String createuser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

    /**
     * 状态
     */
    private String status;



    @TableField(exist=false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    @TableField(exist=false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endTime;
}
