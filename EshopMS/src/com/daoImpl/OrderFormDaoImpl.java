package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.dao.OrderFormDao;
import com.util.DBConnection;

/**
 * 订单信息的实现类
 * @version 1.0.0
 */
public class OrderFormDaoImpl implements OrderFormDao{

	Connection conn;
	PreparedStatement sta;
	ResultSet res;
	
	public ArrayList getAllInfo() {

		ArrayList list=new ArrayList();
		
		conn=new DBConnection().getConnection();
		
		String sql="select orderFormID,users.userID,userName,address,postcode,phone,isPayoff,isConsignmenet," +
				"totalPrice from users,orderForm where users.userID=orderForm.userID";
		
		try {
			sta=conn.prepareStatement(sql);
			
			res=sta.executeQuery();
			
			while(res.next()){
				
				Vector v=new Vector();
				v.add(String.valueOf(res.getInt("orderFormID")));
				v.add(res.getString("userName"));
				v.add(res.getString("address"));
				v.add(res.getString("phone"));
				
				if(res.getString("isConsignmenet").equals("0")){
					v.add("未发货");
				}else if(res.getString("isConsignmenet").equals("1")){
					v.add("已发货");
				}
				
				if(res.getString("isPayoff").equals("0")){
					v.add("未付款");
				}else if(res.getString("isPayoff").equals("1")){
					v.add("已付款");
				}
				
				v.add(res.getString("postcode"));
				v.add(res.getFloat("totalPrice"));
				
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return list;
	}

	/**
	 * 通过订单编号获取订单信息
	 */
	public Vector getOrderFormInfoById(String id) {
		Vector v=new Vector();
		conn=new DBConnection().getConnection();
		
		String sql="select orderFormID,userName,address,postcode,phone,isPayoff,isConsignmenet," +
				"totalPrice from users,orderForm where users.userID=orderForm.userID and orderFormID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			res=sta.executeQuery();
			
			while(res.next()){
				v.add(String.valueOf(res.getInt("orderFormID")));
				v.add(res.getString("userName"));
				v.add(res.getString("address"));
				v.add(res.getString("phone"));
				
				if(res.getString("isConsignmenet").equals("0")){
					v.add("未发货");
				}else if(res.getString("isConsignmenet").equals("1")){
					v.add("已发货");
				}
				
				if(res.getString("isPayoff").equals("0")){
					v.add("未付款");
				}else if(res.getString("isPayoff").equals("1")){
					v.add("已付款");
				}
				
				v.add(res.getString("postcode"));
				v.add(res.getFloat("totalPrice"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return v;
	}
/**
 * 删除订单信息
 */
	public boolean deleteOrderFormOnfo(String id) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
	
		String sql="delete from orderForm where orderFormID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			int i = sta.executeUpdate();
			
			if(i>0){
				flag=true;
			}else{
				flag=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return flag;
	}

	/**
	 * 发送商品
	 */
	public boolean deliverGoods(String id) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="update orderForm set isConsignmenet='1' where orderFormID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			int i=sta.executeUpdate();
			
			if(i>0){
				flag=true;
			}else{
				flag=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return flag;
	}

}
