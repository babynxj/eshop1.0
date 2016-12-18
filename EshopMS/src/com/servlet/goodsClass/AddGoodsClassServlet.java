package com.servlet.goodsClass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.GoodsClass;
import com.dao.GoodsClassDao;
import com.daoFactory.GoodsClassDaoFactory;
/**
 * 添加商品种类信息的控制类
 * @version 1.0.0
 */
public class AddGoodsClassServlet extends HttpServlet {

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String goodsClassID=request.getParameter("goodsClassID");
		String goodsClassName=request.getParameter("goodsClassName");
		
		GoodsClass goodsClass=new GoodsClass();
		goodsClass.setGoodsClassID(goodsClassID);
		goodsClass.setGoodsClassName(goodsClassName);
		
		GoodsClassDao dao=new GoodsClassDaoFactory().getGoodsClassDaoInstance();
		
		if(dao.isIdExist(goodsClassID)){
			response.sendRedirect("/server/view/goodsClass/addGoodsClass.jsp");
		}else{
			boolean flag=dao.addGoodsClass(goodsClass);
			response.sendRedirect("/server/servlet/GetGoodsClassInfoServlet");
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
