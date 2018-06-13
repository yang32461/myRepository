package com.qst.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.Bean.Article;
import com.qst.Bean.Option;
import com.qst.Dao.ArticleDao;

/**
 * Servlet implementation class MaintainServlet
 */
@WebServlet("/MaintainServlet")
public class MaintainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaintainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleDao articleDao=new ArticleDao();
		Article article=new Article();
	    List<Option>optionList=new ArrayList<Option>();
		String id=request.getParameter("id");
		int Id=Integer.parseInt(id);
		
		PrintWriter out=response.getWriter(); 
		boolean flag=articleDao.findVote(Id);
		if (flag) {
			out.print("<script language='JavaScript'>alert('投票已发布，无法进行维护!!');history.go(-1);</script>");
		}else{
			article=articleDao.FindArlById(Id);
			
			optionList=articleDao.getOptions(Id);
			
			request.setAttribute("article", article);
			request.setAttribute("optionList", optionList);
			request.getRequestDispatcher("admin/Maintain.jsp").forward(request, response);
		}
		
        
	
	}

}
