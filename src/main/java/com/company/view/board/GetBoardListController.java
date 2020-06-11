package com.company.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.MVC_FW_Board.board.BoardDAO;
import com.company.MVC_FW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("��ü �Խñ� �˻� ó����");
		
		//1. �˻� ���(�ۼ���, ����) �� �˻� ���� ��ü�� ������ ���� ����
		String searchField = "";	//����ִ� ��ü
		String searchText = "";
		
		//2. ����� �Է� ���� ����
		if(request.getParameter("searchCondition") != null 
		   && request.getParameter("searchKeyword") != null){
			searchField = request.getParameter("searchCondition");
			searchText = request.getParameter("searchKeyword");
		}
		
		//3. H2 DB ����
		BoardDO boardDO = new BoardDO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);
		
		//4. [�߿�] �˻� ����� session�� �����ϰ� ������(Ŭ���̾�Ʈ�� ����)
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		return "getBoardList";
	}

}
