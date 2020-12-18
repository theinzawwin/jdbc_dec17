package com.best.model;

public class Student {

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	private Integer id;
	private String rollno;
	private String name;
	private String email;
	private String nrc;
	private Integer gradeId;
	private String gradeName;
	public Student() {
		
	}
	public Student(Integer id, String rollno, String name, String email, String nrc, Integer gradeId) {
		super();
		this.id = id;
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.nrc = nrc;
		this.gradeId = gradeId;
	}
	public Student(Integer id, String rollno, String name, String email, String nrc, Integer gradeId,
			String gradeName) {
		super();
		this.id = id;
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.nrc = nrc;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}
	
}
