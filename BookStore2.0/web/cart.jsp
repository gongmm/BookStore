<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.product.DB.DBdo" %>
<%@ page import="domain.Customer" %>
<%@ page import="book.entity.Book" %>
<%@ page import="book.dao.BookDAO" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>购物车</title>
    <link href="css/INDEX.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/Cart.js"></script>
    <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
    <script>
        $(function(){
            $("#chooseAll").click(function(){//给全选按钮加上点击事件
                var status = $(this).prop("checked");//判断全选按钮的选中状态
                $(".item").prop("checked",status);  //让class名为qx的选项的选中状态和全选按钮的选中状态一致。
            })
        })

    </script>
</head>

<body>
<form action="DBServlet" method="post">

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

    <div id="main">
        <div>&nbsp;&nbsp;<img src="images/shopping_myshopping.gif" alt="shopping"/></div>
        <div class="shopping_list_top">您已选购以下商品</div><br>
        <div class="shopping_list_border">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr class="shopping_list_title">
                    <th><input type="checkbox" id="chooseAll" />全选</th>
                    <th class="shopping_list_title_3">书名</th>
                    <th class="shopping_list_title_3">价格</th>
                    <th class="shopping_list_title_5">数量</th>
                    <th class="shopping_list_title_3">日期</th>
                    <th class="shopping_list_title_3">删除</th>
                </tr>
                <%
                    DBdo query_do = new DBdo();
                    String table="OrderItem";
                    List<Object> params = new ArrayList<Object>();
                    List<Object> params2 = new ArrayList<Object>();
                    params.add("CustomerId");
                    params.add("PostStatus");

                    Customer c=(Customer)session.getAttribute("user");
                    if(c==null){
                        response.sendRedirect("login.jsp");
                        return;
                    }
                    params2.add(c.getCustomerId());
                    params2.add("unpaid");

                    List<Map<String, Object>> rs=query_do.querySubSet(table,params,params2);

                    String bookname=null,date=null;
                    int count=0;
                    double price=0.0;
                    int order=0;
                    double amount=0.0;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    for(Map<String,Object> map:rs){
                %>

                <%--<tr class="shopping_product_list" id="shoppingProduct_01">--%>
                <tr class="shopping_list_title">

                        <%
                            for(String key : map.keySet()){
                                if(key.equals("Quantity")){
                                    count=(Integer)map.get(key);
                                }
                                if(key.equals("BookId")){
                                    BookDAO bookDAO = new BookDAO();
                                    Book book = bookDAO.getItemsById((Integer)map.get(key));
                                    bookname=book.getName();
                                    price=((BigDecimal)book.getPrice()).doubleValue();
                                    amount+=price;
                                }
                                if(key.equals("OrderId")){
                                    order=(Integer)map.get(key);
                                }
                                if(key.equals("Orderdate")){

                                    date=sdf.format((Date)map.get(key));
                                }

                            }
                        %>

                        <input type="hidden" name="order" value="<%=order%>"/>
                    <td><input type="checkbox" class="item" name="choose" value="<%=order%>"/></td>
                    <td><a style="color:#000;" href="#" class="blue"><%=bookname%></a></td>
                    <td>￥<label><%=price%></label></td>
                    <td><%=count%></td>
                        <td><%=date%></td>
                    <td><input type="submit" value="删除"/></td>

                </tr>
                <%
                    }
                %>




            </table>
            <div class="shopping_list_end">
                <div><a href="#" style="color: black">清空购物车</a></div>
                <ul>
                    <button type="submit" name="par" value="settleAccount">结算</button>
                    <li class="shopping_list_end_1"><input name="" type="image" src="images/shopping_balance.gif"/></li>
                    <li class="shopping_list_end_3">商品金额总计：</li>
                </ul>
            </div>
        </div>
    </div>
    <br><br>

    <div class="copyright">&copy;2018 - <strong>BookStore</strong></div>
</div>
</form>
</body>
</html>