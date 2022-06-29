package com.weaver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weaver.database.data.Module;
import com.weaver.database.mapper.ModuleMapper;
import com.weaver.resopnse.BaseResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lzy
 * @version v1.0
 * @description
 * @date:21/07/21 11:24
 */
@Controller
@RestController
@RequestMapping("/module")
public class ModuleController {
    @Resource
    private ModuleMapper moduleMapper;

    @RequestMapping("/search")
    public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Module> moduleList = moduleMapper.selectAll();
        BaseResponse result = BaseResponse.success(moduleList);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/insert")
    public String insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponse result = BaseResponse.success();
        String res = IOUtils.toString(request.getInputStream());
        Module m = JSONObject.parseObject(res, Module.class);
        moduleMapper.insertSelective(m);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponse result = BaseResponse.success();
        String res = IOUtils.toString(request.getInputStream());
        Module m = JSONObject.parseObject(res, Module.class);
        moduleMapper.updateByPrimaryKeySelective(m);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponse result = BaseResponse.success();
        String res = IOUtils.toString(request.getInputStream());
        Module m = JSONObject.parseObject(res, Module.class);
        moduleMapper.deleteByPrimaryKey(m);
        return JSON.toJSONString(result);
    }

}
