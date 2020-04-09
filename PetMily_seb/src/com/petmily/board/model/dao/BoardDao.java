package com.petmily.board.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.petmily.board.model.vo.Board;
import static com.petmily.common.JDBCTemplate.close;

public class BoardDao {
	
	private Properties prop = new Properties();

	public BoardDao() {
		try {
			String path = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int boardInsert(Connection conn, Board b) {
		
		int result = 0;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("insertBoard");
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1,b.getNo());
			pstmt.setString(1, b.getId());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getIntroduce());
			pstmt.setInt(4, b.getSmall());
			pstmt.setInt(5, b.getMiddle());
			pstmt.setInt(6, b.getBig());
			pstmt.setString(7, b.getAddress());
			pstmt.setString(8, b.getMap());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	public int boardImg(Connection conn,String filename) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("boardImg");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, filename);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int boardPlay(Connection conn,Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("basicService");
		try {
			pstmt = conn.prepareStatement(sql);
		
//			pstmt.setInt(1,b.getNo());
			pstmt.setString(1, b.getPlay());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		
	}
	
	public int boardWalk(Connection conn,Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("basicService");
		try {
			pstmt = conn.prepareStatement(sql);
		
//			pstmt.setInt(1,b.getNo());
			pstmt.setString(1, b.getWalk());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		
	}
	
	public int boardOld(Connection conn,Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("plusService");
		try {
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1,b.getNo());
			pstmt.setString(1, b.getOld());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int boardDrug(Connection conn,Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("plusService");
		try {
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1,b.getNo());
			pstmt.setString(1, b.getDrug());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	public int boardPickUp(Connection conn,Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("pickUpService");
		try {
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1,b.getNo());
			pstmt.setString(1, b.getPickUp());
			pstmt.setInt(2,b.getOneWay());
			pstmt.setInt(3,b.getAllWay());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int boardShowerOn(Connection conn,Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("showerService");
		try {
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1,b.getNo());
			pstmt.setString(1, b.getShowerOn());
			pstmt.setInt(2,b.getSmall1());
			pstmt.setInt(3,b.getMiddle1());
			pstmt.setInt(4,b.getBig1());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int boardAddSale(Connection conn,Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("addService");
		try {
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1,b.getNo());
			pstmt.setString(1, b.getAddSale());
			pstmt.setInt(2,b.getSale());
			
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
}
