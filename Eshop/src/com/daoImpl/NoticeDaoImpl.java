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
}
