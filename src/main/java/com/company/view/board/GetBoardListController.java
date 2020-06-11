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
		System.out.println("전체 게시글 검색 처리됨");
		
		//1. 검색 대상(작성자, 제목) 및 검색 내용 객체를 저장할 변수 설정
		String searchField = "";	//비어있는 객체
		String searchText = "";
		
		//2. 사용자 입력 정보 추출
		if(request.getParameter("searchCondition") != null 
		   && request.getParameter("searchKeyword") != null){
			searchField = request.getParameter("searchCondition");
			searchText = request.getParameter("searchKeyword");
		}
		
		//3. H2 DB 연동
		BoardDO boardDO = new BoardDO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);
		
		//4. [중요] 검색 결과를 session에 저장하고 포워딩(클라이언트에 응답)
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		return "getBoardList";
	}

}
