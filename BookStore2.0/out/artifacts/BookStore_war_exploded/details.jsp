

<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="book.entity.Book" %>
<%@ page import="book.dao.BookDAO" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'details.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script type="text/javascript" src="js/input.js"></script>
    <style type="text/css">
        div {
            float: left;
            margin-left: 30px;
            margin-right: 30px;
            margin-top: 5px;
            margin-bottom: 5px;
        }

        div dd {
            margin: 0px;
            font-size: 10pt;
        }

        div dd.dd_name {
            color: blue;
        }

        div dd.dd_author {
            color: #000;
        }

        div dd.dd_price {
            color: #000;
        }
    </style>
</head>

<body>
<h1>商品详情</h1>
<hr>
<form action="DBServlet" method="post">

    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0" style="margin:0 auto">
        <tr>
            <!-- 商品详情 -->
            <%
                BookDAO bookDAO = new BookDAO();
                Book book = bookDAO.getItemsById(Integer.parseInt(request.getParameter("id")));
                session.setAttribute("book",book);
                if (book != null) {
            %>
            <td width="70%" valign="top">
                <table>
                    <tr>
                        <td><img src="<%=book.getPicture()%>" width="200" height="160"/></td>
                    </tr>
                    <tr>
                        <td><B><%=book.getName() %></B></td>
                    </tr>
                    <tr>
                        <td>作者：<%=book.getAuthor()%></td>
                    </tr>
                    <tr>
                        <td>价格：￥<%=book.getPrice() %></td>
                    </tr>
                    <tr>
                        <td>出版社：￥<%=book.getPress() %></td>
                    </tr>
                    <tr>
                        <td>销量：￥<%=book.getDealAmount() %></td>
                    </tr>

                    <tr>
                        <td>书籍版本：￥<%=book.getVersion() %></td>
                    </tr>
                    <tr>
                        <td>书籍简介：<%=book.getOutline() %></td>
                    </tr>
                    <tr>
                        <td>ISBN：<%=book.getIsbn() %></td>
                    </tr>


                </table>
                <%--数量选择框--%>
                <form>
                    <input class="inputclass" id="input2" type=button value="-">
                    <input class="inputclass" id="input0" type=text name=amount value="1">
                    <input class="inputclass" id="input1" type=button value="+">
                </form>
                <%--加入购物车按钮--%>
                <div class="row col-md-4 col-md-offset-5">
                    <button type="submit" class="btn btn-large btn-primary" id="insert_submit" name="par" value="addShoppingCart">加入购物车</button>
                </div>
            </td>

            <%
                }
            %>
            <%
                String list = "";
                //从客户端获得Cookies集合
                Cookie[] cookies = request.getCookies();
                //遍历这个Cookies集合
                if (cookies != null && cookies.length > 0) {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("ListViewCookie")) {
                            list = c.getValue();
                        }
                    }
                }

                list += request.getParameter("id") + "#";
                //如果浏览记录超过1000条，清零.
                String[] arr = list.split("#");
                if (arr != null && arr.length > 0) {
                    if (arr.length >= 1000) {
                        list = "";
                    }
                }
                Cookie cookie = new Cookie("ListViewCookie", list);
                response.addCookie(cookie);

            %>
            <!-- 浏览过的商品 -->
            <td width="30%" bgcolor="#EEE" align="center">
                <br>
                <b>您浏览过的商品</b><br>
                <!-- 循环开始 -->
                <%
                    ArrayList<Book> bookList = bookDAO.getViewList(list);
                    if (bookList != null && bookList.size() > 0) {
                        System.out.println("itemlist.size=" + bookList.size());
                        for (Book i : bookList) {

                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?id=<%=i.getId()%>"><img src="<%=i.getPicture() %>" width="120"
                                                                         height="90" border="1"/></a>
                        </dt>
                        <dd class="dd_name"><%=i.getName() %>
                        </dd>
                        <dd class="dd_author">姓名:<%=i.getAuthor() %>
                        </dd>
                        <dd class="dd_price">价格:￥<%=i.getPrice() %>
                        </dd>
                    </dl>
                </div>
                <%
                        }
                    }
                %>
                <!-- 循环结束 -->
            </td>
        </tr>
    </table>
</form>
</body>
</html>