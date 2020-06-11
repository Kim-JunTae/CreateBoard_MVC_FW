package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.MVC_FW_Board.board.BoardDAO;
import com.company.MVC_FW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class InsertBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("새 게시글 등록 처리됨");
		
		//1. 사용자 정보 추출
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
				
		//2. H2 DB 연동
		BoardDO boardDO = new BoardDO();
		boardDO.setTitle(title);
		boardDO.setWriter(writer);
		boardDO.setContent(content);
				
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(boardDO);
		
		return "getBoardList.do";
	}

}
