<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Book"%>
<%@ page import="dao.BookDAO" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	   div{
	      float:left;
	      margin: 10px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_author
	   {
	      color:#000;
	   }
       div dd.dd_price
       {
           color:#000;
       }
	</style>
  </head>
  
  <body>

    <h1>全部书籍</h1>
    <hr>

    <form action="DBServlet" method="post">
        <input type="text" name="bookName" class="input_control" />
        <button id= "query_button" class="btn" name="par" value="query" >查询</button>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0" >
      <tr>
        <td>
          
          <!-- 商品循环开始 -->
           <%
               response.setContentType("text/html;charset=utf-8");

               BookDAO bookDAO = new BookDAO();
               ArrayList<Book> list = bookDAO.getAllItems();
//               ArrayList<Book> list = (ArrayList)request.getAttribute("BookList");
               if((ArrayList) request.getAttribute("result")!= null){
                   list = (ArrayList) request.getAttribute("result");
               }

               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  Book book = list.get(i);
           %>   
          <div>
             <dl>
               <dt>
                 <a href="details.jsp?id=<%=book.getId()%>"><img src="<%=book.getPicture()%>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=book.getName() %></dd>
                 <dd class="dd_author">作者:<%=book.getAuthor() %></dd>
                 <dd class="dd_price">价格:￥ <%=book.getPrice() %></dd>
             </dl>
          </div>
          <!-- 商品循环结束 -->
        
          <%
                   }
              } 
          %>
        </td>
      </tr>
    </table>
    </form>
  </body>
</html>
