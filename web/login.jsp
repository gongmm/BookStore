
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        div{
            width: 100%;
        }
    </style>
</head>
<body>
<form action="servlet/register">
    <div><label>CustomerName</label><input type="text" name="CustomerName"/></div>
    <div><label>CustomerTrueName</label><input type="text" name="CustomerTrueName"/></div>
    <div><label>CustomerSex</label><input type="text" name="CustomerSex"/></div>
    <div><label>CustomerTel</label><input type="text" name="CustomerTel"/></div>
    <div><label>CustomerTel</label><input type="text" name="CustomerTel"/></div>
    <div><label>CustomerAddr</label><input type="text" name="CustomerAddr"/></div>
    <div><label>CustomerPwd</label><input type="password" name="CustomerPwd"/></div>
    <input type="submit" value="注册">
</form>

<form action="servlet/login">
    <div><label>CustomerName</label><input type="text" name="CustomerName"/></div>
    <div><label>CustomerPwd</label><input type="password" name="CustomerPwd"/></div>
    <input type="submit" value="登录">
</form>
</body>
</html>
