package com.best.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.best.model.Grade;
import com.best.model.Student;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentMain studentMain=new StudentMain();
		List<Student> stdList=studentMain.getStudent();
		System.out.println("Student List");
		stdList.forEach(s->{
			System.out.println("Id "+s.getId()+", Name:"+s.getName()+", Nrc:"+s.getNrc()+",Grade="+s.getGradeName());
		});
	}
	public void showGrade() {
		List<Grade> gList=getGradeList();
		System.out.println("Grade List");
		gList.forEach(s->{
			System.out.println("Id "+s.getId()+", Name:"+s.getName());
		});
	}
	public List<Grade> getGradeList(){
		try {
			List<Grade> gradeList=new ArrayList<Grade>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdb_17", "root", "root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from grade");
			while(rs.next()) {
				//System.out.println("Name: "+rs.getString("name")+", Code: "+rs.getString("code")+", Price: "+rs.getDouble("price")+", Qty:"+rs.getInt("qty"));
				gradeList.add(new Grade(rs.getInt("id"), rs.getString("name")));
			}
			if(con!=null) {
				con.close();
			}
			return gradeList;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public List<Student> getStudent(){
		try {
			List<Student> studentList=new ArrayList<Student>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdb_17", "root", "root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select s.*,g.name as grade_name from student s left join grade g on s.grade_id=g.id;");
			while(rs.next()) {
				//System.out.println("Name: "+rs.getString("name")+", Code: "+rs.getString("code")+", Price: "+rs.getDouble("price")+", Qty:"+rs.getInt("qty"));
				studentList.add(new Student(rs.getInt("id"), rs.getString("rollno"),rs.getString("name"),rs.getString("email"),rs.getString("nrc"),rs.getInt("grade_id"),rs.getString("grade_name")));
			}
			if(con!=null) {
				con.close();
			}
			return studentList;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
