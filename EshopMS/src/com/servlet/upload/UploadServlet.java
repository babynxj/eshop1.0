package com.servlet.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDao;
import com.daoFactory.GoodsDaoFactory;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
/**
 * 上传图片的控制类
 * @version 1.0.0
 */
public class UploadServlet extends HttpServlet {

	private String path;
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
	
		try {
			
			request.setCharacterEncoding("UTF-8");
			
			String id=request.getParameter("id");
			
			SmartUpload su = new SmartUpload();
			su.initialize(this.getServletConfig(),request,response); // 初始化上传操作
			su.setAllowedFilesList("jpg,gif,png,jpeg,bmp");//允许上传的文件通过扩展名限制。
			su.upload();//上传文件
			
			         
			File file = su.getFiles().getFile(0);
			 // 生成文件名
			String fname = su.getFiles().getFile(0).getFileName();
			// 保存文件
		    file.saveAs(this.getServletContext().getRealPath("/").replace("server", "")+"client"+"/upload/"+fname,su.SAVE_PHYSICAL);
			             // 提示
			out.println("<script>alert('文件上传成功！');location.href='upload.jsp';</script>");
			             
			path="/upload/"+fname;
			
			GoodsDao dao=new GoodsDaoFactory().getGoodsDaoInstance();
			
			boolean flag=dao.getImgPath(id,path);
			
			if(flag){
				response.sendRedirect("/server/servlet/GetGoodsInfoServlet");
			}
			
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		
		
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
