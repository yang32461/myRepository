package com.qst.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qst.Bean.Article;
import com.qst.Bean.Option;
import com.qst.Bean.Vote;
import com.qst.Util.JDBCUtil;

public class ArticleDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Article article = new Article();
	Option option = new Option();

	/**
	 * 
	 * 投票的总数
	 * 
	 * @return
	 */
	public int count() {
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) from article";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * 
	 * 显示投票的列表
	 * 
	 * @return
	 */
	public List<Article> getArticle(int index, int length) throws Exception {
		List<Article> articleList = new ArrayList<Article>();
        try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from article LIMIT ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, length);
			rs = ps.executeQuery();
			Article article1 = null;
			while (rs.next()) {
				article1 = new Article();
				article1.setId(rs.getInt("id"));
				article1.setTitle(rs.getString("title"));
				article1.setDesc(rs.getString("desc"));
				article1.setCreatetime(rs.getDate("createtime"));
				article1.setCreaterid(rs.getInt("createrid"));
				articleList.add(article1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);

		}

		return articleList;
	}

	/**
	 * 
	 * 计算投票的选项
	 * 
	 * @return
	 */
	public int OptionNum(int articleid) {
		String sql = "select count(optionvalue) num from option_t where articleid=? GROUP BY articleid ";
		conn = JDBCUtil.getConnection();
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, articleid);
			rs = ps.executeQuery();
			if (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);

		}
		return i;
	}

	/**
	 * 
	 * 显示已投票的人数
	 * 
	 * @return
	 */
	public int voteNum(int articleid) {
		int num = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(DISTINCT voterid) from vote where articleid=? group by articleid";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, articleid);
			rs = ps.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);

		}
		return num;
	}
	public Article FindByID(int id) {

		Article article=new Article();

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("select * from article where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setDesc(rs.getString("desc"));
				article.setCreatetime(rs.getDate("createtime"));
				article.setCreaterid(rs.getInt("createrid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);

		}
		return article;
	}
	/**
	 * 
	 * 投票选项
	 * 
	 * @return
	 */
	public List<Option> getOptions(int id){
		List<Option> options = new ArrayList<Option>();
        try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from option_t where articleid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			Option option = null;
			while (rs.next()) {
				option = new Option();
				option.setId(rs.getInt("id"));
				option.setOptionvalue(rs.getString("optionvalue"));
				option.setArticleid(rs.getInt("articleid"));
				options.add(option);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);

		}

		return options;
	}
	/**
	 * 
	 * 添加投票
	 * 
	 * @return
	 */
	public boolean addArticle(Article article) {
		boolean flag = false;

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("insert into article(title,`desc`,createrid) values(?,?,?)");
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getDesc());
			ps.setInt(3, article.getCreaterid());
			int result = ps.executeUpdate();
			if (result > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
		return flag;

	}
	public int getbyTitle(String title){
		int num=0;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("select id from article where title=?");
			ps.setString(1, title);
			rs = ps.executeQuery();
			if (rs.next()) {
				num=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);

		}
		return num;
	}
	/**
	 * 
	 * 添加投票选项
	 * 
	 * @return
	 */
	public boolean addOptions(Option option) {
		boolean flag = false;

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("insert into option_t (optionvalue,articleid) values(?,?)");
			ps.setString(1, option.getOptionvalue());
			ps.setInt(2, option.getArticleid());
			int result = ps.executeUpdate();
			if (result > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
		return flag;

	}
	public String getOptionDesc(int artId){
		String desc1=null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("select `desc` from article where id=?");
			ps.setInt(1,artId);
			rs = ps.executeQuery();
			if (rs.next()) {
				desc1=rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
		return desc1;
	}
	/***
	 * 
	 * 进行投票
	 * @return
	 */
	public boolean addVote(Vote vote) {
		boolean flag = false;

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("insert into vote (articleid,optionid,voterid) values(?,?,?)");
			ps.setInt(1, vote.getArticleid());
			ps.setInt(2, vote.getOptionid());
			ps.setInt(3, vote.getVoterid());
			int result = ps.executeUpdate();
			if (result > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
		return flag;

	}
	/***
	 * 判断是否已经投票
	 */
	public boolean IsVote(int artid,int voterid){
		boolean flag=false;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("select * from vote where articleid=? and voterid=?");
		    ps.setInt(1, artid);
		    ps.setInt(2, voterid);
		    rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
		return flag;
	}
	/***
	 * 每个选项的票数
	*/
	public int OptionOfNum(int optionid) {
		int num = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select count(optionid) from vote where optionid=? group by optionid";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, optionid);
			rs = ps.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);

		}
		return num;
	}
	/***
	 * 模糊查询
	 */
	public List<Article> searchList(String title) throws Exception {
		List<Article> articleList = new ArrayList<Article>();
        try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from article where title like ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			
			rs = ps.executeQuery();
			Article article1 = null;
			while (rs.next()) {
				article1 = new Article();
				article1.setId(rs.getInt("id"));
				article1.setTitle(rs.getString("title"));
				article1.setDesc(rs.getString("desc"));
				article1.setCreatetime(rs.getDate("createtime"));
				article1.setCreaterid(rs.getInt("createrid"));
				articleList.add(article1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);

		}

		return articleList;
	}
	/***
	 * 查询已经投过票的投票
	 */
	public boolean findVote(int id){
		boolean flag=false;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("select * from vote where articleid=? ");
		    ps.setInt(1, id);
		  
		    rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
		return flag;
	}
	/****
	 * 查找要进行维护的投票
	 */
	public Article FindArlById(int id){
		Article article=null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from article where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setDesc(rs.getString("desc"));
				article.setCreatetime(rs.getDate("createtime"));
				article.setCreaterid(rs.getInt("createrid"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);

		}

		return article;
	}
   public boolean UpdateArt(int id,String type){
	   boolean flag=false;
	   conn = JDBCUtil.getConnection();
		String sql = "update article set `desc`=? where id=?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, type);
			ps.setInt(2, id);
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);

		}
	return flag;
	    }
   
   /***
    * 删除选项
   */
   public boolean del(int id){
	   boolean flag=false;
	  
	   try {
		 conn = JDBCUtil.getConnection();
		   String sql = "delete  from option_t where articleid=?";
		ps = conn.prepareStatement(sql);
		 ps.setInt(1, id);
		   ps.executeUpdate();
			flag = true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtil.close(rs, ps, conn);

	}
	  
	   return flag;
   }
}
