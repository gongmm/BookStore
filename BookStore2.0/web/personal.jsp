
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.product.DB.DBdo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.math.BigDecimal" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>个人中心</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/INDEX.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    boolean flag=false;
    Cookie cookie=null;
    Cookie pwd=null;
    if(cookies!=null){
        // System.out.println("cookie的长度为："+cookies.length);
        for(int i=0;i<cookies.length;i++) {
            cookie = cookies[i];
            if(cookie.getName().equals("CustomerName")){
                //如果cookie与保存的相等，即找到cookie
                flag=true;
                break;
                //response.sendRedirect("bootstrap.jsp");
            }
        }
    }

    if(flag==false){response.sendRedirect("login.jsp");}//如果没找到cookie，就返回登陆界面

    for(int i=0;i<cookies.length;i++) {
        pwd=cookies[i];
        if(pwd.getName().equals("CustomerPwd")){
            break;
        }
    }
    List<Object> params = new ArrayList<Object>();
    params.add("CustomerName");
    params.add("CustomerPwd");
    DBdo query_do = new DBdo();
    List<Object> params2 = new ArrayList<Object>();
    params2.add(cookie.getValue());
    params2.add(pwd.getValue());
    Map<String, Object> map=query_do.queryOne("Customer",params, params2);
    String realname=null,sex=null,email=null,add=null;
    int tel=0;
    double balance=0.0;
    for(String key : map.keySet()) {
        if(key.equals("CustomerTrueName")){
            realname=(String)map.get(key);
        }
        if(key.equals("CustomerSex")) {
            if (map.get(key).equals("f")) {
                sex="女";
            } else {
                sex="男";
            }
        }
        if(key.equals("CustomerEmail")){
            email=(String)map.get(key);
        }
        if(key.equals("CustomerAddr")){
           add=(String)map.get(key);
        }
        if(key.equals("CustomerTel")){
            Integer tel1=(Integer)map.get(key);
            tel=tel1;
        }
        if(key.equals("CustomerBalance")){
            BigDecimal d=(BigDecimal)map.get(key);
            balance=d.doubleValue();
        }

    }
%>
<div class="container">
    <header>

        <nav class="secondary_header" id="menu">
            <ul>
                <li><a href="<%=basePath%>index.jsp">首页</a></li>
                <li><a href="">所有书籍</a></li>
                <li><a href="<%=basePath%>personal.jsp">个人中心</a></li>
                <li><a href="">历史订单</a></li>
                <li><a href="">售后服务</a></li>
                <li><a href="<%=basePath%>cart.jsp"></a>购物车</li>
            </ul>
        </nav>
    </header>
    <br>

    <section>

        <article class="left_article">
            <h3> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的资料 </h3>
            <p>用户名：<%=cookie.getValue()%></p>
            <p>真实姓名：<%=realname%></p>
            <p>性别：<%=sex%></p>
            <p>认证邮箱：
                <%=email%>
            </p>
            <p>绑定手机：
                <%=tel%>
            </p>
            <p>地址：
                <%=add%>
            </p>
        </article>
        <article class="right_article">
            <h3> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的财产 </h3>
            <p>余额：
                <%=balance%>
            </p>
            <p>绑定银行卡：</p>
            <p>添加银行卡：</p>

            <p>&nbsp;&nbsp;&nbsp;&nbsp;账户:<input  type="text" name="username"  value="请输入卡号" placeholder="请输入卡号"/>  </p>

            <p>&nbsp;&nbsp;&nbsp;&nbsp;密码:<input  type="password" name="password" placeholder="请输入密码" /> </p>
            <div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="button" >添加</button>

            </div>
            <div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button class="button">提现</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button class="button">充值</button>
            </div>
        </article>

    </section>
    <div class="row">
        <div class="copyright">&copy;2018 - <strong>BookStore</strong></div>
    </div>
</div>
</body>
</html>
