package com.ps.App;

import java.io.IOException;
import java.io.PrintWriter;

import com.ps.StudentDAO.copy.StudentDAO;
import com.ps.student.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login2")

public class LoginServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			 String id=req.getParameter("id");
			 String password=req.getParameter("password");
			 PrintWriter out=resp.getWriter();
			 int sid=Integer.parseInt(id);
			 StudentDAO sdao=new StudentDAO();
			 Student s=new Student();
			 s=sdao.getStudent(sid, password);
			 
			 if(s!=null) {
				 out.println("<h1>welcome "+s.getName()+"</h1>");
				
			 }
			 else {
				 out.println("<h1>Invalid Id or Password</h1>");
			 }
			 
			 
		}
		
	}


