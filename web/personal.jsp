
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    boolean flag=false;
    if(cookies!=null){
        // System.out.println("cookie的长度为："+cookies.length);
        for(int i=0;i<cookies.length;i++) {
            if(cookies[i].getName().equals("CustomerName")){
                //如果cookie与保存的相等，即找到cookie
                flag=true;break;
                //response.sendRedirect("bootstrap.jsp");
            }
        }
    }
    if(flag==false){response.sendRedirect("login.jsp");}//如果没找到cookie，就返回登陆界面
%>
<h1>my page</h1>

</body>
</html>
