package com.sample.portal.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class UserForm {
	@NotBlank(message = "���̵�� �ʼ��Է� ���Դϴ�.")
	@Pattern(regexp = "^[a-zA-Z0-9]{6,}$", message = "���̵�� 6�����̻�, ���� ��ҹ���/���ڸ� �Է��ϼ���")
	private String id;
	
	@NotBlank(message = "�̸��� �ʼ��Է� ���Դϴ�")
	@Pattern(regexp = "^[��-�R]{2,}$", message = "�̸��� 2���� �̻�, �ѱ۷� �Է��ϼ���")
	private String name;
	
	@NotBlank(message = "��й�ȣ�� �ʼ��Է� ���Դϴ�")
	@Pattern(regexp = "^[a-zA-Z0-9]{8,}$", message = "��й�ȣ�� 8���� �̻�, ���� ��ҹ���/���ڸ� �Է��ϼ���")
	private String password;
	
	@NotBlank(message = "�̸����� �ʼ��Է� ���Դϴ�")
	@Email(message = "��ȿ�� �̸��� ������ �ƴմϴ�")
	private String email;
	
	@NotBlank(message = "��ȭ��ȣ�� �ʼ��Է� ���Դϴ�")
	@Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$", message = "��ȿ�� ��ȭ��ȣ ������ �ƴմϴ�.")	
	private String phone;
	
	@NotNull(message = "���̴� �ʼ� �Է� ���Դϴ�.")
	@Min(value = 19, message = "���԰��� ������ 19�� �̻� �����մϴ�.")
	private int age;
	
	@NotNull(message = "������ �ʼ� �Է°� �Դϴ�")
	@Past(message = "������ ���� ��¥ ���� ������ �Է��ϼ���")
	private Date birth;
	
	private MultipartFile photofile; // ÷�������� ��� Ŭ����
	
	public UserForm() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public MultipartFile getPhotofile() {
		return photofile;
	}
	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}
	
	
}
