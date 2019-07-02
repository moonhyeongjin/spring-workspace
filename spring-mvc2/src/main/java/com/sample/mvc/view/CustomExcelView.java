package com.sample.mvc.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class CustomExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response )throws Exception {
		
		//�𵨿� ����� �� ��������
		String title = (String) model.get("����");
		int buy = (Integer) model.get("����");
		int sell = (Integer) model.get("����");
		int profit = (Integer) model.get("��������");
		
		//���ο� ���� sheet�� �����Ѵ�
		HSSFSheet sheet = workbook.createSheet("sample sheet");
		
		//������Ʈ�� ���ο� ���� �����Ѵ�
		HSSFRow row = sheet.createRow(0);
		
		// ������ �࿡ ���ο� ĭ�� �����ϰ�, ���� �����Ѵ�
		row.createCell(0).setCellValue(title);
		
		HSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("�� ���Ա޾�");
		row1.createCell(1).setCellValue(buy);
		
		HSSFRow row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue("�� ����ݾ�");
		row2.createCell(1).setCellValue(sell);
		
		HSSFRow row3 = sheet.createRow(3);
		row3.createCell(0).setCellValue("�� ��������");
		row3.createCell(1).setCellValue(profit);
		
		//������ �ٿ�ε� �Ǵ� ����� ���������� Ÿ�� �����ϱ�
		response.setContentType("application/octet-stream");
		
		// �ٿ�ε�Ǵ� ÷�������� �̸� �����ϱ�
		response.setHeader("Content-Disposition", "attachment; filename=sample.xls");
	}
	
}
