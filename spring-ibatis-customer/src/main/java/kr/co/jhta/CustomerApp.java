package kr.co.jhta;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerApp {

	public static void main(String[] args) {
		String resource = "classpath:/META-INF/spring/context.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);

		CustomerDao customerDao = ctx.getBean(CustomerDao.class);
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n");
			System.out.println("------------------------------------------------------");
			System.out.println("1.전체 조회 2.검색 3.등록 4.수정 5.삭제 0.종료");
			System.out.println("------------------------------------------------------");
			
			System.out.print("입력하세요");
			int menu = scanner.nextInt();
			
			if (menu == 1) {
				List<CustomerVo> customers= customerDao.getAllCust();
				for(CustomerVo c: customers) {
					System.out.println(c.getNo());
					System.out.println(c.getName());
					System.out.println(c.getEmail());
					System.out.println(c.getPhone());
					System.out.println(c.getLocation());
				}
			} else if (menu == 2) {
				
			} else if (menu == 3) {
				
			} else if (menu == 4) {
				
			} else if (menu == 5) {
				
			} else if (menu == 0) {
				System.out.println("프로그램 종료해요");
				break;
			}
			
		}
		
	}
}
