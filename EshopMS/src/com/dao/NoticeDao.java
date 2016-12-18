package com.dao;

import java.util.ArrayList;

import com.bean.Notice;
/**
 * 商城公告信息的实体类
 * @version 1.0.0
 */
public interface NoticeDao {

	/**
	 * 获取所有公告信息
	 */
	public ArrayList<Notice> getAllInfo();
	
	/**
	 * 通过公告号获取公告信息
	 */
	public Notice getNoticeInfoById(String id);
	
	/**
	 * 修改公告信息
	 */
	public boolean updateNoticeInfo(Notice n);
	
	/**
	 * 删除公告信息
	 */
	public boolean deleteNoticeInfo(String id);
	
	/**
	 * 验证商城公告号是否被已经存在
	 */
	public boolean isIdExist(String id);
	
	/**
	 * 添加商城公告
	 */
	public boolean addNotice(Notice n);
}
