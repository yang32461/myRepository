package com.qst.Servlet;

import java.io.IOException;
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
import com.qst.Dao.UserDao;

/**
 * Servlet implementation class ArticleSearchServlet
 */
@WebServlet("/articleSearchServlet")
public class ArticleSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleSearchServlet() {
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
		String id = request.getParameter("id");
		int i = Integer.parseInt(id);
		ArticleDao articleDao=new ArticleDao();
		Article article=new Article();
		article=articleDao.FindByID(i);
		List<Option>optionList=new ArrayList<Option>();
		
		if(article!=null){
			article.setNumofOption(articleDao.OptionNum(article.getId()));
			article.setVoteNum(articleDao.voteNum(article.getId()));
			optionList=articleDao.getOptions(article.getId());
		    request.setAttribute("optionList",optionList);
			request.setAttribute("article", article);
			request.getRequestDispatcher("admin/cytp.jsp").forward(request, response);
		}
		
		
		
	}

}
