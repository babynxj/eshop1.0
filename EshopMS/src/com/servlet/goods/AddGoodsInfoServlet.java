package com.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.bean.Goods;
import com.dao.GoodsClassDao;
import com.dao.GoodsDao;
import com.daoFactory.GoodsClassDaoFactory;
import com.daoFactory.GoodsDaoFactory;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
/**
 * 添加商品信息的控制类
 * @version 1.0.0
 */
public class AddGoodsInfoServlet extends HttpServlet {
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		request.setCharacterEncoding("UTF-8");
		
		String goodsID=request.getParameter("goodsID");
		String goodsName=request.getParameter("goodsName");
		String goodsClassName=request.getParameter("goodsClassName");
			
		String goodsDepict=request.getParameter("goodsDepict");
		
		String goodsPrice=request.getParameter("goodsPrice");
		String goodsAmount=request.getParameter("goodsAmount");
			
		/*
		 * 获取系统时间，即商品上架时间
		 */
		Calendar cal=new GregorianCalendar();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		int day=cal.get(Calendar.DAY_OF_MONTH);
			
		String yearStr=String.valueOf(year);
		String monthStr=String.valueOf(month);
		String dayStr=String.valueOf(day);
			
		String regTime=yearStr+"-"+monthStr+"-"+dayStr;
		//生产厂家
		String manufacturer=request.getParameter("manufacturer");
	
		//商品类	
		Goods goods=new Goods();
			
		goods.setGoodsID(goodsID);
		goods.setGoodsName(goodsName);
		goods.setGoodsDepict(goodsDepict);
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsAmount(goodsAmount);
		goods.setGoodsLeaveNum(goodsAmount);
		goods.setRegTime(regTime);
		goods.setManufacturer(manufacturer);
		
		GoodsDao dao=new GoodsDaoFactory().getGoodsDaoInstance();
		
		boolean isIdExist=dao.isIdExist(goodsID);
		
		if(isIdExist){
			response.sendRedirect("/server/view/goods/goodsIdIsExist.jsp");
		}else{
			dao.itemUpshelf(goods,goodsClassName);
			response.sendRedirect("/server/view/goods/uploadGoodsImg.jsp?id="+goodsID);
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}
	
	/**
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
