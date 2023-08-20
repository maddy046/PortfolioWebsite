package com.pojo;

public class Project {
	private int sno;
	private String fileName;
	
	
	public Project() {
		
	}
	public Project(int sno, String fileName) {
		super();
		this.sno = sno;
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "Project [sno=" + sno + ", fileName=" + fileName + "]";
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
