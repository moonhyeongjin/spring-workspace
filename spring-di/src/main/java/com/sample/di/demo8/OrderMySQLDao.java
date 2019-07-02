package com.sample.di.demo8;

import org.springframework.stereotype.Repository;

@Repository("orderMySQLDao")
public class OrderMySQLDao implements OrderDao {

	public void removeOrder() {
		System.out.println("SQL 데이터베이스에서 주문정보를 삭제합니다.");
	}
}
 