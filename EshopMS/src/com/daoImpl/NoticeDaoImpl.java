package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Notice;
import com.dao.NoticeDao;
import com.util.DBConnection;

/**
 * 商城公告信息的实现类
 * @version 1.0.0
 */
public class NoticeDaoImpl implements NoticeDao{

	Connection conn;
	PreparedStatement sta;
	ResultSet res;
	
	/**
	 * 获取所有公告信息
	 */
	public ArrayList<Notice> getAllInfo() {
		ArrayList<Notice> list=new ArrayList<Notice>();
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from notice";
		
		try {
			sta=conn.prepareStatement(sql);
			
			res=sta.executeQuery();
			while(res.next()){
				Notice n=new Notice();
				n.setNoticeID(String.valueOf(res.getInt("noticeID")));
				n.setNoticeContent(res.getString("noticeContent"));
				list.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return list;
	}

	/**
	 * 通过公告号获取公告信息
	 */
	public Notice getNoticeInfoById(String id) {
		Notice n=new Notice();
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from notice where noticeID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			res=sta.executeQuery();
			
			if(res.next()){
				n.setNoticeID(String.valueOf(res.getInt("noticeID")));
				n.setNoticeContent(res.getString("noticeContent"));
			}else{
				n=null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			new DBConnection().close();
		}
		return n;
	}

	/**
	 * 修改公告信息
	 */
	public boolean updateNoticeInfo(Notice n) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="update notice set noticeContent=? where noticeID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setString(1, n.getNoticeContent());
			sta.setInt(2, Integer.parseInt(n.getNoticeID()));
			
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
	 * 删除公告信息
	 */
	public boolean deleteNoticeInfo(String id) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="delete from notice where noticeID=?";
		
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
	 * 验证商城公告号是否已经存在
	 */
	public boolean isIdExist(String id){
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="select * from notice where noticeID=?";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(id));
			
			res=sta.executeQuery();
			
			if(res.next()){
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
	 * 添加商城公告
	 */
	public boolean addNotice(Notice n) {
		boolean flag=false;
		
		conn=new DBConnection().getConnection();
		
		String sql="insert into notice values(?,?)";
		
		try {
			sta=conn.prepareStatement(sql);
			sta.setInt(1, Integer.parseInt(n.getNoticeID()));
			sta.setString(2, n.getNoticeContent());
			
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
