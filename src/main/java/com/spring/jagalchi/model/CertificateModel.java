package com.spring.jagalchi.model;

public class CertificateModel {
	String jmcd;
	String jmfldnm;
	String mdobligfldcd;
	String mdobligfldnm;
	String obligfldcd;
	String obligfldnm;
	String qualgbcd;
	String qualgbnm;
	String seriescd;
	String seriesnm;
	public CertificateModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CertificateModel(String jmcd, String jmfldnm, String mdobligfldcd, String mdobligfldnm, String obligfldcd,
			String obligfldnm, String qualgbcd, String qualgbnm, String seriescd, String seriesnm) {
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
	}
	@Override
	public String toString() {
		return "CertificateModel [jmcd=" + jmcd + ", jmfldnm=" + jmfldnm + ", mdobligfldcd=" + mdobligfldcd
				+ ", mdobligfldnm=" + mdobligfldnm + ", obligfldcd=" + obligfldcd + ", obligfldnm=" + obligfldnm
				+ ", qualgbcd=" + qualgbcd + ", qualgbnm=" + qualgbnm + ", seriescd=" + seriescd + ", seriesnm="
				+ seriesnm + "]";
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
	
	
	
	
	
}
