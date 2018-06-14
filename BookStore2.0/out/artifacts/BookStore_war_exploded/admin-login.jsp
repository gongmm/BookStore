
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link href="css/css1.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="two">
    <div class="container">
        <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">

            <!--登录-->
            <div class="web_login" id="web_login">


                <div class="login-box">


                    <div class="login_form">

                        <%--<form action="" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">--%>
                        <form action="servlet/alogin" id="login_form" class="loginForm">
                            <%--隐藏另一页面中的输入框--%>
                            <input type="hidden" name="did" value="0"/>
                            <input type="hidden" name="to" value="log"/>
                            <div class="uinArea" id="uinArea">
                                <label class="input-tips" for="u">账号：</label>
                                <div class="inputOuter" id="uArea">
                                    <input type="text" name="AdminName" id="u" class="inputstyle"/>
                                    <%--<input type="text" id="u" name="username" class="inputstyle"/>--%>
                                </div>
                            </div>
                            <div class="pwdArea" id="pwdArea">
                                <label class="input-tips" for="p">密码：</label>
                                <div class="inputOuter" id="pArea">

                                    <%--<input type="password" id="p" name="p" class="inputstyle"/>--%>
                                    <input type="password" name="AdminPwd" id="p" class="inputstyle"/>
                                </div>
                            </div>

                            <div style="margin-top:20px;">
                                <input type="submit" value="登录" style="width:100px;" class="button_blue"/>
                                <%--<input type="submit" value="登 录" style="width:100px;" class="button_blue"/>--%>
                            </div>
                        </form>
                    </div>

                </div>

            </div>
    </div>
    </div>
</div>
</body>
</html>
