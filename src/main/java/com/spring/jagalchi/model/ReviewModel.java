package com.spring.jagalchi.model;

import java.sql.Date;

public class ReviewModel {
	int rno; //후기번호
	String rjmcd; //자격증코드
	String rid;  //작성자id
	String rcontent; //후기내용
	Date rdate; //작성일자
	
	public ReviewModel() {	}
	
	public ReviewModel(String rjmcd, String rid, String rcontent, Date rdate) {
		this.rjmcd = rjmcd;
		this.rid = rid;
		this.rcontent = rcontent;
		this.rdate = rdate;
	}
	
	public ReviewModel(int rno, String rjmcd, String rid, String rcontent, Date rdate) {
		this.rno = rno;
		this.rjmcd = rjmcd;
		this.rid = rid;
		this.rcontent = rcontent;
		this.rdate = rdate;
	}
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRjmcd() {
		return rjmcd;
	}
	public void setRjmcd(String rjmcd) {
		this.rjmcd = rjmcd;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
}
