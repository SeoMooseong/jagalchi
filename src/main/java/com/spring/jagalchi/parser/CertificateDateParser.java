package com.spring.jagalchi.parser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.spring.jagalchi.model.CertificateDateModel;
import com.spring.jagalchi.model.CertificateModel;

import org.json.*;

public class CertificateDateParser {
	String oracleURL = "jdbc:oracle:thin:@localhost:1521:xe";
	//String oracleURL = "jdbc:oracle:thin:@192.168.0.21:1521:xe";
	String id="scott";
	String pass = "tiger";

	Connection conn = null;
	ArrayList<String> codes = new ArrayList<String>();
	public CertificateDateParser() {
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver load success");
			conn = DriverManager.getConnection(oracleURL, id, pass);
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		String sql = "select distinct seriescd from certificate order by seriescd";

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
			parse(codes.get(i));
		}
	}
	
	public void parse(String code) {
		
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = null;
		try {
			jsonobject = (JSONObject)jsonparser.parse(readUrl(code));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver load success");
			conn = DriverManager.getConnection(oracleURL, id, pass);
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		JSONObject response = (JSONObject)jsonobject.get("response");
		JSONObject body = (JSONObject)response.get("body");
		JSONObject items = (JSONObject)body.get("items");
		
		JSONArray item = new JSONArray();
		 if (items.get("item") instanceof JSONObject) { 
			 item = new JSONArray();
			 item.add((JSONObject) items.get("item"));
			
		}
		 else{
			 item = (JSONArray)items.get("item");
		 }
		System.out.println(code+" : ~~"+item);
		
			
		for(int i = 0 ; i < item.size() ; i++) {
			
				CertificateDateModel cm = new CertificateDateModel(
						code, 
						((JSONObject)item.get(i)).get("description").toString(), 
						((JSONObject)item.get(i)).get("examenddt").toString(), 
						((JSONObject)item.get(i)).get("examregenddt").toString(), 
						((JSONObject)item.get(i)).get("examregstartdt").toString(), 
						((JSONObject)item.get(i)).get("examstartdt").toString(), 
						((JSONObject)item.get(i)).get("passenddt").toString(), 
						((JSONObject)item.get(i)).get("passstartdt").toString()
						
						);
			insertCer(cm, code);
				
			System.out.println(""+i+" "+cm);
			
		}

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public void insertCer(CertificateDateModel cm, String code) {


		String sql = "insert into certificatedate(seriescd, description, examenddt, examregenddt, examregstartdt, examstartdt, passenddt, passstartdt) values(?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cm.getSeriescd());
			pstmt.setString(2, cm.getDescription());
			pstmt.setString(3, cm.getExamenddt());
			pstmt.setString(4, cm.getExamregenddt());
			pstmt.setString(5, cm.getExamregstartdt());
			pstmt.setString(6, cm.getExamstartdt());
			pstmt.setString(7, cm.getPassenddt());
			pstmt.setString(8, cm.getPassstartdt());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private static String readUrl(String code) throws Exception {
		BufferedInputStream reader = null;
		try {
			URL url = new URL(
"http://openapi.q-net.or.kr/api/service/rest/InquiryTestDatesNationalProfessionalQualificationSVC/getList?_type=json&serviceKey=3QIlWyjnvi9cXAIOdbeqsNnny4vXsjfxnJVY1CcqF0qv%2FRunHsJ7TxkLs9baDpU%2BKdQY2fyWZsCjs73gpm6QDA%3D%3D&seriesCd="+code);


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
			CertificateDateParser cp = new CertificateDateParser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
