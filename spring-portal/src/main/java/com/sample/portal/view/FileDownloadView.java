package com.sample.portal.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String directory = (String) model.get("directory");
			String filename = (String) model.get("filename");
			
			//���� �������� Ÿ���� �����Ѵ�
			// application/octet-stream�� ��ü���� ���� Ÿ���� �˼� ���� ���̳ʸ�������
			// �������� ���������� �����ϴ� �⺻��
			//�ַ� ÷�������� ���������� ���
			response.setContentType("application/octet-stream");
			
			//���� ��� ���� �����Ѵ�.
			// Content-Disposition ��������� �������� ���޵Ǵ�
			// ���ϸ��� ������ �� ���ȴ�.
			//"Content-Disposition", "attachment; filename=a.pdf" �� ���� �������� ������
			// ���� �ٿ�ε�� ������ "���� �ٿ�ε�" ��ȭ���ڰ� ��Ÿ������ �ϰų�,
			// ũ�� ���� ��쿣 ������ ��� �ٿ�ε�ȴ�.
			response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename, "utf-8"));
			
			
			//÷�������� �������� ����������
			// 1. ������ ���͸����� �ش� ������ �о���� ��Ʈ���� �����Ѵ�
			// 2. ���� ��ü���� �������� �������� ��Ʈ���� ȹ���Ѵ�
			// 3. �����Ѵ�
			InputStream in = new FileInputStream(new File(directory,filename));
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(in, out);
	}
}
