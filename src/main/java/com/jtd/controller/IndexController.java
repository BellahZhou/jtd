package com.jtd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index¿ØÖÆÆ÷
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {
  /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/index")
    @ResponseBody
    public String index() throws Exception {
    	return "index";
    }

}
