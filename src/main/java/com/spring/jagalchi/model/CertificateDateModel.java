package com.spring.jagalchi.model;

public class CertificateDateModel {
	String seriescd;
	String description;
	String examenddt;
	String examregenddt;
	String examregstartdt;
	String examstartdt;
	String passenddt;
	String passstartdt;
	public CertificateDateModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CertificateDateModel(String seriescd, String description, String examenddt, String examregenddt,
			String examregstartdt, String examstartdt, String passenddt, String passstartdt) {
		super();
		this.seriescd = seriescd;
		this.description = description;
		this.examenddt = examenddt;
		this.examregenddt = examregenddt;
		this.examregstartdt = examregstartdt;
		this.examstartdt = examstartdt;
		this.passenddt = passenddt;
		this.passstartdt = passstartdt;
	}
	@Override
	public String toString() {
		return "CertificateModel [seriescd=" + seriescd + ", description=" + description + ", examenddt=" + examenddt
				+ ", examregenddt=" + examregenddt + ", examregstartdt=" + examregstartdt + ", examstartdt="
				+ examstartdt + ", passenddt=" + passenddt + ", passstartdt=" + passstartdt + "]";
	}
	public String getSeriescd() {
		return seriescd;
	}
	public void setSeriescd(String seriescd) {
		this.seriescd = seriescd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExamenddt() {
		return examenddt;
	}
	public void setExamenddt(String examenddt) {
		this.examenddt = examenddt;
	}
	public String getExamregenddt() {
		return examregenddt;
	}
	public void setExamregenddt(String examregenddt) {
		this.examregenddt = examregenddt;
	}
	public String getExamregstartdt() {
		return examregstartdt;
	}
	public void setExamregstartdt(String examregstartdt) {
		this.examregstartdt = examregstartdt;
	}
	public String getExamstartdt() {
		return examstartdt;
	}
	public void setExamstartdt(String examstartdt) {
		this.examstartdt = examstartdt;
	}
	public String getPassenddt() {
		return passenddt;
	}
	public void setPassenddt(String passenddt) {
		this.passenddt = passenddt;
	}
	public String getPassstartdt() {
		return passstartdt;
	}
	public void setPassstartdt(String passstartdt) {
		this.passstartdt = passstartdt;
	}
	
	
}
