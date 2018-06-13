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
import com.qst.Dao.ArticleDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		    String name=request.getParameter("search");
		    String title="%"+name+"%";
		    String maintain = request.getParameter("isMaintain");
//		    System.out.println("maintain"+maintain);
			ArticleDao articleDao=new ArticleDao();
			List<Article>article=new ArrayList<Article>();
			if (maintain.equals("1")) {
				request.setAttribute("mantain", "true");
			}
			try {
				article=articleDao.searchList(title);
				for(int i=0;i<article.size();i++){
					
					article.get(i).setNumofOption(articleDao.OptionNum(article.get(i).getId()));
					article.get(i).setVoteNum(articleDao.voteNum(article.get(i).getId()));
					//System.out.println(article.get(i).getNumofOption());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("article", article);
			request.getRequestDispatcher("admin/tpList.jsp").forward(request, response);
	
	}

}
