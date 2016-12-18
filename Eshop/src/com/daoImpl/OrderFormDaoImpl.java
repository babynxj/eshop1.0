package com.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.bean.OrderForm;
import com.bean.OrderList;
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
	/**
	 * 生成订单
	 */
	public boolean orderForm(OrderForm o) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="insert into orderForm values(?,?,?,?,?,?,?,?)";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(o.getOrderFormID()));
			sta.setInt(2, Integer.parseInt(o.getUserID()));
			sta.setInt(3, Integer.parseInt(o.getGoodsID()));
			sta.setDate(4, Date.valueOf(o.getSubmitTime()));
			sta.setDate(5, Date.valueOf(o.getConsignmentTime()));
			sta.setFloat(6, Float.parseFloat(o.getTotalPrice()));
			sta.setString(7, o.getIsPayoff());
			sta.setString(8, o.getIsConsignmenet());
			
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

	/**
	 * 订单类别
	 */
	public boolean orderList(OrderList o) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="insert into orderList values(?,?,?,?)";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(o.getOrderListID()));
			sta.setInt(2, Integer.parseInt(o.getOrderFormID()));
			sta.setInt(3, Integer.parseInt(o.getGoodsID()));
			sta.setInt(4, Integer.parseInt(o.getAmount()));
			
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

	/**
	 * 获取订单表里的记录总数
	 */
	public int getCount() {
		int count=0;
		
		conn=new DBConnection().getConnection();
		
		String sql="select count(*) from orderForm";
		
		try {
			sta=conn.prepareStatement(sql);
			
			res=sta.executeQuery();
			
			while(res.next()){
				count=res.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return count;
	}

	/**
	 * 获取订单列表里的记录总数
	 */
	public int getOrderListCount() {
		int count=0;
		
		conn=new DBConnection().getConnection();
		
		String sql="select count(*) from orderList";
		
		try {
			sta=conn.prepareStatement(sql);
			
			res=sta.executeQuery();
			
			while(res.next()){
				count=res.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return count;
	}

	/**
	 * 获取用户的购物车信息
	 */
	public ArrayList getShoppingCarInfo(String id) {
		ArrayList list=new ArrayList();
		
		conn=new DBConnection().getConnection();
		//四张表的查询，通过外键来索引
		String sql="select orderForm.orderFormID,goodsName,goodsPrice,amount,totalPrice from users,goods,orderList,orderForm " +
				"where users.userID=orderForm.userID and goods.goodsID=orderForm.goodsID and orderForm.orderFormID=orderList.orderFormID " +
				"and users.userID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			res=sta.executeQuery();
			
			while(res.next()){
				Vector v=new Vector();
				v.add(res.getInt("orderFormID"));
				v.add(res.getString("goodsName"));
				v.add(res.getFloat("goodsPrice"));
				v.add(res.getInt("amount"));
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
	 * 删除订单信息
	 */
	public boolean deleteOrderFormInfo(String id) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="delete from orderForm where orderFormID=?";
		
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

	/**
	 * 删除订单列表信息
	 */
	public boolean deleteOrderListInfo(String id) {
		
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="delete from orderList where orderFormID=?";
		
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
