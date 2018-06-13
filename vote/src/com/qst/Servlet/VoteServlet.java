package com.qst.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.Bean.Vote;
import com.qst.Dao.ArticleDao;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/voteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
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
      int oid=0;
	  ArticleDao articleDao=new ArticleDao();
	  String voterId=request.getParameter("id");
	   
	  PrintWriter out=response.getWriter(); 
      int id=Integer.parseInt(voterId);
     
      String artId=request.getParameter("articleId");
      int artid=Integer.parseInt(artId);
      String desctype=articleDao.getOptionDesc(artid);
      boolean flag1=false;
      flag1=articleDao.IsVote(artid, id);
      System.out.println(flag1);
      if (!flag1) {
    	  if (desctype.equals("0")) {
        	  String oId=request.getParameter("radio");
        	  oid=Integer.parseInt(oId);
        	  Vote vote=new Vote(artid,oid,id);
        	  boolean flag=articleDao.addVote(vote);
        	  if (flag) {
        		  out.print("<script language='JavaScript'>alert('投票成功!!');window.location.href='articleServlet?goPage=1';</script>");
    		}else{
    			 out.print("<script language='JavaScript'>alert('投票失败!!');window.location.href='articleServlet?goPage=1';</script>");
    		}
	} else{
		int num=0;
		String []oId1=request.getParameterValues("checkbox");
		for(int i=0;i<oId1.length;i++){
			
			 int oid1=Integer.parseInt(oId1[i]);
			 Vote vote1=new Vote(artid,oid1,id);
			 boolean flag=articleDao.addVote(vote1);
			 if (flag) {
				num++;
			}
		}
		  if (num>0) {
    		  out.print("<script language='JavaScript'>alert('投票成功!!');window.location.href='articleServlet?goPage=1';</script>");
		}else{
			 out.print("<script language='JavaScript'>alert('投票失败!!');window.location.href='articleServlet?goPage=1';</script>");
		}
	}
	}else{
		out.print("<script language='JavaScript'>alert('您已投过票了!!');window.location.href='articleServlet?goPage=1';</script>");
	}
	}

}
