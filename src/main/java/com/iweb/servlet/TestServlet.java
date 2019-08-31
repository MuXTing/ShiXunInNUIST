package com.iweb.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "testServlet",urlPatterns = {"/test"},loadOnStartup = 1)
public class TestServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("正在初始化testservlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("收到请求");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("test"));
        PrintWriter writer=response.getWriter();
        List<Student> select=JDBCUtil.select("select * from student");
        Object o= JSON.toJSON(select);
        System.out.println(o);
        writer.print(o);
        writer.close();
    }
}
