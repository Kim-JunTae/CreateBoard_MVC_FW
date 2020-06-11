package com.company.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //�߰�
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

	//����� ���� �޼ҵ� ����
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. Ŭ���̾�Ʈ�� ��û path ���� ����
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		//�� �ٷ� �ٲپ� ����.
		//int uriLastIndex = uri.last IndexOf("/");
		//String path = uri.substring(uriLastIndex);
		
		//2. HandlerMapping�� ���ؼ� path�� �ش��ϴ� Controller�� �˻��Ѵ�.
		// ���� ������ �� : HandlerMapping ��ü�� ���ؼ� path�� �Ѱ��༭ ���� Controller�� �����´�
		Controller ctrl = handlerMapping.getController(path);
		
		//3. �˻��� Controller�� �����Ѵ�.
		String viewName = ctrl.handleRequest(request, response);
		
		//4. ViewResolver�� ���ؼ� viewName�� �ش��ϴ� ������(������)�� �˻��Ѵ�.
		String view = null;
		
		if(viewName.contains(".do")) {	//�����ϰ� �ִ��� �Ǵ��ϴ� �Լ� contains() �޼ҵ�
			view = viewName;
		}else {
			view = viewResovler.getView(viewName);
		}
		
		//5. �˻��� ȭ��(������)���� �̵��Ѵ�.
		response.sendRedirect(view);
	}
}
