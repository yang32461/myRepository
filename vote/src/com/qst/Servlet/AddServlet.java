package com.qst.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.Bean.Article;
import com.qst.Bean.Option;
import com.qst.Dao.ArticleDao;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int alike = 0;
		String title = request.getParameter("title");
		ArticleDao articleDao = new ArticleDao();
		String[] choose = request.getParameterValues("choose");
		int num = 0;
		String id = request.getParameter("id");
		int i = Integer.parseInt(id);
		String type = request.getParameter("type");
		if (type.equals("单选")) {
			type = "0";
		} else {
			type = "1";
		}
		int isTrue=0;
		isTrue=articleDao.getbyTitle(title);
		if (isTrue!=0) {
			out.print("<script language='JavaScript'>alert('投票已存在!!');history.go(-1);;</script>");
		}else{
			
		
		for (int v = 0; v < choose.length; v++) {
			for (int t = v + 1; t < choose.length; t++) {
				if (choose[v].equals(choose[t])) {
					alike = 1;
				}
			}
		}

		Article article = new Article(title, type, i);
		boolean flag = false;
		if (alike == 0) {
			flag = articleDao.addArticle(article);
			if (flag) {
				num = articleDao.getbyTitle(title);
				if (num != 0) {

					for (int k = 0; k < choose.length; k++) {
						Option option = new Option(choose[k], num);
						articleDao.addOptions(option);
					}
					request.getRequestDispatcher("articleServlet?goPage=1").forward(request, response);

				}
			}

		} else {
			out.print("<script language='JavaScript'>alert('选项重复!!');history.go(-1);;</script>");
			// request.getRequestDispatcher("articleServlet?goPage=1").forward(request,
			// response);
		}

	}
	}
}
