package com.sample.di.demo8;

import org.springframework.stereotype.Repository;

@Repository("orderMySQLDao")
public class OrderMySQLDao implements OrderDao {

	public void removeOrder() {
		System.out.println("SQL �����ͺ��̽����� �ֹ������� �����մϴ�.");
	}
}
 