<%--
  Created by IntelliJ IDEA.
  User: 可乐鸡还是好吃
  Date: 2019/3/16
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>发帖</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(function () {
           getSorts();

        });

        function getSorts() {
            $.post("/getSortList",null,function (result) {
                for (var i=0;i<result.length;i++){
                    //依次取出sort对象
                    var sort = result[i];
                    var $option = $("<option value='"+sort.id+"'>"+sort.name+"</option>");
                    $("#sortid").append($option);

                }
            })
        }

    </script>
</head>
<body>
    <form action="/addList" id="addform" method="post" onsubmit="return sb1()">
        <table width="40%" border="1" cellspacing="0" cellpadding="0" align="center">
            <tr align="center">
                <td colspan="2">发布新帖</td>
            </tr>
            <tr>
                <td>发布版区</td>
                <td>
                    <select id="sortid" name="sortid" >

                    </select>
                </td>
            </tr>
            <tr>
                <td>作者</td>
                <td>
                    <input type="text" name="author" id="author"><a style="color: red">*</a>
                </td>
            </tr>
            <tr>
                <td>标题</td>
                <td><input type="text" name="title" id="title"><a style="color: red">*</a></td>
            </tr>
            <tr>
                <td>详细内容</td>
                <td><textarea id="detail" name="detail"></textarea><a style="color: red">*</a></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交">
                    <input type="button" value="返回" onclick="history.go(-1)">
                </td>
            </tr>

        </table>
    </form>
<script>

    function sb1() {
        var author = document.getElementById("author");
        var title = document.getElementById("title");
        var detail = document.getElementById("detail");
        if (trim(author.value) == null || trim(author.value) == "") {
            alert("请输入作者!");
            author.focus();
            return false;
        }
        if (trim(title.value) == null || trim(title.value) == "") {
            alert("请输入标题!");
            title.focus();
            return false;
        }
        if (trim(detail.value) == null || trim(detail.value) == "") {
            alert("请输入详细内容!");
            detail.focus();
            return false;
        }
        return true;
    }

    function trim(str) { //删除左右两端的空格
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }

    /*function isEmpt() {
        var title = $("#title").val();
        var detail = $("#detail").val();
        var author = $("#author").val();
        if ( form.title.val()==null && title==null &&title ==""){
            alert('标题不能为空!');
            form.title.focus();
            return false;
        }
        /!*if (detail==null){
            alert('详情不能为空!')
        }
        if (author == null){
            alert('作者不能为空!')
        }*!/
    }*/
</script>
</body>
</html>
