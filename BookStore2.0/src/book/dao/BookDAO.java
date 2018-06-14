package book.dao;

import book.entity.Book;
import book.entity.OrderItem;
import book.util.DBHelper;
import domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class BookDAO {
    //获得所有的商品信息
    public ArrayList<Book> getAllItems(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Book> list = new ArrayList<Book>();

        try{
            //获得连接对象
            conn = DBHelper.getConnection();
            //sql语句获得商品信息
            String sql = "select * from Book";
            //创建连接对象
            stmt = conn.prepareStatement(sql);
            //获得数据集
            rs = stmt.executeQuery();
            while(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("BookId"));
                book.setTypeID(rs.getInt("BookTypeID"));
                book.setName(rs.getString("BookName"));
                book.setPress(rs.getString("BookPress"));
                book.setVersion(rs.getString("BookVersion"));
                book.setAuthor(rs.getString("BookAuthor"));
                book.setIsbn(rs.getString("Bookisbn"));
                book.setPicture(rs.getString("BookPic"));
                book.setDealAmount(rs.getInt("BookDealmount"));
                book.setStoreAmount(rs.getInt("BookStoremount"));
                book.setOutline(rs.getString("BookOutline"));
                book.setPrice(rs.getBigDecimal("BookPrice"));

                list.add(book);
            }
            return list;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            //释放数据集对象

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            //释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }

    }

    //根据商品编号获得商品资料
    public Book getItemsById(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            //获得连接对象
            conn = DBHelper.getConnection();
            //sql语句获得商品信息
            String sql = "select * from Book where BookId=?";
            //创建连接对象
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            //获得数据集
            rs = stmt.executeQuery();
            if(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("bookID"));
                book.setTypeID(rs.getInt("bookTypeID"));
                book.setName(rs.getString("bookName"));
                book.setPress(rs.getString("bookPress"));
                book.setVersion(rs.getString("bookVersion"));
                book.setAuthor(rs.getString("bookAuthor"));
                book.setIsbn(rs.getString("bookIsbn"));
                book.setPicture(rs.getString("bookPic"));
                book.setDealAmount(rs.getInt("bookDealmount"));
                book.setStoreAmount(rs.getInt("bookStoremount"));
                book.setOutline(rs.getString("bookOutline"));
                book.setPrice(rs.getBigDecimal("bookPrice"));
                return book;
            }
            else {
                return null;
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            //释放数据集对象

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            //释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    //获取最近浏览的五条商品信息
    public ArrayList<Book> getViewList(String list){
        ArrayList<Book> itemsList = new ArrayList<>();
        int COUNT = 5;//每次返回前五条元素
        if(list!=null&&list.length()>0){
            String[] arr = list.split("#");
            if(arr.length>=5){
                for(int i =arr.length-1;i>arr.length-COUNT-1;i--){
                    //转换为数字
                    int id = Integer.parseInt(arr[i]);
                    itemsList.add(getItemsById(id));
                }
            }
            else {
                for(int i =arr.length-1;i>=0;i--){
                    //转换为数字
                    int id = Integer.parseInt(arr[i]);
                    itemsList.add(getItemsById(id));
                }
            }

            return itemsList;
        }
        else {
            return null;
        }
    }

    //向OrderItem表中插入数据
    public Boolean insertValue2(Book book, Customer c){
        Boolean flag=false;
        Date date = new Date();
        java.sql.Date currentTime = new java.sql.Date(date.getTime());
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "insert into OrderItem(CustomerId, Orderdate, BookId, Quantity) values (?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
 //           System.out.println(book.getId());
//            pst.setInt(1,201);
            pst.setInt(1,c.getCustomerId());
            pst.setDate(2,currentTime);
            pst.setInt(3,book.getId());
            pst.setInt(4,1);
//            pst.setString(6,"unpaid");
//            System.out.println(sql);

            //获得数据集
            flag=pst.executeUpdate()>0;
    //        System.out.println("向购物车表"+"中插入数据成功");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }



    public Boolean insertValue(OrderItem orderItem){
        Boolean flag=false;
        Date date = new Date();
        java.sql.Date currentTime = new java.sql.Date(date.getTime());
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "insert into OrderItem(CustomerId, Orderdate, BookId, Quantity) values (?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            //           System.out.println(book.getId());
//            pst.setInt(1,201);
            pst.setInt(1,orderItem.getCustomerID());
            pst.setDate(2,currentTime);
            pst.setInt(3,orderItem.getBookID());
            pst.setInt(4,orderItem.getQuantity());

//            System.out.println(sql);

            //获得数据集
            flag=pst.executeUpdate()>0;
            System.out.println("向购物车表"+"中插入数据成功");
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return flag;
    }

    //更新Book表中的数据
    public void update (Object obj){
        Connection conn = null;

        PreparedStatement pst = null;

        try {
            Book book = (Book)obj;
            conn = DBHelper.getConnection();
            String sql = "UPDATE book SET BookDealmount = ? , BookStoremount = ? WHERE BookId = ?";
            pst = conn.prepareStatement(sql);

            pst.setInt(1,book.getDealAmount());
            pst.setInt(2,book.getStoreAmount());
            pst.setInt(3,book.getId());


            //获得数据集
            pst.executeUpdate();
            System.out.println("表book"+"中更新数据成功");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}
