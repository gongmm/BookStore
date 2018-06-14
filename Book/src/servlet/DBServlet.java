package servlet;

import dao.BookDAO;
import entity.Book;
import entity.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String parm = request.getParameter("par");
        System.out.println(parm);
        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> list = bookDAO.getAllItems();
        request.setAttribute("BookList",list);
        if(parm.equals("query")){
            String bookName = request.getParameter("bookName");
            ArrayList queryBookByName = new ArrayList();
            if (list!=null&&list.size()>0){
                for(int i = 0;i<list.size();i++){
                    if(list.get(i).getName().equals(bookName)){
                        queryBookByName.add(list.get(i));
                    }
                }
            }
            request.setAttribute("result",queryBookByName);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        if(parm.equals("addShoppingCart")){
            String value = request.getParameter("amount");
            Book book = (Book) request.getSession().getAttribute("book");
            OrderItem orderItem = new OrderItem();
            orderItem.setBookID(book.getId());
            orderItem.setQuantity(Integer.parseInt(value));

            bookDAO.insertValue(orderItem);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
