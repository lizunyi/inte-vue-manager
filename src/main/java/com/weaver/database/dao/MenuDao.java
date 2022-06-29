package com.weaver.database.dao;

import com.weaver.config.MyBaseMapper;
import com.weaver.database.data.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lzy
 * @version v1.0
 * @description
 * @date:22/06/28 15:32
 */
public interface MenuDao {
    List<Menu> selectAll(Menu condition);
}
