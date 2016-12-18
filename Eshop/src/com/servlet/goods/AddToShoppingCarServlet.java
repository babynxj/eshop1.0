package com.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.OrderForm;
import com.bean.OrderList;
import com.dao.OrderFormDao;
import com.daoFactory.OrderFormDaoFactory;
/**
 * 添加商品到购物车的控制类
 * @version 1.0.0
 */
public class AddToShoppingCarServlet extends HttpServlet {

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
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		
		OrderFormDao dao1=new OrderFormDaoFactory().getOrderFormDaoInstance();
		//用户编号
		String userID=request.getParameter("userID");
		
		if(userID==null){
			response.sendRedirect("/client/view/goods/tip.jsp");
		}else{
			
			//商品编号
			String goodsID=request.getParameter("goodsID");
			/*
			 * 获取系统时间，即订单提交时间
			 */
			Calendar cal=new GregorianCalendar();
			int year=cal.get(Calendar.YEAR);
			int month=cal.get(Calendar.MONTH);
			int day=cal.get(Calendar.DAY_OF_MONTH);
				
			String yearStr=String.valueOf(year);
			String monthStr=String.valueOf(month);
			String dayStr=String.valueOf(day);
			
			String submitTime=yearStr+"-"+monthStr+"-"+dayStr;
			
			//发货时间
			String consignmentTime="2015-11-11";
			//总金额
			String priceStr=request.getParameter("price");
			
			String totalPrice=request.getParameter("total_price").replace("$", "");
			//总数量
			String amount=request.getParameter("qty_item_1");
			//是否付款
			String isPayoff="0";
			
			//是否发货
			String isConsignmenet="0";
			//订单类
			OrderForm o=new OrderForm();
			
			int count=dao1.getCount();
			//订单编号，获取订单表里的记录数+1,就是其订单编号
			String orderFormID=String.valueOf(count+1);
			
			o.setOrderFormID(orderFormID);
			o.setUserID(userID);
			o.setGoodsID(goodsID);
			o.setTotalPrice(totalPrice);
			o.setSubmitTime(submitTime);
			o.setConsignmentTime(consignmentTime);
			o.setIsPayoff(isPayoff);
			o.setIsConsignmenet(isConsignmenet);
			
			//生成订单
			boolean flag1=dao1.orderForm(o);
			
			//生成对应的订单列表
			int orderListCount=dao1.getOrderListCount();
			//订单列表编号，获取订单列表表里的记录数+1,就是其订单列表编号
			String orderListID=String.valueOf(orderListCount+1);
			//订单列表类
			OrderList orderList=new OrderList();
			orderList.setOrderListID(orderListID);
			orderList.setOrderFormID(orderFormID);
			orderList.setGoodsID(goodsID);
			orderList.setAmount(amount);
			//生成订单列表
			boolean flag2=dao1.orderList(orderList);
			
		
			
			if(flag1&&flag2){
				response.sendRedirect("/client/servlet/OrderFormServlet?id="+userID);
			}
			
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
