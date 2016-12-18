package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.dao.OrderListDao;
import com.util.DBConnection;
/**
 * 订单列表信息的实现类
 * @version 1.0.0
 */
public class OrderListDaoImpl implements OrderListDao {

	Connection conn;
	PreparedStatement sta;
	ResultSet res;
	
	/**
	 * 获取订单列表信息
	 */
	public ArrayList getOrderList(String id) {
		ArrayList list=new ArrayList();
		
		conn=new DBConnection().getConnection();
		
		String sql="select orderList.goodsID,goodsName,goodsPrice,amount from goods,orderList " +
				"where goods.goodsID=orderList.goodsID and orderFormID=?";
			
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			res=sta.executeQuery();
			
			while(res.next()){
				Vector v=new Vector();
				v.add(res.getInt("goodsID"));
				v.add(res.getString("goodsName"));
				v.add(res.getString("goodsPrice"));
				v.add(res.getString("amount"));
				list.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return list;
	}

}
