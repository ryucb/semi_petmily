package com.petmily.user.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.petmily.common.JDBCTemplate.close;
import static com.petmily.common.JDBCTemplate.getConnection;
import com.petmily.board.model.dao.BoardDao;
import com.petmily.user.model.vo.User;

public class UserDao {
	private Properties prop=new Properties();
	
	public UserDao() {
		
		try {
			String path=UserDao.class.getResource("/sql/user/user-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}


	public boolean userIdDuplicate(Connection conn, String userId){
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		String sql=prop.getProperty("duplicate");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()) flag=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println(flag);
		return flag;
		
	}
	
	public int userJoin(Connection conn, User u) {
		PreparedStatement pstmt=null;
		int result = 0;
		String sql = prop.getProperty("userJoin");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3,u.getUserName());
//			pstmt.setString(4,u.getUserBirthDay());
			pstmt.setString(5,u.getPhone());
			pstmt.setString(6, u.getZipCode());
			pstmt.setString(7, u.getAddress());
			pstmt.setString(8, u.getEmail());
			pstmt.setString(9,u.getGender());
//			pstmt.setString(10,u.getUserType());
			result=pstmt.executeUpdate();			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
//	휴대번호 중복확인 로직
	public boolean phoneDuplicate(Connection conn, String phone) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = prop.getProperty("duplicatePhone");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true; // true는 이용이 불가능 ( 아이디가 DB에 있으니, 사용할 수 없다! )
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		} 
		return flag;
	}
	
	
//	이메일 중복확인 로직
	public boolean emailDuplicate(Connection conn, String emailId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = prop.getProperty("duplicateEmail");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emailId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true; // true는 이용이 불가능 ( 아이디가 DB에 있으니, 사용할 수 없다! )
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		} 
		return flag;
	}
	
}
	

