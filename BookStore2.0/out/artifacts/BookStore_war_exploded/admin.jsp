<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.Admin" %>
<%@ page import="com.product.register.service.RegisterService" %>
<%@ page import="com.product.register.dao.RegisterDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    boolean flag=false;
    if(cookies!=null){
        String name=null,pwd=null;
        for(int i=0;i<cookies.length;i++) {
            if(cookies[i].getName().equals("AdminName")){
                name=cookies[i].getValue();
            }
            if(cookies[i].getName().equals("AdminPwd")){
                pwd=cookies[i].getValue();

            }
        }
        RegisterService service=new RegisterDao();
        List<Object> params = new ArrayList<Object>();
        params.add(name);
        params.add(pwd);
        Admin a = service.checkAdmin(params);
        if(a!=null){
           flag=true;
        }
    }

    if(flag==false){response.sendRedirect("admin-login.jsp");}//如果没找到cookie，就返回登陆界面
    %>
<p>welcom admin</p>
</body>
</html>
