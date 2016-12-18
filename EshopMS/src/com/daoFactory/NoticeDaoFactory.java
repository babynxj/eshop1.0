package com.daoFactory;

import com.dao.NoticeDao;
import com.daoImpl.NoticeDaoImpl;
/**
 * 商城公告信息的DaoFactory类
 * @version 1.0.0
 */
public class NoticeDaoFactory {

	public NoticeDao getNoticeDaoInstance(){
		return new NoticeDaoImpl();
	}
}
