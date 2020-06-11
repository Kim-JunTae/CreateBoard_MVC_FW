package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.MVC_FW_Board.board.BoardDAO;
import com.company.MVC_FW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class DeleteBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�Խñ� ���� ó����");
		//1. ����� ���� ����
		String seq = request.getParameter("seq");
		
				
		//2. H2 DB ����
		BoardDO boardDO = new BoardDO();
		boardDO.setSeq(Integer.parseInt(seq));
		
				
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(boardDO);
		return "getBoardList.do";
	}
}