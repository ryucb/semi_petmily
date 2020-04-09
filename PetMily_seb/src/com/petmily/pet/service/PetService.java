package com.petmily.pet.service;

import static com.petmily.common.JDBCTemplate.getConnection;
import static com.petmily.common.JDBCTemplate.close;
import static com.petmily.common.JDBCTemplate.commit;
import static com.petmily.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.petmily.pet.model.dao.PetDao;
import com.petmily.pet.model.vo.Pet;

public class PetService {
	
	PetDao dao = new PetDao();
	
	public int petprofileinsert(Pet pet) {
		Connection conn = getConnection();
		int result = dao.petprofileinsert(conn,pet);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
		
	}

}
