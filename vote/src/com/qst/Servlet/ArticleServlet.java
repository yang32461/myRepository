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
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/articleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
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
		   String mantain=request.getParameter("mantain");
		   request.setAttribute("mantain", mantain);    
		   int row=5;
			int goPage=1;
			String pageStr=request.getParameter("goPage");
			if (pageStr!=null&&!"".equals(pageStr)) {
				goPage=Integer.parseInt(pageStr);
			}
			ArticleDao articleDao=new ArticleDao();
			List<Article>article=new ArrayList<Article>();
			
			int total=0;
			int page=0;
			total=articleDao.count();
			if (total!=0) {
				page=(total+row-1)/row;
			}
			try {
				article=articleDao.getArticle((goPage-1)*5,row);
				for(int i=0;i<article.size();i++){
					
					article.get(i).setNumofOption(articleDao.OptionNum(article.get(i).getId()));
					article.get(i).setVoteNum(articleDao.voteNum(article.get(i).getId()));
					//System.out.println(article.get(i).getNumofOption());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("goPage", goPage);
			request.setAttribute("page", page);
			request.setAttribute("article", article);
			request.getRequestDispatcher("admin/tpList.jsp").forward(request, response);
	
	
	}

}
