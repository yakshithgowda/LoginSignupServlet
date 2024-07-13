package com.ps.StudentDAO.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ps.student.Connector;
import com.ps.student.Student;

public class StudentDAO {
	public static boolean signup(String name,long phone,String email,String branch,String loc,String password)
	{
		Connection con=null;
		PreparedStatement ps=null;
		String query="insert into college(name,phone,email,branch,loc,password) values(?,?,?,?,?,?)";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setLong(2, phone);
			ps.setString(3, email);
			ps.setString(4, branch);
			ps.setString(5,loc);
			ps.setString(6, password);
			res=ps.executeUpdate();
			
		} catch (ClassNotFoundException|SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(res>0){
			return true;
		}
		else {
		return false;
		}
	}
	public static Student getStudent(long phone) {
		Student s = null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	    String query="select * from college where phone=?";
	    try {
	    	con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			rs=ps.executeQuery();
			if(rs.next()) {
				s= new Student();
				s.setSid(rs.getInt(1));
			}
	    
			
		} catch (ClassNotFoundException |SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    return s;
		
	}
	public static Student getStudent(int sid,String password) {
		Student s = null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	    String query="select * from college where sid=? and password=?";
	    try {
	    	con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1,sid);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next()) {
				s= new Student();
				s.setSid(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPhone(rs.getLong(3));
				s.setEmail(rs.getString(4));
				s.setBranch(rs.getString(5));
				s.setLoc(rs.getString(6));
				s.setPassword(rs.getString(7));
				
			}
	    
			
		} catch (ClassNotFoundException |SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    return s;
		
	}
	public static List getStudent() {
		ArrayList<Student> studentList=new ArrayList();
		Student s = null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	    String query="select * from college ";
	    try {
	    	con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				s= new Student();
				s.setSid(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPhone(rs.getLong(3));
				s.setEmail(rs.getString(4));
				s.setBranch(rs.getString(5));
				s.setLoc(rs.getString(6));
				s.setPassword(rs.getString(7));
				studentList.add(s);
				
			}
	    
			
		} catch (ClassNotFoundException |SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    return studentList;
		
	}
	
}


