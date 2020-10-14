package com.lll.activity.lll.entity;

import java.io.Serializable;

import com.lll.activity.sys.vo.PageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2020-10-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private Integer deptId;


}
