function Main() {
    this.studentJson=[]
}

Main.prototype.getStudent=function (element, queryData={}) {
    // console.log(element)
    $.ajax({
        url:"/getStudent",  //请求的URL
        method:'get', //该ajax请求的方法
        data: queryData, // 传过去的参数
        dataType:'JSON',
        success:(data)=>{ // 这个data是还回来的结果
            this.showStudnt(element,data)
        },
        error:error=>{
            console.log(error)
        }
    })
}

Main.prototype.showStudnt=function (element,data) {
    let content = ''
    if (element === "#updateForm"){
        $("#alterSno").val(data[0].sno)
        $("#alterSname").val(data[0].sname)
        $("#alterSsex").val(data[0].ssex)
        $("#alterSage").val(data[0].sage)
        $("#alterScountry").val(data[0].scountry)
        $("#alterSpwd").val(data[0].spwd)
    }else {
        console.log(data)
        if (data.length == 0) {
            content = "<td><td colspan='8'>无查询结果</td></tr>"
        } else {
            data.forEach(function (e) {
                content += "<tr><td>" + e.sno + "</td><td>" + e.sname + "</td><td>" + e.sage + "</td><td>" + e.ssex + "</td><td>" + e.scountry + "</td><td>"+ e.spwd + "</td>" + "<td><a data-sno='" + e.sno +
                    "' class='update'  data-toggle='modal' data-target='#alterModal';  >修改</a></td><td>" +
                    "<a data-sno='" + e.sno + "' class='delete' >删除</a></td><tr>"

            })
        }
    }
    element.innerHTML = content
}

Main.prototype.operationStudent=function (element, data, showEle) {
    //action 值 判断是添加还是更新
    const  action=element.action
    $.ajax({
        url:action,
        data:data,
        dataType: 'JSON',
        success:data=>{
            this.getStudent(showEle)
        },
        error:error=>{
            console.log(error)
        }
    })
}

