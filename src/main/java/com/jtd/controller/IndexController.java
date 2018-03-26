package com.jtd.controller;

import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jtd.util.SecurityContextUtil;
import com.jtd.dao.MenuDao;
import com.jtd.domain.Menu;
import com.jtd.domain.User;
import com.jtd.dto.MenuDto;

/**
 * index¿ØÖÆÆ÷
 */
@Controller
public class IndexController {
	@Autowired(required=false)
	private MenuDao menuDao;
    
    @RequestMapping("/getTopMenus")
    @ResponseBody
    public List<MenuDto> index(HttpSession session) throws Exception {
        User user = (User)session.getAttribute("user");
        if (user == null) {
            return Collections.emptyList();
        }
        List<MenuDto> allTopMenus = menuDao.getMenusByUserId(user.getId(), 1);
        return allTopMenus;
    }
    @RequestMapping("/{type}/todo")
    public String htmlJump(@PathVariable(value="type") String menuType){
    	
    	return "/"+menuType+"/todo";
    }
}
