package com.weaver.database.impl;

import com.weaver.database.dao.MenuDao;
import com.weaver.database.data.Menu;
import com.weaver.database.mapper.MenuMapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lzy
 * @version v1.0
 * @description
 * @date:22/06/29 10:10
 */
@Repository
public class MenuDaoImpl implements MenuDao {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectAll(Menu condition) {
        Example select = new Example(Menu.class);
        select.createCriteria().andEqualTo("moduleId", condition.getModuleId());
        select.selectProperties("id", "menuName", "parentId", "moduleId");
        select.orderBy("id").asc();
        return menuMapper.selectByExample(select);
    }
}
