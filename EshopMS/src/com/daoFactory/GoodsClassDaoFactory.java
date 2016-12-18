package com.daoFactory;

import com.dao.GoodsClassDao;
import com.daoImpl.GoodsClassDaoImpl;

/**
 * 商品种类信息的DaoFactory类
 * @version 1.0.0
 */
public class GoodsClassDaoFactory {

	public GoodsClassDao getGoodsClassDaoInstance(){
		return new GoodsClassDaoImpl();
	}
}
