package com.sample.di.demo8;

import org.springframework.stereotype.Repository;

@Repository("orderOracleDao")
public class OrderOracleDao implements OrderDao{
	
	public void removeOrder() {
		System.out.println("����Ŭ �����ͺ��̽����� �ֹ������� �����մϴ�.");
	}
}
