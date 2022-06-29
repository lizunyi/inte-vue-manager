package com.weaver.controller;

import com.alibaba.fastjson.JSONObject;
import com.weaver.database.dao.MenuDao;
import com.weaver.database.data.Menu;
import com.weaver.database.mapper.MenuMapper;
import com.weaver.resopnse.BaseResponse;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LogManager.getLogger("common-default");

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private MenuDao menuDao;


    @RequestMapping("/search")
    public String search(HttpServletRequest request, HttpServletResponse response) {
        try {
            String res = IOUtils.toString(request.getInputStream());
            Menu m = JSONObject.parseObject(res, Menu.class);
            List<Menu> menuList = menuDao.selectAll(m);
            BaseResponse result = BaseResponse.success(menuList);
            return result.toString();
        } catch (Exception e) {
            logger.error("", e);
            return BaseResponse.fail().toString();
        }
    }

    @RequestMapping("/searchId")
    public String searchId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String res = IOUtils.toString(request.getInputStream());
            Menu m = JSONObject.parseObject(res, Menu.class);
            m = menuMapper.selectByPrimaryKey(m.getId());
            BaseResponse result = BaseResponse.success(m);
            return result.toString();
        } catch (Exception e) {
            logger.error("", e);
            return BaseResponse.fail().toString();
        }
    }

    @RequestMapping("/insert")
    public String insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            BaseResponse result = BaseResponse.success();
            String res = IOUtils.toString(request.getInputStream());
            Menu m = JSONObject.parseObject(res, Menu.class);
            if(m.getParentId() == null){
                m.setParentId(0);
            }
            menuMapper.insertSelective(m);
            return result.toString();
        } catch (Exception e) {
            logger.error("", e);
            return BaseResponse.fail().toString();
        }
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            BaseResponse result = BaseResponse.success();
            String res = IOUtils.toString(request.getInputStream());
            Menu m = JSONObject.parseObject(res, Menu.class);
            menuMapper.updateByPrimaryKeySelective(m);
            return result.toString();
        } catch (Exception e) {
            logger.error("", e);
            return BaseResponse.fail().toString();
        }
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            BaseResponse result = BaseResponse.success();
            String res = IOUtils.toString(request.getInputStream());
            Menu m = JSONObject.parseObject(res, Menu.class);
            menuMapper.deleteByPrimaryKey(m);
            return result.toString();
        } catch (Exception e) {
            logger.error("", e);
            return BaseResponse.fail().toString();
        }
    }
}
