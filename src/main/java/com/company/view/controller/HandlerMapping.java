package com.company.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.company.view.board.DeleteBoardController;
import com.company.view.board.GetBoardController;
import com.company.view.board.GetBoardListController;
import com.company.view.board.InsertBoardController;
import com.company.view.board.UpdateBoardController;
import com.company.view.controller.user.LoginController;
import com.company.view.controller.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mapping;
	
	//생성자
	public HandlerMapping() {
		mapping = new HashMap<String, Controller>();
		
		mapping.put("/login.do", new LoginController());
		mapping.put("/getBoardList.do", new GetBoardListController());
		mapping.put("/getBoard.do", new GetBoardController());
		mapping.put("/insertBoard.do", new InsertBoardController());
		mapping.put("/updateBoard.do", new UpdateBoardController());
		mapping.put("/deleteBoard.do", new DeleteBoardController());
		mapping.put("/logout.do", new LogoutController());
	}
	
	//사용자 정의 메소드 구현
	public Controller getController(String path) {
		return mapping.get(path);
	}
}
