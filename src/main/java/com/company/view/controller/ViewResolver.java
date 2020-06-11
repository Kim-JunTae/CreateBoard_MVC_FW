package com.company.view.controller;

//Controller가 리턴한 View 이름에 접두사와 접미사를 결합하여 최종으로 실행될 View 경로와 파일명을 완성한다.

public class ViewResolver {
	//필드선언
	public String prefix;	//접두사
	public String suffix;	//접미사
	
	//예를 들어 url이 ./getBoardList.jsp를 요청
	//[ ./ ]은 prefix, [ .jsp ]은 suffix
	
	//Getter&Setter
	public void setPrefix(String prefix) {this.prefix = prefix;}
	public void setSuffix(String suffix) {this.suffix = suffix;}
	
	//사용자 정의 메소드 구현 getView()
	//최종으로 실행될 View 경로와 파일명 완성 메소드
	/*
	 * (예) 포워딩할 때 => ./getBoardList.jsp
	 * prefix	+	viewName		+	suffix
	 * ./		+	getBoardList	+	.jsp
	 */
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
