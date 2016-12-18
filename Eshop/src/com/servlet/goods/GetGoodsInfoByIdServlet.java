package com.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Goods;
import com.dao.GoodsDao;
import com.daoFactory.GoodsDaoFactory;
/**
 * 通过商品编号获取商品信息的控制类
 * @version 1.0.0
 */
public class GetGoodsInfoByIdServlet extends HttpServlet {

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String id=request.getParameter("id");
		
		GoodsDao dao=new GoodsDaoFactory().getGoodsDaoInstance();
		
		Goods goods=dao.getGoodsInfoById(id);
		
		HttpSession session=request.getSession();
		session.setAttribute("goodsInfo", goods);
		
		
		response.sendRedirect("/client/view/goods/addToShoppingCar.jsp");
		
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
