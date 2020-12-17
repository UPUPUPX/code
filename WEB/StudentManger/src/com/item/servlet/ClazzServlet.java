package com.item.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.item.dao.ClazzDao;
import com.item.model.Clazz;
import com.item.model.Page;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 *
 */
@WebServlet("/ClazzServlet")
public class ClazzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
		if(method.equals("toClazzListView")) {
			clazzList(request,response);
		}else if(method.equals("getClazzList")) {
			try {
				getClazzList(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equals("AddClazz")) {
			try {
				addClazz(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equals("DeleteClazz")) {
			try {
				deleteClazz(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equals("EditClazz")) {
			try {
				editClazz(request,response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

	private void editClazz(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name"); 
		String info = request.getParameter("info");
		Clazz clazz=new Clazz();
		clazz.setName(name);
		clazz.setInfo(info);
		clazz.setId(id);
		ClazzDao clazzdao=new ClazzDao();
		if(clazzdao.editClazz(clazz)>0) {
			response.getWriter().print("success");
		}
	}

	private void deleteClazz(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("clazzid"));
		ClazzDao clazzdao=new ClazzDao();
		if(clazzdao.deleteClazz(id)>0) {
			response.getWriter().print("success");
		}
	}

	private void addClazz(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String name=request.getParameter("name");
		String info=request.getParameter("info");
		Clazz clazz=new Clazz();
		clazz.setName(name);
		clazz.setInfo(info);
		ClazzDao clazzdao=new ClazzDao();
//		System.out.println(name+" "+info);
		if(clazzdao.addClazz(clazz)>0) {
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void getClazzList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name=request.getParameter("clazzName");
		Integer currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Integer pageSize = request.getParameter("rows") == null ? 999 : Integer.parseInt(request.getParameter("rows"));
		Clazz clazz=new Clazz();
		clazz.setName(name);
		ClazzDao clazzdao=new ClazzDao();
		List<Clazz>clazzlist=clazzdao.getClazzList(clazz, new Page(currentPage, pageSize));
		int total=clazzdao.getClazzListTotal(clazz);
		response.setCharacterEncoding("UTF-8");
		Map<String,Object>mp=new HashMap<String,Object>();
		mp.put("total", total);
		mp.put("rows", clazzlist);
		String from=request.getParameter("from");
		if("combox".equals(from)) {
			response.getWriter().write(JSONArray.fromObject(clazzlist).toString());
		}else {
			response.getWriter().print(JSONObject.fromObject(mp).toString());
		}
	}

	private void clazzList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/view/clazzList.jsp").forward(request, response);
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
