package com.company.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	/*
	 * ��ü���� Controller Ŭ�������� �����ϱ⿡ �ռ�
	 * ��� Controller�� ���� Ÿ������ �����ϱ� ���� �������̽��� ������ �Ѵ�.
	 */
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}