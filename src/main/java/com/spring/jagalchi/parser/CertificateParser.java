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
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.spring.jagalchi.model.CertificateDateModel;
import com.spring.jagalchi.model.CertificateModel;

import org.json.*;

public class CertificateParser {
	String oracleURL = "jdbc:oracle:thin:@localhost:1521:xe";
	//String oracleURL = "jdbc:oracle:thin:@192.168.0.21:1521:xe";
	String id="scott";
	String pass = "tiger";

	Connection conn = null;
	public CertificateParser() {

		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = null;
		try {
			jsonobject = (JSONObject)jsonparser.parse(readUrl());
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
		JSONArray item = (JSONArray)items.get("item");
		System.out.println(item);
		
			
			for(int i = 0 ; i < item.size() ; i++) {
				
				if(i < 600) {
					continue;
				}
				String jmcd =	((JSONObject)item.get(i)).get("jmcd").toString();
				
					CertificateModel cm = new CertificateModel(
							(String)((JSONObject)item.get(i)).get("jmcd").toString(), 
							(String)((JSONObject)item.get(i)).get("jmfldnm").toString(), 
							(String)((JSONObject)item.get(i)).get("mdobligfldcd").toString(), 
							(String)((JSONObject)item.get(i)).get("mdobligfldnm").toString(), 
							(String)((JSONObject)item.get(i)).get("obligfldcd").toString(), 
							(String)((JSONObject)item.get(i)).get("obligfldnm").toString(), 
							(String)((JSONObject)item.get(i)).get("qualgbcd").toString(), 
							(String)((JSONObject)item.get(i)).get("qualgbnm").toString(), 
							(String)((JSONObject)item.get(i)).get("seriescd").toString(), 
							(String)((JSONObject)item.get(i)).get("seriesnm").toString()
							
							);
				insertCer(cm);
					
				System.out.println(""+i+" "+cm);
				
			}

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		


	}
	
	public void insertCer(CertificateModel cm) {


		String sql = "insert into certificate(jmcd, jmfldnm, mdobligfldcd, mdobligfldnm, obligfldcd, obligfldnm, qualgbcd, qualgbnm, seriescd, seriesnm) values(?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cm.getJmcd());
			pstmt.setString(2, cm.getJmfldnm());
			pstmt.setString(3, cm.getMdobligfldcd());
			pstmt.setString(4, cm.getMdobligfldnm());
			pstmt.setString(5, cm.getObligfldcd());
			pstmt.setString(6, cm.getObligfldnm());
			pstmt.setString(7, cm.getQualgbcd());
			pstmt.setString(8, cm.getQualgbnm());
			pstmt.setString(9, cm.getSeriescd());
			pstmt.setString(10, cm.getSeriesnm());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private static String readUrl() throws Exception {
		BufferedInputStream reader = null;
		try {
			/*
           URL url = new URL(
                   "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/"
                   + "searchDailyBoxOfficeList.json"
                   + "?key=[서비스키]"
                   + "&targetDt=20150101");*/

			URL url = new URL(
					"http://openapi.q-net.or.kr/api/service/rest/InquiryListNationalQualifcationSVC/getList?_type=json&serviceKey=3QIlWyjnvi9cXAIOdbeqsNnny4vXsjfxnJVY1CcqF0qv%2FRunHsJ7TxkLs9baDpU%2BKdQY2fyWZsCjs73gpm6QDA%3D%3D");


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
			CertificateParser cp = new CertificateParser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
