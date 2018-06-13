package com.qst.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qst.Bean.User;
import com.qst.Util.JDBCUtil;

public class UserDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * 用户注册操作
	 * 
	 * @return
	 */
	public boolean addUser(User user) {
		boolean flag = false;

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("insert into member(account,password,nickname) value(?,?,?)");
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNickname());
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

	/**
	 * 
	 * 检验用户账号是否已经注册
	 * 
	 * @return
	 */
	public boolean FindByaccount(String account) {
		boolean flag = false;

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("select * from member where account=?");
			ps.setString(1, account);
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

	/**
	 * 
	 * 检验用户昵称是否已经存在
	 * 
	 * @return
	 */
	public boolean FindBynickname(String nickname) {
		boolean flag = false;

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("select * from member where nickname=?");
			ps.setString(1, nickname);
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

	/**
	 * 
	 * 用户登录
	 * 
	 * @return
	 */
	public User Login(String account, String password) {
	
		User user =new User();

		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement("select * from member where account=? and password=?");
			ps.setString(1, account);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setType(rs.getInt("type"));
				user.setStatus(rs.getInt("status"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}

		return user;
	}
}
