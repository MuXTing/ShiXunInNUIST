<%--
  Created by IntelliJ IDEA.
  User: 13812
  Date: 2019/8/28
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
    <style>
        /*body*/
        /*{*/
        /*    background:url(static/image/4.jpg);*/
        /*    background-size:cover;*/
        /*    background-repeat:no-repeat;*/
        /*}*/
    </style>
</head>
<body >
<%--<div  style="background-image:url(image/1.png)">--%>
    <div class="panel panel-primary">
        <%--    <img src ="image/1.png" />--%>
        <div class="panel-heading">
            <h4 class="panel-title">登录</h4>
        </div>
        <form action="" method="post" id="logForm">
            <div class="panel-body">
                <label>编号：<input type="text" name="sno" value="<%=request.getParameter("sno")==null?"":request.getParameter("sno")%>"></label>
                <label>密码：<input type="password" name="spwd"  value="<%=request.getParameter("spwd")==null?"":request.getParameter("spwd")%>" ></label>
            </div>
            <input value="登录" type="submit" class="btn btn-primary"  id="loginBtn">
        </form>

    </div>
<%--</div>--%>

<%--插值表达式--%>
<div><span id="msg" style="color: orange"></span></div>
<script src="static/js/jquery-3.3.1.js"></script>
<script>
    /*利用jquery的选择器 */
    // import * as $ from "./jquery";

    $("#loginBtn").on('click',function () {
        console.log("获取表单数据")
        const logData=$("#logForm").serialize() //获取表单数据
        console.log((logData))
        //提交异步的ajax请求

        $.ajax({
            url:'/login',
            method:'get',
            data:logData,
            dataType:'JSON',
            success: (data)=> {
                console.log("正确  success函数")
                if(data.result){
                    console.log("请求到值 进入main方法")
                    console.log(data)
                    window.location.href="main"
                }else {
                    console.log(data.msg)
                    $("#msg").html(data.msg)
                }
            },
            error: (error)=>{
                $("#msg").html(data.msg)
            }
        })
        return false//阻止默认 submit按钮的提交功能
    })
</script>
</body>
</html>
