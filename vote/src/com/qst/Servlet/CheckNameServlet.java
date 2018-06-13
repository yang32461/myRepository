package com.qst.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.Dao.UserDao;
import com.qst.Service.UserService;

/**
 * Servlet implementation class CheckNameServlet
 */
@WebServlet("/checknameservlet")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); */
		String account=request.getParameter("account");
         UserDao userDao=new UserDao();
          if (userDao.FindByaccount(account)) {
			response.getWriter().println("<font color='red'>手机号已注册</font>");
		}else{
	       response.getWriter().println("手机号可以使用");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
