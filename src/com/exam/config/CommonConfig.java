package com.exam.config;

import com.jfinal.config.*;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

/**
 * JFinal通用配置文件
 */
public class CommonConfig extends JFinalConfig {
    /**
     * 配置JFInal的常量
     *
     * @param me
     */
    @Override
    public void configConstant(Constants me) {
        //读取配置文件
        loadPropertyFile("config.properties");
        //设置开发模式,如果设置为true,控制台会输出每次请求的Controller action和参数信息
        me.setDevMode(getPropertyToBoolean("devMode", false));
        //设置视图模型
        me.setViewType(ViewType.JSP);
        me.setBaseViewPath("/WEB-INF/pages");
        //me.setError404View("404.html");
        //设置下载路径
        // me.setBaseDownloadPath("/WEB-INF/download");
        //设置上传路径
        me.setBaseUploadPath(PathKit.getWebRootPath() + "/WEB-INF/upload");
        //http://localhost:8080/blog/1-3
        me.setUrlParaSeparator("-");
        me.setError403View("/WEB-INF/pages/common/404.html");
    }

    @Override
    public void configRoute(Routes me) {
        //前端页面路由
        me.add(new FrontRoutes());
        //管理页面路由
        //me.add(new AdminRoutes());
    }

    @Override
    public void configPlugin(Plugins me) {
        C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/blog_db", "root", "admin");
        me.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        me.add(arp);
        //arp.addMapping("blog_user", User.class);
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
