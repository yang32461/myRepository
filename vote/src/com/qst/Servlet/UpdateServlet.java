package com.qst.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.Bean.Option;
import com.qst.Dao.ArticleDao;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String title=request.getParameter("title");
		String []choose=request.getParameterValues("choose");
		int id=Integer.parseInt(request.getParameter("artid"));
		String type=request.getParameter("type");
	        if (type.equals("单选")) {
				type="0";
			}else{
				type="1";
			}
	        System.out.println(type);
	        boolean flag=articleDao.UpdateArt( id,type);
	        if(flag){
	        	boolean flag1=articleDao.del(id);
	        	if (flag1) {
	        		for(int k=0;k<choose.length;k++){
						 Option option=new Option(choose[k],id); 
						 articleDao.addOptions(option);
					}
	        		
				}
	        }
	        request.getRequestDispatcher("articleServlet?goPage=1&mantain=true").forward(request, response);
	}

}
