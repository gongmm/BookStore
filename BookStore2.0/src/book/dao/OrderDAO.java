//package book.dao;
//
//import book.entity.OrderItem;
//import book.util.DBHelper;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//public class OrderDAO {
//    //获得所有的商品信息
//    public ArrayList<OrderItem> getAllItems(){
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        ArrayList<OrderItem> list = new ArrayList<OrderItem>();
//
//        try{
//            //获得连接对象
//            conn = DBHelper.getConnection();
//            //sql语句获得商品信息
//            String sql = "select * from orderitem";
//            //创建连接对象
//            stmt = conn.prepareStatement(sql);
//            //获得数据集
//            rs = stmt.executeQuery();
//            while(rs.next()){
//                OrderItem orderItem = new OrderItem();
//                orderItem.setBookID(rs.getInt("BookId"));
//                orderItem.setCustomerID(rs.getInt("customerID"));
//                orderItem.setQuantity(rs.getInt("quantity"));
//                book.setPress(rs.getString("BookPress"));
//                book.setVersion(rs.getString("BookVersion"));
//                book.setAuthor(rs.getString("BookAuthor"));
//                book.setIsbn(rs.getString("Bookisbn"));
//                book.setPicture(rs.getString("BookPic"));
//                book.setDealAmount(rs.getInt("BookDealmount"));
//                book.setStoreAmount(rs.getInt("BookStoremount"));
//                book.setOutline(rs.getString("BookOutline"));
//                book.setPrice(rs.getBigDecimal("BookPrice"));
//
//                list.add(book);
//            }
//            return list;
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//            return null;
//        }
//        finally {
//            //释放数据集对象
//
//            if (rs != null) {
//                try {
//                    rs.close();
//                    rs = null;
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//            //释放语句对象
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                    stmt = null;
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//
//        }
//
//    }
//}
