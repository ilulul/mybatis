package com.lll.activity.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: activity
 * @description: 页面跳转
 * @author: lilulu
 * @create: 2020-09-30 09:54
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/vueTest")
    public String vueTest() {


        return "vueTest";
    }
}
