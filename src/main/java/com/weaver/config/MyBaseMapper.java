package com.weaver.config;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.condition.DeleteByConditionMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleSelectiveMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface MyBaseMapper<T> extends
        BaseMapper<T>,
        InsertUseGeneratedKeysMapper<T>,
        InsertListMapper<T>,
        UpdateByExampleMapper<T>,
        UpdateByExampleSelectiveMapper<T>,
        SelectByExampleMapper<T>,
        BatchInsertListMapper<T>,
        DeleteByConditionMapper<T> {
}
