package com.jtd.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jtd.util.SecurityContextUtil;
import com.jtd.util.TreeUtil;
import com.jtd.dao.MenuDao;
import com.jtd.dto.MenuDto;
import com.jtd.entity.Menu;
import com.jtd.entity.User;
import com.jtd.service.IUserService;
import com.jtd.service.MenuService;

/**
 * index控制器
 */
@Controller
public class IndexController {
	
	@Autowired
	private MenuService menuService;
	@Resource(name="userService")
	private IUserService userService;
	
    @RequestMapping("/getTopMenus")
    @ResponseBody
    public List<MenuDto> index(HttpSession session) throws Exception {
        String username = SecurityContextUtil.getCurrentUser();
        if (username == null||"".equals(username)) {
            return Collections.emptyList();
        }
        User user=userService.findByUsername(username);
        Menu menu = new Menu();
        menu.setMenuLevel(Integer.valueOf(1));
        List<MenuDto> allTopMenus = menuService.getMenusByUserId(user.getId(), menu);
        return allTopMenus;
    }
    @RequestMapping("/{type}/todo")
    public String htmlJump(@PathVariable(value="type") String menuType){
    	
    	return "/"+menuType+"/todo";
    }
    
    @RequestMapping("/{type}/{detail}")
    public String htmlJump(@PathVariable(value="type") String menuType,@PathVariable(value="detail") String detail){
    	
    	return "/"+menuType+"/"+detail;
    }
    
    
    @RequestMapping("/getMenuTree")
    @ResponseBody
    public List<MenuDto> getMenuTree(Long menuId,HttpSession session) {
    	 Menu menu = (Menu)this.menuService.selectByPrimaryKey(menuId);
    	User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
    	Menu query = new Menu();
        query.setMenuSeq(menu.getMenuSeq());
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("userId", user.getId());
        map.put("menu", query);
        List<MenuDto> menus = menuService.getMenusAuthorityByUserId(map);
        
        return TreeUtil.getChildTreeObjects(menus);
    }
    
    @RequestMapping("/menu_index_{menuId}")
    public String index(Model model, @PathVariable(value="menuId") Long menuId,HttpSession session) throws Exception {
    	 User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
    	 Menu menu = new Menu();
    	 menu.setId(menuId);
    	 Map<String, Object> map=new HashMap<String, Object>();
         map.put("userId", user.getId());
         map.put("menu", menu);
        List<MenuDto> menus = menuService.getMenusAuthorityByUserId(map);
        if (menuId == null || menus.size() == 0) {
            throw new Exception("无效的菜单id: " + menuId);
        }
        model.addAttribute("user", user);
        model.addAttribute("topMenu", menus.get(0));
        return "main";
    }
    
    @RequestMapping({"/logout"})
    public String unifiedlogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.getSession().removeAttribute("user");
      request.getSession().invalidate();
      return "login";
    }
}
