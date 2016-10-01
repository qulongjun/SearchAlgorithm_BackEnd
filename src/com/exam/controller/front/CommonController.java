package com.exam.controller.front;

import com.jfinal.core.Controller;

/**
 * Created by qulongjun on 16/5/28.
 */
public class CommonController extends Controller {
    public void index() {
        render("index.html");
    }

    public void build() {

        System.out.println("cdsds");
        render("build.html");

    }
}
