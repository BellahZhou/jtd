package com.jtd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TB_MENU")
public class Menu extends IDE implements Serializable{
	
	private static final long serialVersionUID = 8026813053768023527L;
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "MENU_CODE")
    private String menuCode;

    @Column(name = "MENU_DESC")
    private String menuDesc;

    @Column(name = "MENU_ICON")
    private String menuIcon;

    @Column(name = "MENU_SEQ")
    private String menuSeq;

    @Column(name = "IS_LEAF")
    private String isLeaf;

    @Column(name = "MENU_LEVEL")
    private Integer menuLevel;

    @Column(name = "PARENT_MENU_ID")
    private Long parentMenuId;

    @Column(name = "SORT_NO")
    private Integer sortNo;

    @Column(name = "URL")
    private String url;

    @Column(name = "CAN_DELETE")
    private String canDelete;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return MENU_NAME
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return MENU_CODE
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * @param menuCode
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * @return MENU_DESC
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * @param menuDesc
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * @return MENU_SEQ
     */
    public String getMenuSeq() {
        return menuSeq;
    }

    /**
     * @param menuSeq
     */
    public void setMenuSeq(String menuSeq) {
        this.menuSeq = menuSeq;
    }

    /**
     * @return IS_LEAF
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * @param isLeaf
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * @return MENU_LEVEL
     */
    public Integer getMenuLevel() {
        return menuLevel;
    }

    /**
     * @param menuLevel
     */
    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * @return PARENT_MENU_ID
     */
    public Long getParentMenuId() {
        return parentMenuId;
    }

    /**
     * @param parentMenuId
     */
    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    /**
     * @return SORT_NO
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * @param sortNo
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return CAN_DELETE
     */
    public String getCanDelete() {
        return canDelete;
    }

    /**
     * @param canDelete
     */
    public void setCanDelete(String canDelete) {
        this.canDelete = canDelete;
    }

}