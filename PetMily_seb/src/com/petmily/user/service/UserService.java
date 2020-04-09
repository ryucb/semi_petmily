package com.petmily.user.service;
import static com.petmily.common.JDBCTemplate.close;
import static com.petmily.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.petmily.user.model.dao.UserDao;
import com.petmily.user.model.vo.User;

public class UserService {
	
	UserDao dao = new UserDao();



//회원가입 중, [아이디 중복확인] 체크하기
public boolean userIdDuplicate(String userId) {
	Connection conn = getConnection();
	boolean flag = dao.userIdDuplicate(conn, userId);
	close(conn);
	return flag;
	}

public int userJoin(User u) {
	Connection conn = getConnection();
	int result = dao.userJoin(conn, u);
	close(conn);
	return result;
}

//회원가입 중, [휴대번호 중복확인] 체크하기
public boolean phoneDuplicate(String phone) {
	Connection conn = getConnection();
	boolean flag = dao.phoneDuplicate(conn, phone);
	close(conn);
	return flag;
}

//회원가입 중, [이메일 중복확인] 체크하기
public boolean emailDuplicate(String emailId) {
	Connection conn = getConnection();
	boolean flag = dao.emailDuplicate(conn, emailId);
	close(conn);
	return flag;
}

}