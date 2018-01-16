package com.emed.shopping.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 周润斌
 * @Date: create in 上午 16:58 2018/1/15 0015
 * @Description:
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {

    @RequestMapping(value = "/index")
    public String index(){

        return "/web/index";
    }

}
