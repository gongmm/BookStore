package com.product.login;

import com.product.register.dao.RegisterDao;
import com.product.register.service.RegisterService;
import domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CustomerLogin")
public class CustomerLogin extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private RegisterService service;

    /**
     * Constructor of the object.
     */
    public CustomerLogin() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getContextPath();


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("CustomerName");
        String pswd = request.getParameter("CustomerPwd");

        List<Object> params = new ArrayList<Object>();
        params.add(username);
        params.add(pswd);
//        Cookie[] cookies=request.getCookies();
//
//        if(cookies!=null){
//            String name=null,pwd=null;
//            for(int i=0;i<cookies.length;i++) {
//                if(cookies[i].getName().equals("CustomerName")){
//                    name=cookies[i].getValue();
//                }
//                if(cookies[i].getName().equals("CustomerPwd")){
//                    pwd=cookies[i].getValue();
//                }
//            }
//            if(username.equals(name)&&pswd.equals(pwd)){
//                response.sendRedirect(path + "/index.jsp");
//                return;
//            }
//        }
        Customer c = service.checkCustomer(params);
    if(c!=null){
        Cookie cookie=new Cookie("CustomerName",request.getParameter("CustomerName"));
        cookie.setPath("/");//保证cookie存放的根目录相同
        //设置cookie存活时间为1天
        //cookie.setMaxAge(60*60*24);
        cookie.setMaxAge(60*60);
        //将cookie保存在客户端
        response.addCookie(cookie);

        Cookie cookie2=new Cookie("CustomerPwd",request.getParameter("CustomerPwd"));
        cookie2.setPath("/");
        cookie2.setMaxAge(60*60);
        response.addCookie(cookie2);

        HttpSession session = request.getSession();
        session.setAttribute("user",c);
        response.sendRedirect(path + "/index.jsp");
    }
    else{
        response.sendRedirect(path + "/login.jsp");
    }
    }
    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
        service = new RegisterDao();
    }

}
