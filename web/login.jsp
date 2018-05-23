
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <link href="css/css1.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div class="two">


    <%--<img src="images/studying1.png" class="logo" alt="background">--%>
    <div class="container">
        <div class="header">
            <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">登录</a>
                <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">注册</a>
                <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 50%; left: 0px;">

                </div>
            </div>
        </div>
        <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">

            <!--登录-->
            <div class="web_login" id="web_login">


                <div class="login-box">


                    <div class="login_form">

                        <%--<form action="" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">--%>
                        <form action="servlet/login" id="login_form" class="loginForm">
                            <%--隐藏另一页面中的输入框--%>
                            <input type="hidden" name="did" value="0"/>
                            <input type="hidden" name="to" value="log"/>
                            <div class="uinArea" id="uinArea">
                                <label class="input-tips" for="u">账号：</label>
                                <div class="inputOuter" id="uArea">
                                    <input type="text" name="CustomerName" id="u" class="inputstyle"/>
                                    <%--<input type="text" id="u" name="username" class="inputstyle"/>--%>
                                </div>
                            </div>
                            <div class="pwdArea" id="pwdArea">
                                <label class="input-tips" for="p">密码：</label>
                                <div class="inputOuter" id="pArea">

                                    <%--<input type="password" id="p" name="p" class="inputstyle"/>--%>
                                    <input type="password" name="CustomerPwd" id="p" class="inputstyle"/>
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
            <!--登录end-->
        </div>


        <!--注册-->
        <div class="qlogin" id="qlogin" style="display: none; ">

            <div class="web_login" style="padding-top: 30px;">
                <form action="servlet/register" id="regUser" method="post">
                    <%--隐藏另一页面中的输入框--%>
                    <input type="hidden" name="did" value="0"/>
                    <input type="hidden" name="to" value="log"/>
                <%--<form name="form2" id="regUser" accept-charset="utf-8"  action="" method="post">--%>

                <ul class="reg_form" id="reg-ul">
                    <li>

                        <label for="user"  class="input-tips2">昵称：</label>
                        <div class="inputOuter2">
                            <input type="text" name="CustomerName" id="user" maxlength="16" class="inputstyle2"/>
                            <%--<input type="text" id="user" name="user" maxlength="16" class="inputstyle2"/>--%>
                        </div>

                    </li>

                    <li>
                        <label for="tureName" class="input-tips2">真实姓名：</label>
                        <div class="inputOuter2">
                            <input type="text" name="CustomerTrueName" id="tureName" maxlength="16" class="inputstyle2"/>
                            <%--<input type="password" id="passwd"  name="passwd" maxlength="16" class="inputstyle2"/>--%>
                        </div>

                    </li>

                    <li>
                        <label for="sex"  class="input-tips2">性别：</label>
                        <div class="inputOuter2">
                            <input type="text" name="CustomerSex" id="sex" class="inputstyle2"/>
                            <%--<input type="text" id="testcode" name="user" maxlength="16" class="inputstyle2"/>--%>
                        </div>
                    </li>

                    <li>
                        <label for="tel"  class="input-tips2">手机号：</label>
                        <div class="inputOuter2">
                            <input type="text" name="CustomerTel" id="tel" class="inputstyle2"/>
                            <%--<input type="text" name="CustomerSex" id="sex" class="inputstyle2"/>--%>
                        </div>
                    </li>

                    <li>
                        <label for="Email"  class="input-tips2">电子邮箱：</label>
                        <div class="inputOuter2">
                            <input type="text" name="CustomerEmail" id="Email" class="inputstyle2"/>
                            <%--<input type="text" name="CustomerSex" id="sex" class="inputstyle2"/>--%>
                        </div>
                    </li>

                    <li>
                        <label for="address"  class="input-tips2">地址：</label>
                        <div class="inputOuter2">
                            <input type="text" name="CustomerAddr" id="address" class="inputstyle2"/>
                            <%--<input type="text" name="CustomerSex" id="sex" class="inputstyle2"/>--%>
                        </div>
                    </li>

                    <li>
                        <label for="password"  class="input-tips2">密码：</label>
                        <div class="inputOuter2">
                            <input type="password" name="CustomerPwd" id="password" class="inputstyle2"/>
                            <%--<input type="text" name="CustomerSex" id="sex" class="inputstyle2"/>--%>
                        </div>
                    </li>


                    <li>
                        <div class="inputArea">
                            <input type="submit" value="注册" id="reg"  style="padding: 5px 35px; margin: 10px 0 10px 30px;" class="button_blue">
                            <%--<input type="button" id="reg"  style="padding: 5px 35px; margin: 10px 0 10px 30px;" class="button_blue" value="激活"/>--%>
                        </div>

                    </li><div class="cl"></div>
                </ul>
                </form>


            </div>


        </div>
    </div>
</div>
<%--<form action="servlet/register">--%>
    <%--<div><label>CustomerName</label><input type="text" name="CustomerName"/></div>--%>
    <%--<div><label>CustomerTrueName</label><input type="text" name="CustomerTrueName"/></div>--%>
    <%--<div><label>CustomerSex</label><input type="text" name="CustomerSex"/></div>--%>
    <%--<div><label>CustomerTel</label><input type="text" name="CustomerTel"/></div>--%>
    <%--<div><label>CustomerTel</label><input type="text" name="CustomerTel"/></div>--%>
    <%--<div><label>CustomerAddr</label><input type="text" name="CustomerAddr"/></div>--%>
    <%--<div><label>CustomerPwd</label><input type="password" name="CustomerPwd"/></div>--%>
    <%--<input type="submit" value="注册">--%>
<%--</form>--%>

<%--<form action="servlet/login" id="login_form" class="loginForm">--%>
    <%--<div><label>CustomerName</label><input type="text" name="CustomerName"/></div>--%>
    <%--<div><label>CustomerPwd</label><input type="password" name="CustomerPwd"/></div>--%>
    <%--<input type="submit" value="登录">--%>
<%--</form>--%>

</body>
</html>
