package com.product.DB;

import com.product.jdbc.dbutil.JdbcUtils;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DBdo {
    private JdbcUtils test=null;

    public DBdo(){
        this.test= new JdbcUtils();
    }
    public boolean add(String table,List<Object> params,List<Object> params2){
        boolean flag = false;
        test.getConnection();
        String sql="insert into "+table+"(";
        int size=params.size();
        for(int i=0;i<size-1;i++){
            sql+=params.get(i)+", ";
        }
        sql+=params.get(size-1)+") values (";
        for(int i=0;i<size-1;i++){
            sql+="?, ";
        }
        sql+="?)";
        try{
            flag = test.updateByPreparedStatement(sql, params2);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            test.releaseConn();
        }
        return flag;
    }
    public boolean update(String table,List<Object> params,List<Object> params2){
        boolean flag = false;
        test.getConnection();
        String sql="update "+table+" set ";
        int size=params.size();
        for(int i=1;i<size-1;i++){
            sql+=params.get(i)+" = ? , ";
        }
        sql+=params.get(size-1)+" = ? where "+params.get(0)+" = ? ";
        try {
            flag = test.updateByPreparedStatement(sql, params2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            test.releaseConn();
        }

        return flag;
    }
    public boolean delete(String table,List<Object> params,List<Object> params2){
        boolean flag = false;
        test.getConnection();
        String sql = "delete from "+table+" where ";
        int size=params.size();
        if(params.get(0)!=null) {
            sql += params.get(0) + " = ? ";
            for(int i=1;i<size;i++){
                if(params.get(i)!=null) {
                    sql += " and "+params.get(i) + "  = ? ";
                }
            }
        }
        else if(params.get(1)!=null) {
            sql += params.get(1) + " = ? ";
            for(int i=2;i<size;i++){
                if(params.get(i)!=null) {
                    sql += " and "+params.get(i) + "  = ? ";
                }
            }
        }

        try{
            flag = test.updateByPreparedStatement(sql, params2);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            test.releaseConn();
        }
        return flag;
    }
    public List<Map<String, Object>> query(List<Object> params){
        List<Map<String, Object>> rs=new ArrayList<Map<String, Object>>();
        test.getConnection();
        String sql = "select * from "+params.get(0);
        try {
            rs=test.findModeResult(sql,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            test.releaseConn();
        }
        return rs;
    }
    public List<Map<String, Object>> querySubSet(String table,List<Object> params,List<Object> params2){
        List<Map<String, Object>> rs=new ArrayList<Map<String, Object>>();
        test.getConnection();
        String sql = "select * from "+table+" where ";
        int size=params.size();
        if(params.get(0)!=null) {
            sql += params.get(0) + " = ? ";
            for(int i=1;i<size;i++){
                if(params.get(i)!=null) {
                    sql += " and "+params.get(i) + "  = ? ";
                }
            }
        }
        else if(params.get(1)!=null) {
            sql += params.get(1) + " = ? ";
            for(int i=2;i<size;i++){
                if(params.get(i)!=null) {
                    sql += " and "+params.get(i) + "  = ? ";
                }
            }
        }
        try {
            rs=test.findModeResult(sql,params2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            test.releaseConn();
        }
        return rs;
    }

    public Map<String, Object> queryOne(String table,List<Object> params,List<Object> params2){
        Map<String, Object> map=new HashMap<String,Object>();
        test.getConnection();
        String sql ="select * from "+table+" where ";
        int size=params.size();
        if(params.get(0)!=null) {
            sql += params.get(0) + " = ? ";
            for(int i=1;i<size;i++){
                if(params.get(i)!=null) {
                    sql += " and "+params.get(i) + "  = ? ";
                }
            }
        }
        else if(params.get(1)!=null) {
            sql += params.get(1) + " = ? ";
            for(int i=2;i<size;i++){
                if(params.get(i)!=null) {
                    sql += " and "+params.get(i) + "  = ? ";
                }
            }
        }
        try {
            map=test.findSimpleResult(sql,params2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            test.releaseConn();
        }
        return map;
    }


}
