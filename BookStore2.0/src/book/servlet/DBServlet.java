package book.servlet;

import book.dao.BookDAO;
import book.entity.Book;
import book.entity.OrderItem;
import com.product.DB.DBdo;
import domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String path = request.getContextPath();
        String parm = request.getParameter("par");
        System.out.println(parm);

        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> list = bookDAO.getAllItems();
        request.setAttribute("BookList",list);
        //查询书籍
        if(parm.equals("query")){
            String bookName = request.getParameter("BookName");
            ArrayList queryBookByName = new ArrayList();
            if (list!=null&&list.size()>0){
                for(int i = 0;i<list.size();i++){
                    if(list.get(i).getName().equals(bookName)){
                        queryBookByName.add(list.get(i));
                    }
                }
            }
            request.setAttribute("result",queryBookByName);
            request.getRequestDispatcher("allbook.jsp").forward(request, response);

        }

        if(parm.equals("settleAccount")){
            String[] chooseItems = request.getParameterValues("choose");

            if(chooseItems!=null){
                for(int i = 0;i<chooseItems.length;i++){
                    int quantity = 0;
                    int bookID = 0;
                    System.out.println(chooseItems[i]);
                    DBdo dBdo = new DBdo();
                    Map<String,Object> map = new HashMap<>();
                    ArrayList<Object> p=new ArrayList<>();
                    ArrayList<Object> p2=new ArrayList<>();
                    p.add("OrderID");
                    p2.add(chooseItems[i]);
                    map = dBdo.queryOne("OrderItem", p, p2);
                    for(String key:map.keySet()){
                        if(key.equals("PostStatus")){
                            map.put(key,"paid");
                            //通过map中的值更新数据库内容
                        }
                        if(key.equals("Quantity")){
                            quantity = (int) map.get(key);
                        }
                        if(key.equals("BookId")){
                            bookID = (int) map.get(key);
                        }
                    }
                    Book book = bookDAO.getItemsById(bookID);
                    int amount = book.getStoreAmount() - quantity;
                    book.setStoreAmount(amount);
                    amount = book.getDealAmount() + quantity;
                    book.setDealAmount(amount);
                    bookDAO.update(book);


                }
            }
            response.sendRedirect("index.jsp");

        }

        if(parm.equals("addShoppingCart")){
            boolean flag=false;
            Cookie[] cookies=request.getCookies();
            if(cookies!=null){
                for(int i=0;i<cookies.length;i++) {
                    Cookie cookie=cookies[i];
                    String name=cookies[i].getName();
                    if(cookies[i].getName().equals("CustomerName")){
                        //如果cookie与保存的相等，即找到cookie


                       flag=true;
                       break;
                    }
                }
            }
            if(flag==false){
                response.sendRedirect("login.jsp");
                return;
            }

            Customer c=(Customer) request.getSession().getAttribute("user");
            String value = request.getParameter("amount");
            Book book = (Book) request.getSession().getAttribute("book");
            OrderItem orderItem = new OrderItem();
            orderItem.setBookID(book.getId());
            orderItem.setQuantity(Integer.parseInt(value));
            orderItem.setCustomerID(c.getCustomerId());
            if(bookDAO.insertValue(orderItem)){
                response.sendRedirect("index.jsp");
                //request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
