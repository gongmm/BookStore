package com.product.register.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.hibernate.validator.util.GetConstructor;

import com.product.register.dao.RegisterDao;
import com.product.register.service.RegisterService;



public class CustomerRegister extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private RegisterService service;

    /**
     * Constructor of the object.
     */
    public CustomerRegister() {
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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getContextPath();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String CustomerName = request.getParameter("CustomerName");
        String CustomerTrueName= request.getParameter("CustomerTrueName");
        String CustomerSex= request.getParameter("CustomerSex");
        int CustomerTel= Integer.parseInt(request.getParameter("CustomerTel"));
        String CustomerEmail= request.getParameter("CustomerAddr");
        String CustomerAddr= request.getParameter("CustomerAddr");
        String CustomerPwd=request.getParameter("CustomerPwd");
        List<Object> params = new ArrayList<Object>();
        params.add(CustomerName);
        params.add(CustomerTrueName);
        params.add(CustomerSex);
        params.add(CustomerTel);
        params.add(CustomerEmail);
        params.add(CustomerAddr);
        params.add(CustomerPwd);

        boolean flag = service.registerCustomer(params);

        if(flag){
            out.println("注册成功");
            response.sendRedirect(path + "/login.jsp");
        }else{
            out.println("注册失败");
        }
        out.flush();
        out.close();
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