package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Admin;
import com.dao.AdminDao;
import com.util.DBConnection;
/**
 * 管理员信息的实现类
 * @version 1.0.0
 */
public class AdminDaoImpl implements AdminDao{

	Connection conn;
	PreparedStatement sta;
	ResultSet res;
	
	/**
	 * 管理员登录验证
	 */
	public boolean checkLogin(String id,String pwd) {
		boolean flag=false;
		conn=new DBConnection().getConnection();
		String sql="select * from admin where adminID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			res=sta.executeQuery();
			if(res.next()){
				String userID=String.valueOf(res.getInt("adminID"));
				String userPwd=res.getString("password");
				if(id.equals(userID)&&pwd.equals(userPwd)){
					flag=true;
				}else{
					flag=false;
				}
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
	 * 管理员修改密码
	 */
	public boolean changePassword(Admin a) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="update admin set password=? where adminID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setString(1, a.getPassword());
			sta.setInt(2, Integer.parseInt(a.getAdminID()));
			
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
	 * 通过管理员号获取管理员个人信息
	 */
	public Admin getManagerInfo(String id) {
		Admin a=new Admin();
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from admin where adminID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			res=sta.executeQuery();
			
			if(res.next()){
				a.setAdminID(String.valueOf(res.getInt("adminID")));
				a.setName(res.getString("name"));
				a.setPassword(res.getString("password"));
			}else{
				a=null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return a;
	}


}
