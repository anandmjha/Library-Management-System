package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.model.LoginBean;
import com.library.util.DBUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean isValid(LoginBean loginBean) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isValid=false;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from member where memberId=? and password=?");

			ps.setString(1, loginBean.getMemberId());
			ps.setString(2, loginBean.getPassword());
			rs = ps.executeQuery();
			isValid = rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			DBUtil.close(con);

		}

		return isValid;
	}
}
