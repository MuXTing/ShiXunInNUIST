package com.iweb.servlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import java.util.Scanner;
public class JDBCUtil {
    //连接数据库
    public static Connection getconnection() {
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "sunguanglin", "zyszrsfbszy@557");
            //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

    //    增加插入
    public static void insert(String sql) {
        Connection conn = getconnection();
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //    删除
    public static void delete(String sql) {
        insert(sql);
    }


    //查询
    public static ArrayList<Student> select(String sql) {
        System.out.println("sql是" + sql);
        ArrayList<Student> studentslist = new ArrayList<>();
        Connection conn = getconnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
//                student.setSno(resultSet.getInt("sno"));
//                student.setSname(resultSet.getString("sname"));
//                student.setSage(resultSet.getInt("sage"));
//                student.setSsex(resultSet.getString("ssex"));
//                student.setScountry(resultSet.getString("scountry"));
//                student.setSpwd(resultSet.getString("spwd"));
                student.setAll(resultSet.getInt("sno"), resultSet.getString("sname"), resultSet.getInt("sage"), resultSet.getString("ssex"), resultSet.getString("scountry"), resultSet.getString("spwd"));
                studentslist.add(student);
//                System.out.println("查询到");
            }
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
        return studentslist;
    }

    //    修改更新
    public static void update(String sql) {
        System.out.println("update 的 sql是" + sql);
        List<Student> studentList = new ArrayList<>();
        Connection conn = getconnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            System.out.println("执行更新");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

