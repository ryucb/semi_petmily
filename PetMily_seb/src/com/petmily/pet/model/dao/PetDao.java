package com.petmily.pet.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.petmily.board.model.dao.BoardDao;
import com.petmily.pet.model.vo.Pet;
import static com.petmily.common.JDBCTemplate.close;

public class PetDao {

	private Properties prop = new Properties();

	public PetDao() {
		try {
			String path = BoardDao.class.getResource("/sql/pet/pet-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int petprofileinsert(Connection conn, Pet pet) {
		
		int result = 0;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("insertPet");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pet.getUserId());
			pstmt.setString(2, pet.getPetName());
			pstmt.setString(3, pet.getPetGender());
			pstmt.setString(4, pet.getPetKind());
			pstmt.setString(5, pet.getPetWeight());
			pstmt.setString(6, pet.getPetAge());
			pstmt.setString(7, pet.getPetAffinity());
			pstmt.setString(8, pet.getPetNeutralization());
			pstmt.setString(9, pet.getPetDisease());
			pstmt.setString(10,pet.getPetDiseaseTxt());
			pstmt.setString(11, pet.getPetSeparation());
			pstmt.setString(12, pet.getPetSeparationTxt());
			pstmt.setString(13, pet.getPetUrine());
			pstmt.setString(14, pet.getPetUrineTxt());
			pstmt.setString(15, pet.getPetIndoor());
			pstmt.setString(16, pet.getPetIndoorTxt());
			pstmt.setString(17, pet.getPetHowling());
			pstmt.setString(18, pet.getPetHowlingTxt());
			pstmt.setString(19, pet.getHeartDisease());
			pstmt.setString(20, pet.getVaccine());
			pstmt.setString(21, pet.getCorona());
			pstmt.setString(22, pet.getKennel());
			pstmt.setString(23, pet.getHospitalName());
			pstmt.setString(24, pet.getHospitalPhone());
			pstmt.setString(25, pet.getHospitalZip());
			pstmt.setString(26, pet.getHospitalAddress());
			pstmt.setString(27, pet.getPetImg());
			pstmt.setString(28, pet.getRegistration());
			pstmt.setString(29, pet.getDetail());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
		
		
	}
}
