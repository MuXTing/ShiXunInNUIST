<%--
  Created by IntelliJ IDEA.
  User: 13812
  Date: 2019/8/28
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <title>人物信息</title>
<%--    D:\ComputerScience\JavaProject\ThirdPro\src\main\webapp\static\js\--%>
    <style>
    </style>
</head>
<body background="static/image/3.png">
<div class="panel panel-primary">
    <div class="panel-heading">
        <h4 class="panel-title">欢迎${loginStu.sname}登录</h4>
        <h4><a href="/logout" style="text-decoration: none;color: white;">登出</a> </h4>
    </div>
    <div class="panel-body">
        <label>
            按编号查询:
            <input type="search" value="" name="sno" id="searchSno">
            <input type="button" value="查询" class="btn btn-primary" id="searchBtn">

        </label>
        <label>添加人物
            <input type="button" value="添加" class="btn btn-primary" data-toggle="modal" data-target="#alterModal"
                   id="add">
        </label>
    </div>
</div>

<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>属国</td>
        <td>密码</td>
        <td colspan="2">操作</td>
    </tr>
    </thead>
    <tbody>
<%--tbody is here--%>
    </tbody>
<%--模态框--%>
    <div class="modal fade" id="alterModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改/添加人物信息
                    </h4>
                </div>
<%--HTML表单--%>
                <form class="form-inline" id="updateForm">
                    <div class="modal-body" id="updateModal">
                        <div class="panel-body ">
                            <label>
                                人物学号：
                                <input type="text" name="sno" value="" id="alterSno" required>
                            </label>
                            <label>
                                人物姓名：
                                <input type="text" name="sname" value="" id="alterSname" required>
                            </label>
                            <label>
                                人物性别：
                                <input type="text" name="ssex" value="" id="alterSsex" required>
                            </label>
                            <label>
                                人物年龄：
                                <input type="text" name="sage" value="" id="alterSage" required>
                            </label>
                            <label>
                                人物属国：
                                <input type="text" name="scountry" value="" id="alterScountry" required>
                            </label>
                            <label>
                                人物密码：
                                <input type="text" name="spwd" value="" id="alterSpwd" required>
                            </label>
                        </div>
                        <div id="alterMsg" style="color: orange"></div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="button" class="btn btn-primary" id="submitBtn">
                            提交
                        </button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

</table>
<script src="static/js/jquery-3.3.1.js"></script>
<script src="static/js/main.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script>
    const tbody = document.querySelector("table tbody")
    const  main = new Main()
    //const  data=main.getStudent()
    main.getStudent(tbody)

    const search = document.getElementById("searchBtn");
    search.onclick = function(){
        const querryData = $("#searchSno").serialize();
        console.log(querryData);
        main.getStudent(tbody, querryData);
    }
    //update更新操作
    $(tbody).on('click', '.update', function () {
        // console.log(123456789)
        document.getElementById("updateForm").action="update"
        console.log(this.dataset.sno)
        main.getStudent("#updateForm", {sno: this.dataset.sno})
        $("#alterSno").attr("readonly", "readonly")
    })

    // add更新操作
    $(add).on('click', function () {
        console.log("添加请求")
        document.getElementById("updateForm").action="add"
        // main.getStudent("#updateForm", {sno: this.dataset.sno})
        main.operationStudent($("#updateForm")[0], {sno:this.dataset.sno}, tbody)
    })

    //删除
    $(tbody).on('click', '.delete', function () {
        console.log("delete请求")
        document.getElementById("updateForm").action="delete"
        // console.log(this.dataset.sno)
        // main.getStudent("#updateForm", {sno: this.dataset.sno})
        // $("#alterSno").attr("readonly", "readonly")
        main.operationStudent($("#updateForm")[0], {sno: this.dataset.sno}, tbody)
    })
    // add更新操作
    // $(add).on('click', function () {
        // document.getElementById("updateForm").action="add"
    // })

    // 模态框提交按钮
    $(submitBtn).on('click', function () {
        main.operationStudent($("#updateForm")[0], $("#updateForm").serialize(),tbody)
        $("#alterModal").modal('hide')
    })
    //
    $("#alterModal").on('hide.bs.modal', function(){
        $("#updateForm")[0].reset()
        $(alterMsg).html()
        // alterMsg.innerHTML = ""
        document.getElementById("alterSno").removeAttribute('readonly')
        document.getElementById("updateForm").action=""
    })
</script>
</body>
</html>
