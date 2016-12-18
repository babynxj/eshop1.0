package com.servlet.orderForm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderFormDao;
import com.dao.OrderListDao;
import com.daoFactory.OrderFormDaoFactory;
import com.daoFactory.OrderListDaoFactory;
/**
 * 通过编号获取订单信息的控制类
 * @version 1.0.0
 */
public class GetOrderFormByIdServlet extends HttpServlet {

	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		request.setCharacterEncoding("GBK");
		
		String id=request.getParameter("id");
		
		OrderFormDao dao1=new OrderFormDaoFactory().getOrderFormDaoInstance();
		
		Vector v=new Vector();
		
		v=dao1.getOrderFormInfoById(id);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("orderForm",v);
		
		OrderListDao dao2=new OrderListDaoFactory().getOrderListDaoInstance();
		
		ArrayList list=new ArrayList();
		
		list=dao2.getOrderList(id);
		
		session.setAttribute("orderList", list);
		
		response.sendRedirect("/server/view/orderForm/updateOrderForm.jsp");
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
