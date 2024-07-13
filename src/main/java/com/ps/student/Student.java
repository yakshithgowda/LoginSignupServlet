package com.ps.student;

public class Student {
	
    private int sid;
	private String name;
	private long phone;
	private String email;
	private String branch;
	private String loc;
	private String password;
	
	public Student() {}
	public Student( int sid,String name, long phone, String email, String branch, String loc, String password) {
		super();
		this.sid=sid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.branch = branch;
		this.loc = loc;
		this.password = password;
	}
	public int getSid() { 
		 return sid; 
		 } 
		 public void setSid(int sid) { 
		 this.sid = sid; 
		 } 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

