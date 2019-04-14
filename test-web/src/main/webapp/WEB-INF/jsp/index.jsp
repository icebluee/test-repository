<%--
  Created by IntelliJ IDEA.
  User: 可乐鸡还是好吃
  Date: 2019/3/16
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
    <div align="center" >
        讨论版区：
        <select id="sort">
            <option value="-1">--请选择--</option>
        </select>
        <input type="button" value="搜索" id="search">
    </div>
    <div style="width: 80%;text-align: right">
        <input type="button" value="发帖" id="" onclick="window.location.href='toAdd'">
    </div>
    <br>
    <table id="mytable" border="1" cellpadding="0" cellspacing="0" width="60%" align="center">
        <tr>
            <th>帖子ID</th>
            <th>标题</th>
            <th>作者</th>
            <th>发布时间</th>
            <th>回复次数</th>
        </tr>
    </table>
    <%if (request.getAttribute("msg") == "true"){%>
    <script>alert('添加成功!')</script><%}%>
    <%if (request.getAttribute("msg") == "false"){%>
    <script>alert('添加失败!')</script><%}%>
</body>

<script>
    //页面加载时就执行,!!!一定记得调用
    $(function () {
        //展示列表
        show();
        //展示分类
        getSorts();

        $("#search").click(function () {
            var sortId = $("#sort").val();
            show(sortId);
        });


    });

    //展示所有数据
    function show(sortId) {
        $.post("/show",{"sortId":sortId},function (result) {
            //将结果集写出
//            $("#mytable tr:")
            $("#mytable tr:gt(0)").empty();
            for (var i=0;i<result.length;i++){
                //依次取出detail对象
                var detail = result[i];
                var $tr = $("<tr><td>"+detail.id+"</td><td>"+detail.title+"</td><td>"+detail.author+"</td><td>"+JD.formatDateTime(detail.craetedate)+
                "</td><td>"+detail.replycount+"</td></tr>");
                $("#mytable").append($tr);
            }
        })
    }
    
    function getSorts() {
        $.post("/getSortList",null,function (result) {
            for (var i=0;i<result.length;i++){
                //依次取出sort对象
                var sort = result[i];
                var $option = $("<option value='"+sort.id+"'>"+sort.name+"</option>");
                $("#sort").append($option);
            }
        })
    }


</script>

<script>
    Date.prototype.format = function(format){
        var o =  {
            "M+" : this.getMonth()+1, //month
            "d+" : this.getDate(), //day
            "h+" : this.getHours(), //hour
            "m+" : this.getMinutes(), //minute
            "s+" : this.getSeconds(), //second
            "q+" : Math.floor((this.getMonth()+3)/3), //quarter
            "S" : this.getMilliseconds() //millisecond
        };
        if(/(y+)/.test(format)){
            format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        }
        for(var k in o)  {
            if(new RegExp("("+ k +")").test(format)){
                format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
            }
        }
        return format;
    };
    var jd = JD = {
        // 格式化时间
        formatDateTime : function(val){
            var now = new Date(val);
            return now.format("yyyy-MM-dd hh:mm:ss");
        }
    }
</script>
</html>
