package com.company.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //추가
	private HandlerMapping handlerMapping;
	private ViewResolver viewResovler;
	
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResovler = new ViewResolver();
		viewResovler.setPrefix("./");
		viewResovler.setSuffix(".jsp");
	}
	
    public DispatcherServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}

	//사용자 정의 메소드 구현
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. 클라이언트의 요청 path 정보 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		//두 줄로 바꾸어 보자.
		//int uriLastIndex = uri.last IndexOf("/");
		//String path = uri.substring(uriLastIndex);
		
		//2. HandlerMapping을 통해서 path에 해당하는 Controller를 검색한다.
		// 내가 이해한 것 : HandlerMapping 객체를 통해서 path을 넘겨줘서 맞춤 Controller를 가져온다
		Controller ctrl = handlerMapping.getController(path);
		
		//3. 검색된 Controller를 실행한다.
		String viewName = ctrl.handleRequest(request, response);
		
		//4. ViewResolver를 통해서 viewName에 해당하는 페이지(포워딩)을 검색한다.
		String view = null;
		
		if(viewName.contains(".do")) {	//포함하고 있는지 판단하는 함수 contains() 메소드
			view = viewName;
		}else {
			view = viewResovler.getView(viewName);
		}
		
		//5. 검색된 화면(페이지)으로 이동한다.
		response.sendRedirect(view);
	}
}
