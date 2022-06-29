package com.weaver.database.data;

import javax.persistence.*;

@Table(name = "t_module")
public class Module {
    @Id
    private Integer id;

    /**
     * 大模块名称
     */
    @Column(name = "module_name")
    private String moduleName;

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
     * 获取大模块名称
     *
     * @return module_name - 大模块名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置大模块名称
     *
     * @param moduleName 大模块名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }
}
