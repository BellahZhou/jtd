package com.jtd.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import com.jtd.entity.Menu;

public class MenuDto extends Menu {

    /**
     * 菜单的代办个�?
     */
    private boolean showTodo = false;

    /**
     * 是否有权�? "0"没有权限 "1"有权�?
     */
    private String hasAuth = "";

    /**
     * �?属角�?
     */
    private String roleId;

    /**
     * 菜单名称(treeview中使�?)
     */
    private String text;

    /**
     * 节点状�??
     */
    private Map<String, Boolean> state = new HashMap<String, Boolean>();

    /**
     * 子级菜单
     */
    private List<MenuDto> nodes;

    @Override
    public void setMenuName(String menuName) {
        super.setMenuName(menuName);
        this.text = menuName;
    }

    public boolean isShowTodo() {
        return showTodo;
    }

    public void setShowTodo(boolean showTodo) {
        this.showTodo = showTodo;
    }

    public String getHasAuth() {
        return hasAuth;
    }

    public void setHasAuth(String hasAuth) {
        this.hasAuth = hasAuth;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
        if (roleId != null) {
            this.state.put("checked", true);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Boolean> getState() {
        return state;
    }

    public void setState(Map<String, Boolean> state) {
        this.state = state;
    }

    public List<MenuDto> getNodes() {
        return nodes;
    }

    public void setNodes(List<MenuDto> nodes) {
        this.nodes = nodes;
    }
}
