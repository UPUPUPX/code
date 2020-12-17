package com.item.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.utiles.CheckImgutiles;

/**
 * Servlet implementation class CheckImgServlet
 */
@WebServlet("/CheckImgServlet")
public class CheckImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 验证码Servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if("checkcode".equals(method)){
			generateLoginCpacha(request, response);
			return;
		}
		response.getWriter().write("error method");
	}
	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void generateLoginCpacha(HttpServletRequest request,HttpServletResponse reponse) throws IOException{
		CheckImgutiles checkimgservlet = new CheckImgutiles();
		String generatorVCode = checkimgservlet.generatorVCode();
		request.getSession().setAttribute("checkcode", generatorVCode);
		BufferedImage generatorRotateVCodeImage = checkimgservlet.generatorRotateVCodeImage(generatorVCode, true);
		ImageIO.write(generatorRotateVCodeImage, "gif", reponse.getOutputStream());
	}

}
