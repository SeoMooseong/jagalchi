package com.spring.jagalchi.model;

public class CDTO {

	String jmcd;			//종목코드
	String jmfldnm;			//종목이름
	String mdobligfldcd;	//중직무분야코드
	String mdobligfldnm;	//중직무분야이름
	String obligfldcd;		//대직무분야코드
	String obligfldnm;		//대직무분야명
	String qualgbcd;		//자격구분
	String qualgbnm;		//자격구분명
	String seriescd;		//계열코드
	String seriesnm;		//계열명
	String description;		//회차
	String examenddt;		//시험종료일자
	String examregenddt;	//원서접수종료일자
	String examregstartdt;	//원서접수시작일자
	String examstartdt;		//시험시작일자
	String passenddt;		//합격자발표일
	String passstartdt;		//합격자발표종료일
	public CDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CDTO(String jmcd, String jmfldnm, String mdobligfldcd, String mdobligfldnm, String obligfldcd,
			String obligfldnm, String qualgbcd, String qualgbnm, String seriescd, String seriesnm, String description,
			String examenddt, String examregenddt, String examregstartdt, String examstartdt, String passenddt,
			String passstartdt) {
		super();
		this.jmcd = jmcd;
		this.jmfldnm = jmfldnm;
		this.mdobligfldcd = mdobligfldcd;
		this.mdobligfldnm = mdobligfldnm;
		this.obligfldcd = obligfldcd;
		this.obligfldnm = obligfldnm;
		this.qualgbcd = qualgbcd;
		this.qualgbnm = qualgbnm;
		this.seriescd = seriescd;
		this.seriesnm = seriesnm;
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
		return "CertificateModel [jmcd=" + jmcd + ", jmfldnm=" + jmfldnm + ", mdobligfldcd=" + mdobligfldcd
				+ ", mdobligfldnm=" + mdobligfldnm + ", obligfldcd=" + obligfldcd + ", obligfldnm=" + obligfldnm
				+ ", qualgbcd=" + qualgbcd + ", qualgbnm=" + qualgbnm + ", seriescd=" + seriescd + ", seriesnm="
				+ seriesnm + ", description=" + description + ", examenddt=" + examenddt + ", examregenddt="
				+ examregenddt + ", examregstartdt=" + examregstartdt + ", examstartdt=" + examstartdt + ", passenddt="
				+ passenddt + ", passstartdt=" + passstartdt + "]";
	}
	public String getJmcd() {
		return jmcd;
	}
	public void setJmcd(String jmcd) {
		this.jmcd = jmcd;
	}
	public String getJmfldnm() {
		return jmfldnm;
	}
	public void setJmfldnm(String jmfldnm) {
		this.jmfldnm = jmfldnm;
	}
	public String getMdobligfldcd() {
		return mdobligfldcd;
	}
	public void setMdobligfldcd(String mdobligfldcd) {
		this.mdobligfldcd = mdobligfldcd;
	}
	public String getMdobligfldnm() {
		return mdobligfldnm;
	}
	public void setMdobligfldnm(String mdobligfldnm) {
		this.mdobligfldnm = mdobligfldnm;
	}
	public String getObligfldcd() {
		return obligfldcd;
	}
	public void setObligfldcd(String obligfldcd) {
		this.obligfldcd = obligfldcd;
	}
	public String getObligfldnm() {
		return obligfldnm;
	}
	public void setObligfldnm(String obligfldnm) {
		this.obligfldnm = obligfldnm;
	}
	public String getQualgbcd() {
		return qualgbcd;
	}
	public void setQualgbcd(String qualgbcd) {
		this.qualgbcd = qualgbcd;
	}
	public String getQualgbnm() {
		return qualgbnm;
	}
	public void setQualgbnm(String qualgbnm) {
		this.qualgbnm = qualgbnm;
	}
	public String getSeriescd() {
		return seriescd;
	}
	public void setSeriescd(String seriescd) {
		this.seriescd = seriescd;
	}
	public String getSeriesnm() {
		return seriesnm;
	}
	public void setSeriesnm(String seriesnm) {
		this.seriesnm = seriesnm;
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
