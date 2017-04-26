package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.library.model.Member;
import com.library.util.DBUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MemberDaoImpl implements MemberDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;
	ArrayList<Member> al;
	boolean isReflected = false;

	@Override
	public int addMember(Member member) {

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into member(memberId,name,address,type,password) values(?,?,?,?,?);");
			ps.setString(1, member.getMemberId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getAddress());
			ps.setString(4, member.getType());
			ps.setString(5, member.getMemberId());
			if (ps.executeUpdate() == 1) {
				return 1;
			}
		} catch (MySQLIntegrityConstraintViolationException e){
			e.printStackTrace();
			return 2;
		}catch (SQLException e) {
			e.printStackTrace();
			return 3;
			
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public boolean updateMember(Member member) {

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(
					"update member set name=?,address=?,type=?,password=" + member.getPassword() + "where memberId=?");
			ps.setString(1, member.getName());
			ps.setString(2, member.getAddress());
			ps.setString(3, member.getType());
			ps.setString(4, member.getMemberId());
			ps.executeUpdate();
			if (ps.executeUpdate() == 1) {
				isReflected = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return isReflected;
	}

	@Override
	public boolean deleteMember(Member member) {
		System.out.println("in delete" + member);
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from member where memberId=?;");
			ps.setString(1, member.getMemberId());
			ps.executeUpdate();
			if (ps.executeUpdate() == 1) {
				isReflected = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return isReflected;
	}

	@Override
	public boolean validateMember(String memberId, String password, String type) {

		boolean isValid = false;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from member where memberId=? and password=? and type=?");
			ps.setString(1, memberId);
			ps.setString(2, password);
			ps.setString(3, type);
			rs = ps.executeQuery();
			isValid = rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return isValid;
	}

	@Override
	public boolean changePassword(String memberId, String password) {
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update member set password=? where memberId=?;");
			ps.setString(1, password);
			ps.setString(2, memberId);
			int i = ps.executeUpdate();
			if (i != 0) {
				isReflected = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}

		return isReflected;
	}

	@Override
	public ArrayList<Member> retrieveAll() {

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from member;");
			rs = ps.executeQuery();
			while (rs.next()) {
				Member member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				al.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}

		return null;
	}

	@Override
	public Member getMemberData(String memberId) {
		Member member = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from member where memberId=?;");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString(1));
				member.setName(rs.getString(2));
				member.setAddress(rs.getString(3));
				member.setType(rs.getString(4));
				member.setPassword(rs.getString(5));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}

}
