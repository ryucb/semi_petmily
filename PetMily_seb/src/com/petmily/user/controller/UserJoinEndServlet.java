package com.petmily.user.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petmily.user.model.vo.User;
import com.petmily.user.service.UserService;

/**
 * Servlet implementation class UserJoinEndServlet
 */
@WebServlet("/joinEnd")
public class UserJoinEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserJoinEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String name = request.getParameter("user_name");
		String bday = request.getParameter("user_birth_day");
		
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		String post = request.getParameter("postNum");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String type = request.getParameter("type");
		
		
		User u = new User(id,password,name,bday,phone,post,address,email,gender,null,type);
		
		int result = new UserService().userJoin(u);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
