package com.jtd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index¿ØÖÆÆ÷
 */
@Controller
public class IndexController {
  /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/index")
    public String index() throws Exception {
    	System.out.println("----");
    	return "index";
    }

}
