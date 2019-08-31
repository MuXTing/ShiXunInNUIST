package com.iweb.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "studentServlet" ,urlPatterns = {"/login" ,"/getStudent","/main","/logout","/add", "/update", "/delete"})
public class StudentServlet extends HttpServlet {
    private  static  final String SESSION_LOGIN_STU="loginStu";
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(this);
        System.out.println("正在初始化，请等候...");
    }
//    一下为诸多方法
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String seveletPath=request.getServletPath();
        switch (seveletPath){
            case "/login":
                login(request, response);
                break;
            case  "/getStudent":
                getStudent(request,response);
                break;
            case "/main":
                main(request,response);
                break;
            case  "/logout":
                logout(request,response);
                break;
            case "/add":
                add(request, response);
                break;
            case "/update":
                update(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        doPost(request,response);
    }
    private void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("sno"));
        System.out.println(request.getParameter("spwd"));
        //通过request获得前台传递的参数
        String sno=request.getParameter("sno");
        String spwd=request.getParameter("spwd");
        //accept阻塞方法
        String sql="select * from student where sno='"+sno+"' and spwd='"+spwd+"'";
        System.out.println(sql);
        List<Student> select=JDBCUtil.select(sql);
        PrintWriter writer=response.getWriter();
        //实例化datautil
        DataUtil datautil=new DataUtil();
        if(!select.isEmpty()){
            System.out.println("登录成功");
            datautil.setResult(true);
            //session中放入登录信息
            //重定向
            request.getSession().setAttribute(SESSION_LOGIN_STU,select.get(0));
            //response.sendRedirect("main.jsp");
        }else{
            System.out.println("已经进入login");
            datautil.setMsg("用户名或密码名错误");
        }
        writer.print(JSON.toJSON(datautil));
        writer.close();
    }
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
        System.out.println("我进入了ADD方法");
//        Student instance = BeanUtils.getInstance(Student.class, request);
//        instance是一个学生的对象.
//        System.out.println(instance);
//        String insertSql = JDBCUtil.getInsertSql(instance);
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        String sage = request.getParameter("sage");
        String ssex= request.getParameter("ssex");
        String scountry = request.getParameter("scountry");
        String spwd = request.getParameter(("spwd"));
//        String insertSql = "update student set sname = '" + sname + "', ssex='" + ssex + "', sage ='" + sage + "' where sno='" + sno + "'";
        String insertSql = "insert into student(sno, sname, sage, ssex, scountry, spwd)"+" value("+ sno +",'"+ sname + "',"+ sage + ",'" + ssex + "','"+ scountry + "'," + spwd + ")";
        System.out.println(insertSql);
        JDBCUtil.insert(insertSql);

        PrintWriter writer = response.getWriter();
        writer.print(JSON.toJSON(new DataUtil()));
        writer.close();
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String sno= request.getParameter("sno");
        String sql = "delete from student where sno='" + sno + "'";
        JDBCUtil.delete(sql);
        PrintWriter writer = response.getWriter();
        writer.print(JSON.toJSON(new DataUtil()));
        writer.close();
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("我进入了UPDATE的方法");
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        String sage = request.getParameter("sage");
        String ssex= request.getParameter("ssex");
        String scountry= request.getParameter("scountry");
        String spwd= request.getParameter("spwd");
//        String sclass = request.getParameter("sclass");

        String sql = "update student set sname = '" + sname + "', ssex='" + ssex + "', sage ='" + sage + "', scountry='" + scountry+ "', spwd='" + spwd+ "' where sno='" + sno + "'";
        System.out.println("这里是update的"+sql);
        JDBCUtil.update(sql);
        DataUtil dataUtil = new DataUtil();
        dataUtil.setResult(true);
        response.getWriter().print(JSON.toJSON(dataUtil));
    }
    private void getStudent(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
        String sno = request.getParameter("sno");
        System.out.println("sno = " + sno);
        StringBuffer sql = new StringBuffer("select * from student");
//        commons-lang3包中的StringUtils进行字符串的判定。
        if (sno != null && !"".equals(sno))
        {
            sql.append(" where sno='" + sno +"'");
        }
        System.out.println(sql.toString());
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer=response.getWriter();
        List<Student> select=JDBCUtil.select(sql.toString());
        Object o= JSON.toJSON(select);
        writer.print(o);
        writer.close();
    }
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
        //登出，将session失效
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }
    private void main(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //所有跳转 main请求的都必须要验证session中是否有登录验证
        //如果有 执行请求
        HttpSession session=request.getSession();
        Object attribute=session.getAttribute(SESSION_LOGIN_STU);
        if(attribute!=null){
            System.out.println("main进入成功 attribute不为空 跳转");
            request.getRequestDispatcher("main.jsp").forward(request,response);

        }else {//如果没有说明没登录 跳转index.jsp
            System.out.println("没登录 跳转index.jsp");
            response.sendRedirect("index.jsp");
        }

    }
    public void destroy() {
        System.out.println("注销了,拜拜了您的。 ");
    }
}
