package com.product.login;

import com.product.register.dao.RegisterDao;
import com.product.register.service.RegisterService;
import domain.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;




@WebServlet(name = "AdminLogin")
public class AdminLogin extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private RegisterService service;

    /**
     * Constructor of the object.
     */
    public AdminLogin() {
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
        String username = request.getParameter("AdminName");
        String pswd = request.getParameter("AdminPwd");
        Cookie[] cookies=request.getCookies();

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
            if(username.equals(name)&&pswd.equals(pwd)){
                response.sendRedirect(path + "/admin.jsp");
                return;
            }
        }
        List<Object> params = new ArrayList<Object>();
        params.add(username);
        params.add(pswd);
        Admin a = service.checkAdmin(params);
        if(a!=null){
            Cookie cookie=new Cookie("AdminName",username);
            cookie.setPath("/");//保证cookie存放的根目录相同
            //设置cookie存活时间为1天
            //cookie.setMaxAge(60*60*24);
            cookie.setMaxAge(60*60);
            //将cookie保存在客户端
            response.addCookie(cookie);

            Cookie cookie2=new Cookie("AdminPwd",pswd);
            cookie2.setPath("/");
            cookie2.setMaxAge(60*60);
            response.addCookie(cookie2);

            HttpSession session = request.getSession();
            session.setAttribute("admin",a);
            response.sendRedirect(path + "/admin.jsp");
        }
        else{
            response.sendRedirect(path + "/admin-login.jsp");
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
