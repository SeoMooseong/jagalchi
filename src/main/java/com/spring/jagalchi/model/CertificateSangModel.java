package com.spring.jagalchi.model;

public class CertificateSangModel {
	String grdCd;
	String grdNm;
	String jmCd;
	String jmFldNm;
	String pilExamCnt;
	String pilPassCnt;
	String silExamCnt;
	String silPassCnt;
	String statisYy;
	public CertificateSangModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CertificateSangModel(String grdCd, String grdNm, String jmCd, String jmFldNm, String pilExamCnt,
			String pilPassCnt, String silExamCnt, String silPassCnt, String statisYy) {
		super();
		this.grdCd = grdCd;
		this.grdNm = grdNm;
		this.jmCd = jmCd;
		this.jmFldNm = jmFldNm;
		this.pilExamCnt = pilExamCnt;
		this.pilPassCnt = pilPassCnt;
		this.silExamCnt = silExamCnt;
		this.silPassCnt = silPassCnt;
		this.statisYy = statisYy;
	}
	@Override
	public String toString() {
		return "CertificateSangModel [grdCd=" + grdCd + ", grdNm=" + grdNm + ", jmCd=" + jmCd + ", jmFldNm=" + jmFldNm
				+ ", pilExamCnt=" + pilExamCnt + ", pilPassCnt=" + pilPassCnt + ", silExamCnt=" + silExamCnt
				+ ", silPassCnt=" + silPassCnt + ", statisYy=" + statisYy + "]";
	}
	public String getGrdCd() {
		return grdCd;
	}
	public void setGrdCd(String grdCd) {
		this.grdCd = grdCd;
	}
	public String getGrdNm() {
		return grdNm;
	}
	public void setGrdNm(String grdNm) {
		this.grdNm = grdNm;
	}
	public String getJmCd() {
		return jmCd;
	}
	public void setJmCd(String jmCd) {
		this.jmCd = jmCd;
	}
	public String getJmFldNm() {
		return jmFldNm;
	}
	public void setJmFldNm(String jmFldNm) {
		this.jmFldNm = jmFldNm;
	}
	public String getPilExamCnt() {
		return pilExamCnt;
	}
	public void setPilExamCnt(String pilExamCnt) {
		this.pilExamCnt = pilExamCnt;
	}
	public String getPilPassCnt() {
		return pilPassCnt;
	}
	public void setPilPassCnt(String pilPassCnt) {
		this.pilPassCnt = pilPassCnt;
	}
	public String getSilExamCnt() {
		return silExamCnt;
	}
	public void setSilExamCnt(String silExamCnt) {
		this.silExamCnt = silExamCnt;
	}
	public String getSilPassCnt() {
		return silPassCnt;
	}
	public void setSilPassCnt(String silPassCnt) {
		this.silPassCnt = silPassCnt;
	}
	public String getStatisYy() {
		return statisYy;
	}
	public void setStatisYy(String statisYy) {
		this.statisYy = statisYy;
	}
}
