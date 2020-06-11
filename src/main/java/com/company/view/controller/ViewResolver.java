package com.company.view.controller;

//Controller�� ������ View �̸��� ���λ�� ���̻縦 �����Ͽ� �������� ����� View ��ο� ���ϸ��� �ϼ��Ѵ�.

public class ViewResolver {
	//�ʵ弱��
	public String prefix;	//���λ�
	public String suffix;	//���̻�
	
	//���� ��� url�� ./getBoardList.jsp�� ��û
	//[ ./ ]�� prefix, [ .jsp ]�� suffix
	
	//Getter&Setter
	public void setPrefix(String prefix) {this.prefix = prefix;}
	public void setSuffix(String suffix) {this.suffix = suffix;}
	
	//����� ���� �޼ҵ� ���� getView()
	//�������� ����� View ��ο� ���ϸ� �ϼ� �޼ҵ�
	/*
	 * (��) �������� �� => ./getBoardList.jsp
	 * prefix	+	viewName		+	suffix
	 * ./		+	getBoardList	+	.jsp
	 */
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
