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
}
