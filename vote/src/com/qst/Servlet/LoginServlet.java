package com.qst.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.Bean.User;
import com.qst.Dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao=new UserDao();
        User user=new User();
       
        String username = request.getParameter("username");
		String pass = request.getParameter("passwrod");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter(); 
		user = userDao.Login(username, pass);
		if (user!=null&&user.getStatus()==1) {
			Cookie unameCookie=new Cookie("username", username);
			Cookie upassCookie=new Cookie("password", pass);
			unameCookie.setMaxAge(60*60*24);
			upassCookie.setMaxAge(60*60);
			response.addCookie(unameCookie);
	        response.addCookie(upassCookie);
			session.setAttribute("user", user);
			//response.sendRedirect();
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}else{
			out.print("<script language='JavaScript'>alert('登录失败，请重新登录!!');window.location.href='login.jsp';</script>");
		}
	
	
	}

}
