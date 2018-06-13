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
import com.qst.Util.CountPercent;

/**
 * Servlet implementation class LookArticleServlet
 */
@WebServlet("/lookArticleServlet")
public class LookArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookArticleServlet() {
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
		CountPercent countPercent=new CountPercent();
		int total=0;//计算总票数
		String id = request.getParameter("id");
		int i = Integer.parseInt(id);
		ArticleDao articleDao=new ArticleDao();
		Article article=new Article();
		article=articleDao.FindByID(i);
		List<Option>optionList=new ArrayList<Option>();
		if (article!=null) {
			article.setNumofOption(articleDao.OptionNum(article.getId()));
			article.setVoteNum(articleDao.voteNum(article.getId()));
			optionList=articleDao.getOptions(article.getId());
			for(int t=0;t<optionList.size();t++){
				optionList.get(t).setNum(articleDao.OptionOfNum(optionList.get(t).getId()));
			    total=total+optionList.get(t).getNum();
			}
			for(int k=0;k<optionList.size();k++){
				if (total!=0) {
					String per=countPercent.myPercent(optionList.get(k).getNum(),total);
					double percent=(double)optionList.get(k).getNum()/total;
					optionList.get(k).setPer(per);
					optionList.get(k).setPercent(percent);
				}else{
					optionList.get(k).setPer("0%");
					optionList.get(k).setPercent(0);
				}
				
			}
		    request.setAttribute("optionList",optionList);
			request.setAttribute("article", article);
			request.getRequestDispatcher("admin/cktp.jsp").forward(request, response);
		}
		
	}

}
