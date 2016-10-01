package com.exam.config;

import com.exam.controller.front.CommonController;
import com.jfinal.config.Routes;

/**
 * 前端页面路由
 */
public class FrontRoutes extends Routes {
    @Override
    public void config() {
        add("/", CommonController.class, "/");
    }
}
