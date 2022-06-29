package com.weaver.database.data;

import javax.persistence.*;

@Table(name = "t_menu")
public class Menu {
    @Id
    private Integer id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 父菜单id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 模块id
     */
    @Column(name = "module_id")
    private Integer moduleId;

    /**
     * 菜单内容
     */
    private String content;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取父菜单id
     *
     * @return parent_id - 父菜单id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单id
     *
     * @param parentId 父菜单id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取模块id
     *
     * @return module_id - 模块id
     */
    public Integer getModuleId() {
        return moduleId;
    }

    /**
     * 设置模块id
     *
     * @param moduleId 模块id
     */
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 获取菜单内容
     *
     * @return content - 菜单内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置菜单内容
     *
     * @param content 菜单内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

}
