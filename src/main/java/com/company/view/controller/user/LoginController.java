package com.company.view.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.MVC_FW_Board.user.UserDAO;
import com.company.MVC_FW_Board.user.UserDO;
import com.company.view.controller.Controller;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		//1.사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2.H2 DB 연동처리
		//2.1 DO 클래스 객체 생성후 초기화
		UserDO userDO = new UserDO();
		userDO.setId(id);
		userDO.setPassword(password);
		
		//2.2 DAO 클래스 객체 생성 후 로그인 조회(select) getUser() 메소드 호출
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		
		//포워딩
		if(user != null) {
			//로그인 성공!
			return "getBoardList.do";
		}else {
			//로그인 실패!
			return "login";
		}
	}

}
