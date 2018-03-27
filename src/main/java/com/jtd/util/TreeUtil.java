package com.jtd.util;

import com.jtd.dto.MenuDto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeUtil {

    /**
     * 将菜单转换成树节�?
     *
     * @param list 菜单集合
     * @return 树集合列�?
     */
    public static List<MenuDto> getChildTreeObjects(List<MenuDto> list) {
        List<MenuDto> returnList = new ArrayList<MenuDto>();
        for (Iterator<MenuDto> iterator = list.iterator(); iterator
                .hasNext(); ) {
            MenuDto t = iterator.next();
            if (t.getParentMenuId() == null) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private static void recursionFn(List<MenuDto> list, MenuDto t) {
        List<MenuDto> childList = getChildList(list, t);// 得到子节点列�?
        if (childList.size() == 0) {
            return;
        }
        t.setNodes(childList);
        for (MenuDto tChild : childList) {
            recursionFn(list, tChild);
        }
    }

    // 得到子节点列�?
    private static List<MenuDto> getChildList(List<MenuDto> list, MenuDto t) {

        List<MenuDto> tlist = new ArrayList<MenuDto>();
        Iterator<MenuDto> it = list.iterator();
        while (it.hasNext()) {
            MenuDto n = it.next();
            if (n.getParentMenuId() !=null && n.getParentMenuId().equals(t.getId())) {
                tlist.add(n);
            }
        }
        return tlist;
    }


    /**
     * 标记代办 迭代父节点并标记父节点代办标�?
     *
     * @param list 树菜�?
     * @param t    标记叶子节点
     */
    public static void flagTodoTask(List<MenuDto> list, MenuDto t) {
        Iterator<MenuDto> it = list.iterator();
        while (it.hasNext()) {
            MenuDto n = it.next();
            if (t.getParentMenuId() != null && n.getId().equals(t.getParentMenuId())) {
                n.setShowTodo(true);
                flagTodoTask(list, n);
            }
        }
    }

}
