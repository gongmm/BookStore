package com.product.register.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.product.jdbc.dbutil.JdbcUtils;
import com.product.register.service.RegisterService;

public class RegisterDao implements RegisterService {
    private JdbcUtils jdbcUtils = null;
    public RegisterDao() {
        // TODO Auto-generated constructor stub
        jdbcUtils = new JdbcUtils();
    }

    /* 完成用户对注册的Dao的编写
     * @see com.product.register.service.RegisterService#registerUser(java.util.List)
     */
    @Override
    public boolean registerCustomer(List<Object> params) {
        // TODO Auto-generated method stub
        boolean flag = false;
        jdbcUtils.getConnection();
        String sql = "insert into Customer(CustomerName, CustomerTrueName, CustomerSex, CustomerTel, CustomerEmail, CustomerAddr, CustomerPwd) values (?, ?, ?, ?, ?, ?, ?)";
        try{
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            jdbcUtils.releaseConn();
        }

        return flag;
    }
    public boolean checkCustomer(List<Object> params){
        boolean flag = false;
        jdbcUtils.getConnection();
        String sql="select * from Customer where CustomerName=? and CustomerPwd=?";
        try{
            flag = jdbcUtils.checkExist(sql,params);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            jdbcUtils.releaseConn();
        }

        return flag;
    }
    public boolean registerAdmin(List<Object> params){
        boolean flag = false;
        jdbcUtils.getConnection();
        String sql = "insert into Admin(AdminName,AdminPwd) values (?, ?)";
        try{
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            jdbcUtils.releaseConn();
        }

        return flag;
    }
    public boolean checkAdmin(List<Object> params){
        boolean flag = false;
        jdbcUtils.getConnection();
        String sql="select * from Admin where AdminName=? and AdminPwd=?";
        try{
            flag = jdbcUtils.checkExist(sql,params);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            jdbcUtils.releaseConn();
        }

        return flag;
    }

}