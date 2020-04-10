package com.petmily.admin.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.petmily.user.model.vo.AdminUser;
import com.petmily.user.model.vo.ApplyUser;
import com.petmily.user.model.vo.ApplyUserData;
import com.petmily.user.model.vo.User;

public class AdminDao {
	
	Properties prop = new Properties();
	
	public AdminDao() {
		
		String path = AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<AdminUser> userList(Connection conn, int cPage, int numPerPage, String type) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AdminUser> list = new ArrayList<AdminUser>();
		String sql = prop.getProperty("userList");
		sql = sql.replaceAll("ORTYPERO",type);
		try {
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdminUser u = new AdminUser();
				u.setUserId(rs.getString("USER_ID"));
				u.setUserName(rs.getString("USER_NAME"));
				u.setUserBirth(rs.getString("USER_BIRTH_DAY"));
				u.setStarCount(rs.getDouble("STAR"));
				u.setBlindCount(rs.getInt("BCOUNT"));
				list.add(u);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	public int userCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = prop.getProperty("userCount");
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			rs.next();
			count = Integer.parseInt(rs.getString(1));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return count;
	}

	public ArrayList<ApplyUser> applyList(Connection conn, int cPage, int numPerPage, String type) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ApplyUser> list = new ArrayList<ApplyUser>();
		String sql = prop.getProperty("applyList");
		sql = sql.replaceAll("ORTYPERO",type);
		try {
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ApplyUser au = new ApplyUser();
				au.setUserid(rs.getString("USER_ID"));
				au.setName(rs.getString("USER_NAME"));
				au.setEnrollDate(rs.getString("ENROLL_DATE"));
				list.add(au);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	public int applyCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = prop.getProperty("applyCount");
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			rs.next();
			count = Integer.parseInt(rs.getString(1));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return count;
	}

	public ApplyUserData applyUserData(Connection conn, String userId) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ApplyUserData aud = null;
		String sql = prop.getProperty("applyData");
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				aud = new ApplyUserData();
				aud.setPET_SITTER_ID(rs.getString("PET_SITTER_ID"));
				aud.setPET_CERTIFICATE_YN(rs.getString("PET_CERTIFICATE_YN"));
				aud.setPET_SITTER_JOB(rs.getString("PET_SITTER_JOB"));
				aud.setPET_SITTER_FAMILY(rs.getString("PET_SITTER_FAMILY"));
				aud.setPET_SITTER_KEEP_PETS(rs.getString("PET_SITTER_KEEP_PETS"));
				aud.setPET_SITTER_ACTIVITY(rs.getString("PET_SITTER_ACTIVITY"));
				aud.setPET_SITTER_IMG(rs.getString("setPET_SITTER_IMG"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return aud;
	}

	public ApplyUserData applyUserResVal(Connection conn, ApplyUserData aud) {
		// TODO Auto-generated method stub
		return null;
	}


}
