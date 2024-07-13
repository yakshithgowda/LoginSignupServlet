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
@WebServlet("/signup2")
public class SignupServlet extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 String name=req.getParameter("name");
 System.out.println(name);
 String phn=req.getParameter("phone");
 String email=req.getParameter("email");
 String branch=req.getParameter("branch");
 String loc=req.getParameter("loc");
 String password=req.getParameter("password");
 String confirm=req.getParameter("confirm");
 PrintWriter out=resp.getWriter();
 StudentDAO sdao=new StudentDAO();
 Student s=new Student();
 long phone=Long.parseLong(phn);
 boolean res=false;
 
 if(password.equals(confirm))
 {
 res=StudentDAO.signup(name, phone, email, branch, loc, password);
 if(res)
 {
	 out.println("<h1>Data added</h1>");
	 System.out.println("your sid is"+s.getSid());
	 
 }
 
 else {
 out.println("<h1>Failed to save data</h1>");
 }
 }
 else
 {
 out.println("<h1>Password mismatched. Please try again</h1>");
 }
}
}