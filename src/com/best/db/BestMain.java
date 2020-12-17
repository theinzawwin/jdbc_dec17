package com.best.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock stk=new Stock();
		stk.setName("Item 10");
		stk.setCode("293434");
		stk.setPrice(50000.0);
		stk.setQty(10);
		BestMain bm=new BestMain();
		bm.saveWithPrepared(stk);
	}
	
	public void showStock() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdb_17", "root", "root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from stock");
			while(rs.next()) {
				System.out.println("Name: "+rs.getString("name")+", Code: "+rs.getString("code")+", Price: "+rs.getDouble("price")+", Qty:"+rs.getInt("qty"));
			}
			if(con!=null) {
				con.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveStock() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdb_17", "root", "root");
			Statement stmt=con.createStatement();
			String sql="insert into stock(name,code,price,qty) values('Item 4',\"234\",'3000','10');";
			int res=stmt.executeUpdate(sql);
			if(res>0) {
				System.out.println("Insert successfully");
			}
			if(con!=null) {
				con.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateStock() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdb_17", "root", "root");
			Statement stmt=con.createStatement();
			String sql="Update stock set name='Item 23',code=\"7834\" where id=3;";
			int res=stmt.executeUpdate(sql);
			if(res>0) {
				System.out.println("Insert successfully");
			}
			if(con!=null) {
				con.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteStock() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdb_17", "root", "root");
			Statement stmt=con.createStatement();
			String sql="delete from stock where id=3;";
			int res=stmt.executeUpdate(sql);
			if(res>0) {
				System.out.println("Delete successfully");
			}
			if(con!=null) {
				con.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveWithPrepared(Stock stock) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdb_17", "root", "root");
			PreparedStatement pstmt=null;
			String sql="insert into stock(name,code,price,qty) values(?,?,?,?);";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, stock.getName());
			pstmt.setString(2, stock.getCode());
			pstmt.setDouble(3, stock.getPrice());
			pstmt.setInt(4, stock.getQty());
			int res=pstmt.executeUpdate();
			if(res>0) {
				System.out.println("Insert successfully");
			}
			if(con!=null) {
				con.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
