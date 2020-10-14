package com.lll.activity.sys.vo;

import lombok.Data;

/**
 * @program: activity
 * @description: 分页参数
 * @author: lilulu
 * @create: 2020-09-15 14:18
 */
@Data
public class PageVo {

    private Integer page = 1;

    private Integer limit = 10;

}
