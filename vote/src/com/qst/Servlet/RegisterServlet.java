package com.qst.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.Bean.User;
import com.qst.Dao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
       String account=request.getParameter("account");
       String nickname=request.getParameter("nickname");
       String password=request.getParameter("password");
       String repassword=request.getParameter("repassword");
       PrintWriter out=response.getWriter(); 
	   User user=new User(account,password,nickname);
	   boolean flag=userDao.addUser(user);
	    if (flag) {
			out.print("<script language='JavaScript'>alert('注册成功，请登录');window.location.href='login.jsp';</script>"); 
		}
	   
	}

}
