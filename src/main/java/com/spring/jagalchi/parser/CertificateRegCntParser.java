package com.spring.jagalchi.parser;
//h9Rl76R0OAPihVKvN2LnodougR42HzY43KMDkAZVvqs1eNMFXlAn086yNNz51LBJI7BYo7E2JkWjo6tpgFS1nQ%3D%3D

import java.io.BufferedInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.spring.jagalchi.model.CertificateRegCntModel;

public class CertificateRegCntParser {
	//String oracleURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String oracleURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id="scott";
	String pass = "tiger";

	Connection conn = null;
	ArrayList<String> codes = new ArrayList<String>();
	public CertificateRegCntParser() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver load success");
			conn = DriverManager.getConnection(oracleURL, id, pass);
		}catch (SQLException e1) {
			e1.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		String sql = "select distinct jmcd from certificate order by jmcd";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				codes.add(rs.getString(1));
			}
			rs.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}/*
		for(int i = 0 ; i< codes.size() ; i++) {
			System.out.println(Integer.toString(Integer.parseInt(codes.get(i))));
		}*/
		for(int i = 0 ; i< codes.size() ; i++) {
			parse(codes.get(i), true);
			parse(codes.get(i), false);
		}
	}

	public void parse(String code, boolean flag) {

		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = null;
		
		try {
			jsonobject = (JSONObject)jsonparser.parse(readUrl(code, flag));
		} catch (ParseException e2) {
			e2.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver load success");
			conn = DriverManager.getConnection(oracleURL, id, pass);
		}catch (SQLException e1) {
			e1.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println((JSONObject)jsonobject.get("response"));
		JSONObject response = (JSONObject)jsonobject.get("response");
		JSONObject body = (JSONObject)response.get("body");
		JSONObject items = null;

		try {
			items = (JSONObject)body.get("items");
		}catch(Exception e){
			System.out.println(e.getMessage());
			return;
		}

		JSONArray item = new JSONArray();
		if (items.get("item") instanceof JSONObject) { 
			item = new JSONArray();
			item.add((JSONObject) items.get("item"));

		}
		else{
			item = (JSONArray)items.get("item");
		}
		System.out.println(code+" : ~~"+item);

		if(flag) {
			for(int i = 0 ; i < item.size() ; i++) {

				CertificateRegCntModel cm = new CertificateRegCntModel(
						code, 
						(((JSONObject)item.get(i)).get("jmnm") == null ? "" : ((JSONObject)item.get(i)).get("jmnm")).toString(), 
						(((JSONObject)item.get(i)).get("ilrcnt1") == null ? "" : ((JSONObject)item.get(i)).get("ilrcnt1")).toString(), 
						(((JSONObject)item.get(i)).get("ilrcnt2") == null ? "" : ((JSONObject)item.get(i)).get("ilrcnt2")).toString(), 
						(((JSONObject)item.get(i)).get("ilrcnt3") == null ? "" : ((JSONObject)item.get(i)).get("ilrcnt3")).toString(), 
						(((JSONObject)item.get(i)).get("ilrcnt4") == null ? "" : ((JSONObject)item.get(i)).get("ilrcnt4")).toString(), 
						(((JSONObject)item.get(i)).get("ilpcnt1") == null ? "" : ((JSONObject)item.get(i)).get("ilpcnt1")).toString(), 
						(((JSONObject)item.get(i)).get("ilpcnt2") == null ? "" : ((JSONObject)item.get(i)).get("ilpcnt2")).toString(), 
						(((JSONObject)item.get(i)).get("ilpcnt3") == null ? "" : ((JSONObject)item.get(i)).get("ilpcnt3")).toString(), 
						(((JSONObject)item.get(i)).get("ilpcnt4") == null ? "" : ((JSONObject)item.get(i)).get("ilpcnt4")).toString()
						);
				insertCer(cm, code);

				System.out.println(""+i+" "+cm);

			}
		}else {
			for(int i = 0 ; i < item.size() ; i++) {

				CertificateRegCntModel cm = new CertificateRegCntModel(
						(((JSONObject)item.get(i)).get("ilrcnt1") == null ? "" : ((JSONObject)item.get(i)).get("ilrcnt1")).toString(), 
						(((JSONObject)item.get(i)).get("ilrcnt2") == null ? "" : ((JSONObject)item.get(i)).get("ilrcnt2")).toString(), 
						(((JSONObject)item.get(i)).get("ilrcnt3") == null ? "" : ((JSONObject)item.get(i)).get("ilrcnt3")).toString(), 
						(((JSONObject)item.get(i)).get("ilrcnt4") == null ? "" : ((JSONObject)item.get(i)).get("ilrcnt4")).toString(), 
						(((JSONObject)item.get(i)).get("ilpcnt1") == null ? "" : ((JSONObject)item.get(i)).get("ilpcnt1")).toString(), 
						(((JSONObject)item.get(i)).get("ilpcnt2") == null ? "" : ((JSONObject)item.get(i)).get("ilpcnt2")).toString(), 
						(((JSONObject)item.get(i)).get("ilpcnt3") == null ? "" : ((JSONObject)item.get(i)).get("ilpcnt3")).toString(), 
						(((JSONObject)item.get(i)).get("ilpcnt4") == null ? "" : ((JSONObject)item.get(i)).get("ilpcnt4")).toString()
						);
				updateCer(cm, code);

				System.out.println(""+i+" "+cm);

			}
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void insertCer(CertificateRegCntModel cm, String code) {


		String sql = "insert into certificateregcnt(jmcd, jmnm, piilrcnt1, piilrcnt2, piilrcnt3, piilrcnt4, piilpcnt1, piilpcnt2, piilpcnt3, piilpcnt4) values(?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cm.getJmcd());
			pstmt.setString(2, cm.getJmnm());
			pstmt.setString(3, cm.getPiilrcnt1());
			pstmt.setString(4, cm.getPiilrcnt2());
			pstmt.setString(5, cm.getPiilrcnt3());
			pstmt.setString(6, cm.getPiilrcnt4());
			pstmt.setString(7, cm.getPiilpcnt1());
			pstmt.setString(8, cm.getPiilpcnt2());
			pstmt.setString(9, cm.getPiilpcnt3());
			pstmt.setString(10, cm.getPiilpcnt4());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void updateCer(CertificateRegCntModel cm, String code) {

		String sql = "update certificateregcnt set siilrcnt1 = ?, siilrcnt2 = ?, siilrcnt3 = ?, siilrcnt4 = ?,"
										+ "siilpcnt1 = ?, siilpcnt2 = ?, siilpcnt3 = ?, siilpcnt4 = ?"
										+ "where jmcd = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cm.getSiilrcnt1());
			pstmt.setString(2, cm.getSiilrcnt2());
			pstmt.setString(3, cm.getSiilrcnt3());
			pstmt.setString(4, cm.getSiilrcnt4());
			pstmt.setString(5, cm.getSiilpcnt1());
			pstmt.setString(6, cm.getSiilpcnt2());
			pstmt.setString(7, cm.getSiilpcnt3());
			pstmt.setString(8, cm.getSiilpcnt4());
			pstmt.setString(9, code);
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private static String readUrl(String code, boolean flag) throws Exception {
		BufferedInputStream reader = null;
		try {
			URL url = null;
			if(flag) {
				url = new URL(
						"http://openapi.q-net.or.kr/api/service/rest/InquiryStatSVC/getEventYearPiList"
								+"?_type=json&baseYY=2018&serviceKey=xhuWHchCXW3inWGbrk5MaVf6QjDeeYCFL0xQxkhYGHooJeViPkr%2FAYUmu1W79rr3ljDdrkL7NnL7SQ4Pf9TG%2Fw%3D%3D&jmCd=" + code);
			}else {
				url = new URL(
						"http://openapi.q-net.or.kr/api/service/rest/InquiryStatSVC/getEventYearSiList"
								+"?_type=json&baseYY=2018&serviceKey=xhuWHchCXW3inWGbrk5MaVf6QjDeeYCFL0xQxkhYGHooJeViPkr%2FAYUmu1W79rr3ljDdrkL7NnL7SQ4Pf9TG%2Fw%3D%3D&jmCd=" + code);
			}

			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while( (i = reader.read(b)) != -1){
				buffer.append(new String(b, 0, i));
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public static void main(String[] args) {
		try {
			CertificateRegCntParser cp = new CertificateRegCntParser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
