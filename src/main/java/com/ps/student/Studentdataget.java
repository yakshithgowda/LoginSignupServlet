package com.ps.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.ps.StudentDAO.copy.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Studentdataget extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		StudentDAO sdao=new StudentDAO();
		List<Student>l=sdao.getStudent();
		if(l!=null) {
			for(Student s:l) {
			out.println("<table>"
					+"<tr>"
					+"<td>"+s.getSid()+"</td>"
					+"<td>"+s.getName()+"</td>"
					+"<td>"+s.getPhone()+"</td>"
					+"<td>"+s.getEmail()+"</td>"
					+"<td>"+s.getBranch()+"</td>"
					+"<td>"+s.getLoc()+"</td>"
					+"<td><a href=\"#\">Edit</a></td>"
					+"<td><a href=\"#\">Delete</a></td>"
					+"</tr>"
					+"</table>"
					);
			
		}
		
		
	}
		else {
			out.println("<h1>data not found</h1>");
		}
			
		}

}

