package com.servlet.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Notice;
import com.dao.NoticeDao;
import com.daoFactory.NoticeDaoFactory;
/**
 * 修改商城公告信息的控制类
 * @version 1.0.0
 */
public class UpdateNoticeServlet extends HttpServlet {

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
		
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("noticeID");
		String content=request.getParameter("noticeContent");
		Notice n=new Notice();
		n.setNoticeID(id);
		n.setNoticeContent(content);
		
		NoticeDao dao=new NoticeDaoFactory().getNoticeDaoInstance();
		
		boolean flag=dao.updateNoticeInfo(n);
		
		if(flag){
			response.sendRedirect("/server/servlet/GetNoticeServlet");
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
