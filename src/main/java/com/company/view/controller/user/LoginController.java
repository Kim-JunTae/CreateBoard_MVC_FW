package com.company.view.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.MVC_FW_Board.user.UserDAO;
import com.company.MVC_FW_Board.user.UserDO;
import com.company.view.controller.Controller;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		//1.����� �Է����� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2.H2 DB ����ó��
		//2.1 DO Ŭ���� ��ü ������ �ʱ�ȭ
		UserDO userDO = new UserDO();
		userDO.setId(id);
		userDO.setPassword(password);
		
		//2.2 DAO Ŭ���� ��ü ���� �� �α��� ��ȸ(select) getUser() �޼ҵ� ȣ��
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		
		//������
		if(user != null) {
			//�α��� ����!
			return "getBoardList.do";
		}else {
			//�α��� ����!
			return "login";
		}
	}

}
