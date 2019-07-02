package kr.co.jhta.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.jhta.dao.JobDao;
import kr.co.jhta.vo.Job;

public class JobApp {

	public static void main(String[] args) {
		
		String resource = "classpath:/META-INF/spring/context.xml";
		ApplicationContext context= new ClassPathXmlApplicationContext(resource);
		
		JobDao jobDao = context.getBean(JobDao.class);
		
		Job job = jobDao.getJobById("IT_PROG");
		System.out.println("�� �� �� : " + job.getId());
		System.out.println("��    �� : " + job.getTitle());
		System.out.println("�ּұ޿� : " + job.getMinSalary());
		System.out.println("�ִ�޿� : " + job.getMaxSalary());
		
		System.out.println();

		List<Job> jobs =  jobDao.getAllJobs();
		for(Job j : jobs) {
			System.out.println("=================================");
			System.out.println("�� �� �� : " + j.getId());
			System.out.println("��    �� : " + j.getTitle());
			System.out.println("�ּұ޿� : " + j.getMinSalary());
			System.out.println("�ִ�޿� : " + j.getMaxSalary());
			System.out.println("=================================");
		}
	}
	
}
