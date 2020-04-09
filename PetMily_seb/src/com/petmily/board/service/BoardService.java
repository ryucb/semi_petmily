package com.petmily.board.service;

import com.petmily.board.model.dao.BoardDao;
import com.petmily.board.model.vo.Board;
import static com.petmily.common.JDBCTemplate.getConnection;
import static com.petmily.common.JDBCTemplate.close;
import static com.petmily.common.JDBCTemplate.commit;
import static com.petmily.common.JDBCTemplate.rollback;

import java.sql.Connection;

public class BoardService {
	
	private BoardDao dao = new BoardDao();
	
	public int boardInsert(Board b) {
		
		Connection conn=getConnection();

			//게시판 기본 정보
			int result=dao.boardInsert(conn,b);
				if(result>0){
					//파일 보내기
					for(int i = 0;i<b.getFiles().size();i++) {
						result=dao.boardImg(conn,b.getFiles().get(i));	
					}
//					//추가 할인
					if(b.getAddSale()!=null){
						result=dao.boardAddSale(conn,b);
					}
//					
//					//샤워
					if(b.getShowerOn()!=null) {
						result=dao.boardShowerOn(conn,b);
					}
//					
//					//픽업
					if(b.getPickUp()!=null) {
						result=dao.boardPickUp(conn,b);
					}
//					
//					//추가 옵션
					if(b.getOld()!=null) {
						result=dao.boardOld(conn,b);
					}
					
					if(b.getDrug()!=null) {
						result=dao.boardDrug(conn,b);
					}
//					
//					//기본 옵션
					if(b.getPlay()!=null) {
						result=dao.boardPlay(conn,b);
					}
					
					if(b.getWalk()!=null) {
						result=dao.boardWalk(conn,b);
					}
					
					commit(conn);
					
				}else rollback(conn);
					
					

		
		close(conn);
		
		return result;
	}
}
