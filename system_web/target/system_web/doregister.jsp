<%--
  Created by IntelliJ IDEA.
  User: bbb
  Date: 2020/4/30
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv= "Refresh"content="2;url=${pageContext.request.contextPath}/login.jsp" charset="utf-8">
    <title>Insert title here</title>
    <script>

        var times=4;

        clock();

        function clock()

        {

            window.setTimeout('clock()',1000);

            times=times-1;

            time.innerHTML =times;

        }
    </script>
</head>
<body>
<script>alert("注册成功");</script>
<table>

    <tr>

        <td>该页面将在 </td>

        <td> <strong><div id= "time"> 3</div></strong> </td>

        <td>秒后自动跳转回到登录界面 </td>

    </tr>

</table>

</body>
</html>