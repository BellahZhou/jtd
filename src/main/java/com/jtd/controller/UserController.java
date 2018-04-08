package com.jtd.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
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
        System.out.println("��ҳ");
        request.setAttribute("user", SecurityContextUtil.getCurrentUser());
        return "index";
    }

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model){
        System.out.println("��¼ҳ");
        if (error != null) {
            return "loginFailure";
        }
        return "login";
    }
    
    @RequestMapping(value = "/register")
    public String register() {
        System.out.println("ע��ҳ");
        return "register";
    }
    
    @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String userRegister(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException
    {
      String username = request.getParameter("username");
      User user = this.userService.findByUsername(username);
      if (user != null)
      {
        request.setAttribute("msg", "�û��Ѵ���");
        return "register";
      }
      String password = request.getParameter("password");
//      String YZMD5PSD = PasswordUtil.getYZMD5PSD(username, password);
      user = new User();
      user.setUsername(username);
      user.setPassword(password);
      user.setDisabled(true);
      user.setAccount(username);
      long timeID = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSSSS").format(new Date()));
      int a = this.userService.insertUser(user);
      if (a == 1){
        request.setAttribute("msg", "ע��ɹ�");
        request.setAttribute("username", username);
        return "login";
      }
      request.setAttribute("msg", "ע��ʧ��");
      return "register";
      
    }
  
    
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

}