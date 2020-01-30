package com.spring.jagalchi.model;

public class StatisticsModel {
	String jmnm;
	double pil;
	String pilColor;
	double sil;
	String silColor;
	int total;
	public StatisticsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatisticsModel(String jmnm, double pil, String pilColor, double sil, String silColor, int total) {
		super();
		this.jmnm = jmnm;
		this.pil = pil;
		this.pilColor = pilColor;
		this.sil = sil;
		this.silColor = silColor;
		this.total = total;
	}
	@Override
	public String toString() {
		return "StatisticsModel [jmnm=" + jmnm + ", pil=" + pil + ", pilColor=" + pilColor + ", sil=" + sil
				+ ", silColor=" + silColor + ", total=" + total + "]";
	}
	public String getJmnm() {
		return jmnm;
	}
	public void setJmnm(String jmnm) {
		this.jmnm = jmnm;
	}
	public double getPil() {
		return pil;
	}
	public void setPil(double pil) {
		this.pil = pil;
	}
	public String getPilColor() {
		return pilColor;
	}
	public void setPilColor(String pilColor) {
		this.pilColor = pilColor;
	}
	public double getSil() {
		return sil;
	}
	public void setSil(double sil) {
		this.sil = sil;
	}
	public String getSilColor() {
		return silColor;
	}
	public void setSilColor(String silColor) {
		this.silColor = silColor;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
