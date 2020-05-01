<%--
  Created by IntelliJ IDEA.
  User: bbb
  Date: 2020/4/30
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>
        数据 - AdminLTE2定制版 | Log in</title>


    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- Theme style -->
    <!-- iCheck -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="js/jquery-1.4.2.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">


        <a href="all-admin-index.html">房屋租赁系统</a>


    </div>

    <div class="register-box-body">
        <p class="login-box-msg">新用户注册</p>

        <form action="user/register" method="post">
            <div class="form-group has-feedback">
                <input required="required" id="username" name="username" type="text" class="form-control" placeholder="用户名" onchange="checkoutUsername()">
                <span class="glyphicon glyphicon-user form-control-feedback" ></span>
                <span id="usernameSpan" class="text-center" style="color: red"></span>
            </div>
            <div class="form-group has-feedback">
                <input required="required" type="email" class="form-control" placeholder="Email" name="email" id="email" onchange="checkoutEmail()">
                <span class="glyphicon glyphicon-envelope form-control-feedback" ></span>
                <span id="emailSpan" class="text-center" style="color: red"></span>
            </div>
            <div class="form-group has-feedback">
                <input required="required" type="password" class="form-control" placeholder="密码" name="password" id="password">
                <span class="glyphicon glyphicon-lock form-control-feedback" ></span>
            </div>
            <div class="form-group has-feedback">
                <input required="required" type="password" class="form-control" placeholder="确认密码" id="repassword" onchange="checkoutRepassword()">
                <span class="glyphicon glyphicon-log-in form-control-feedback" ></span>
                <span id="repasswordSpan" class="text-center" style="color: red"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck " >
                        <label>
                            <input id="protocol" type="checkbox" required="required"> 我同意 <a href="#">协议</a>
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat" onclick="return checkoutAll()">注册</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <%--<div class="social-auth-links text-center">
            <p>- 或者 -</p>
            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-qq"></i> 腾讯QQ用户登录</a>
            <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-weixin"></i> 微信用户登录</a>
        </div>--%>

        <a href="all-admin-login.html" class="text-center">我有账号，现在就去登录</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>

<script>
    function checkoutUsername(){
        var username = $('#username').val();
        $.get("${pageContext.request.contextPath}/user/findUserByUsername?username="+username,function (data) {
            if (null != data && "" != data){
                $("#usernameSpan").text("用户名已存在");
                return false;
            }else {
                $("#usernameSpan").text("");
                return true;
            }
        });
    }

    function checkoutEmail(){
        var email = $("#email").val();
        var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (reg.test(email) ){
            $("#emailSpan").text("");
            return true;
        }else {
            $("#emailSpan").text("邮箱格式错误");
            return false;
        }
    }

    function checkoutRepassword(){
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        if(repassword != password && repassword != ""){
            $("#repasswordSpan").text("两次密码不一致");
            return false;
        }else {
            $("#repasswordSpan").text("");
            return true;
        }
    }



    function checkoutAll(){
       if(checkoutRepassword()&&checkoutEmail()&&checkoutEmail()){
           return true;
       }else {
           return false;
       }
    }
    $(function() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

    });
</script>
</body>
</html>
