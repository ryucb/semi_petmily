package com.petmily.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.petmily.user.model.vo.PetSitter;
import com.petmily.user.model.vo.PetSitterCertificate;
import com.petmily.user.model.vo.User;

/**
 * Servlet implementation class SitterJoinServlet
 */
@WebServlet("/apply/join")
public class SitterJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SitterJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "글작성 오류! [form:encType]");
			request.setAttribute("loc", "/apply");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = getServletContext().getRealPath("/upload/sitter/");
		int maxSize=1024*1024*10;
		
		//db에 저장할 값을 받아오기.
		
		MultipartRequest mr = new MultipartRequest(request,path,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		String id = mr.getParameter("user_id"); //펫시터 아이디
		String password = mr.getParameter("password"); //펫시터 비번
		String file = mr.getParameter("upload"); //펫시터 프로필 이미지
		String name = mr.getParameter("user_name"); //펫시터 이름
		String gender = mr.getParameter("gender");//성별
		String bday = mr.getParameter("user_birth_day"); //펫시터 생일
		String email = mr.getParameter("email");//펫시터 이메일
		String phone = mr.getParameter("phone");//펫시터 핸드폰 번호
		String post = mr.getParameter("postNum");// 펫시터 우편 번호
		String address = mr.getParameter("address");//펫시터 주소
		String detial = mr.getParameter("detail");// 펫시터 상세 주소
		String bank = mr.getParameter("bank");// 펫시터 계좌 은행명
		String account = mr.getParameter("account"); //펫시터 계좌번호
		String accountName = mr.getParameter("accountName");//펫시터 예금주
		String certificate = mr.getParameter("certificate");//자격증 유무
		String certiName = mr.getParameter("certiName");//펫시터 자격증 명
		String certiAgency = mr.getParameter("certiAgency"); //펫시터 자격증 인증기관
		String certiday = mr.getParameter("certiday");//펫시터 자격증 취득일자.
		String expireday = mr.getParameter("expireday"); //펫시터 자격증 만료일자.
		String limg = mr.getParameter("liupload"); //펫시터 자격증 이미지
		String type = mr.getParameter("type");//사용자 타입 : 미승인펫시터
		
		//얘네를 각각 알맞은 vo에 넣어주세요~
		
		PetSitter ps = new PetSitter(id,certificate,null,null,null,null,bank,accountName,null,limg);
		//펫시터 직업, 가족사항, 강아지 키운적 있는지, 경력, input받아서 넣어주기. 펫시터 타입은 DEFAULT로 넣어주기.
		PetSitterCertificate psc = new PetSitterCertificate(id,certiName,certiAgency,certiday,expireday,limg);
		
		User u = new User(id,password,name,bday,phone,post,address,email,gender,null,type);
		//회원탈퇴는 DEFAULT로 넣기
		
				
		request.getRequestDispatcher("/") //시은이 jsp 파일(펫시터 등록 폼) 내부 경로 입력.
		.forward(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
