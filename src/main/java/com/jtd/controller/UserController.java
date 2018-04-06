package com.jtd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.jtd.entity.User;
import com.jtd.service.IUserService;
import com.jtd.util.SecurityContextUtil;

/**
 * Created by Bellah on 2018/3/30 0020.
 */
@Controller
@RequestMapping(value = {"/","/user"})
public class UserController {
	@Resource(name="userService")
	private IUserService userService;
	
    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String index(HttpServletRequest request,HttpServletResponse response){
        System.out.println("Ö÷Ò³");
        request.setAttribute("user", SecurityContextUtil.getCurrentUser());
        return "index";
    }

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model){
        System.out.println("µÇÂ¼Ò³");
        if (error != null) {
            return "loginFailure";
        }
        return "login";
    }
    
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

}