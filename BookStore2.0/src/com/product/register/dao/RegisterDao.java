package com.product.register.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import domain.Admin;
import domain.Customer;

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
    public Customer checkCustomer(List<Object> params){
       Customer customer=new Customer();
       Map<String,Object> map=new HashMap<String,Object>();
        jdbcUtils.getConnection();
        String sql="select * from Customer where CustomerName=? and CustomerPwd=?";
        try{
            map=jdbcUtils.findSimpleResult(sql,params);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            jdbcUtils.releaseConn();
        }
        if(map.size()<1){
            return null;
        }else {
            for (String key : map.keySet()) {
                if (key.equals("CustomerId")) customer.setCustomerId((Integer) map.get(key));
                if (key.equals("CustomerName")) customer.setCustomerName((String) map.get(key));
                if (key.equals("CustomerTrueName")) customer.setCustomerTrueName((String) map.get(key));
                if (key.equals("CustomerEmail")) customer.setCustomerEmail((String) map.get(key));
                if (key.equals("CustomerAddr")) customer.setCustomerAddr((String) map.get(key));
                if (key.equals("CustomerSex")) customer.setCustomerSex((String) map.get(key));
                if (key.equals("CustomerTel")) customer.setCustomerTel((Integer) map.get(key));
            }

            return customer;
        }
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
    public Admin checkAdmin(List<Object> params){
        Admin admin=new Admin();
        jdbcUtils.getConnection();
        Map<String,Object> map=new HashMap<String,Object>();
        String sql="select * from Admin where AdminName=? and AdminPwd=?";
        try{
            map= jdbcUtils.findSimpleResult(sql,params);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            jdbcUtils.releaseConn();
        }
        if(map.size()<1){
            return null;
        }else {
            for (String key : map.keySet()) {
                if (key.equals("AdminId")) admin.setAdminId((Integer) map.get(key));
                if (key.equals("AdminName")) admin.setAdminName((String) map.get(key));
                if (key.equals("AdminPwd")) admin.setAdminPwd((String) map.get(key));
                if (key.equals("AdminFlag")) admin.setAdminFlag((Integer) map.get(key));
            }
            return admin;
        }
    }

}