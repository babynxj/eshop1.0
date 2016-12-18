package com.daoFactory;

import com.dao.GoodsDao;
import com.daoImpl.GoodsDaoImpl;
/**
 * 商品信息的DaoFactory类
 * @version 1.0.0
 */
public class GoodsDaoFactory {

	public GoodsDao getGoodsDaoInstance(){
		return new GoodsDaoImpl();
	}
}
