package kr.co.jhta;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class CustomerDao {

	private SqlMapClientTemplate template;

	public void setTemplate(SqlMapClientTemplate template) {
		this.template = template;
	}
	
	public List<CustomerVo> getAllCust() {
		return template.queryForList("getAllCust");
	}
	
}
