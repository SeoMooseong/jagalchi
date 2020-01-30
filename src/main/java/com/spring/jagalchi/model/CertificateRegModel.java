package com.spring.jagalchi.model;

public class CertificateRegModel {
	String abseManCnt;
	String cnclManCnt;
	String dtlTrendClsifNm;
	String dtlTrendDtlClsifNm;
	String exameeCnt;
	String grdNm;
	String jmNm;
	String passManCnt;
	String recvrCnt;
	String trendDivNm;
	String trendDtlDivNm;
	String numOfRows;
	String pageNo;
	String totalCount;
	public CertificateRegModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CertificateRegModel(String abseManCnt, String cnclManCnt, String dtlTrendClsifNm, String dtlTrendDtlClsifNm,
			String exameeCnt, String grdNm, String jmNm, String passManCnt, String recvrCnt, String trendDivNm,
			String trendDtlDivNm, String numOfRows, String pageNo, String totalCount) {
		super();
		this.abseManCnt = abseManCnt;
		this.cnclManCnt = cnclManCnt;
		this.dtlTrendClsifNm = dtlTrendClsifNm;
		this.dtlTrendDtlClsifNm = dtlTrendDtlClsifNm;
		this.exameeCnt = exameeCnt;
		this.grdNm = grdNm;
		this.jmNm = jmNm;
		this.passManCnt = passManCnt;
		this.recvrCnt = recvrCnt;
		this.trendDivNm = trendDivNm;
		this.trendDtlDivNm = trendDtlDivNm;
		this.numOfRows = numOfRows;
		this.pageNo = pageNo;
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "CertificateRegModel [abseManCnt=" + abseManCnt + ", cnclManCnt=" + cnclManCnt + ", dtlTrendClsifNm="
				+ dtlTrendClsifNm + ", dtlTrendDtlClsifNm=" + dtlTrendDtlClsifNm + ", exameeCnt=" + exameeCnt
				+ ", grdNm=" + grdNm + ", jmNm=" + jmNm + ", passManCnt=" + passManCnt + ", recvrCnt=" + recvrCnt
				+ ", trendDivNm=" + trendDivNm + ", trendDtlDivNm=" + trendDtlDivNm + ", numOfRows=" + numOfRows
				+ ", pageNo=" + pageNo + ", totalCount=" + totalCount + "]";
	}
	public String getAbseManCnt() {
		return abseManCnt;
	}
	public void setAbseManCnt(String abseManCnt) {
		this.abseManCnt = abseManCnt;
	}
	public String getCnclManCnt() {
		return cnclManCnt;
	}
	public void setCnclManCnt(String cnclManCnt) {
		this.cnclManCnt = cnclManCnt;
	}
	public String getDtlTrendClsifNm() {
		return dtlTrendClsifNm;
	}
	public void setDtlTrendClsifNm(String dtlTrendClsifNm) {
		this.dtlTrendClsifNm = dtlTrendClsifNm;
	}
	public String getDtlTrendDtlClsifNm() {
		return dtlTrendDtlClsifNm;
	}
	public void setDtlTrendDtlClsifNm(String dtlTrendDtlClsifNm) {
		this.dtlTrendDtlClsifNm = dtlTrendDtlClsifNm;
	}
	public String getExameeCnt() {
		return exameeCnt;
	}
	public void setExameeCnt(String exameeCnt) {
		this.exameeCnt = exameeCnt;
	}
	public String getGrdNm() {
		return grdNm;
	}
	public void setGrdNm(String grdNm) {
		this.grdNm = grdNm;
	}
	public String getJmNm() {
		return jmNm;
	}
	public void setJmNm(String jmNm) {
		this.jmNm = jmNm;
	}
	public String getPassManCnt() {
		return passManCnt;
	}
	public void setPassManCnt(String passManCnt) {
		this.passManCnt = passManCnt;
	}
	public String getRecvrCnt() {
		return recvrCnt;
	}
	public void setRecvrCnt(String recvrCnt) {
		this.recvrCnt = recvrCnt;
	}
	public String getTrendDivNm() {
		return trendDivNm;
	}
	public void setTrendDivNm(String trendDivNm) {
		this.trendDivNm = trendDivNm;
	}
	public String getTrendDtlDivNm() {
		return trendDtlDivNm;
	}
	public void setTrendDtlDivNm(String trendDtlDivNm) {
		this.trendDtlDivNm = trendDtlDivNm;
	}
	public String getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(String numOfRows) {
		this.numOfRows = numOfRows;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
}
