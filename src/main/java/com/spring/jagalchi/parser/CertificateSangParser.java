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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.spring.jagalchi.model.CertificateDateModel;
import com.spring.jagalchi.model.CertificateModel;
import com.spring.jagalchi.model.CertificateRegModel;
import com.spring.jagalchi.model.CertificateSangModel;

import org.json.*;

public class CertificateSangParser {
	//String oracleURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String oracleURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String id="scott";
	String pass = "tiger";

	Connection conn = null;
	public CertificateSangParser() {

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

		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject = null;
		
		try {
			jsonobject = (JSONObject)jsonparser.parse(readUrl());
			System.out.println(jsonobject);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		JSONObject response = (JSONObject)jsonobject.get("response");
		JSONObject body = (JSONObject)response.get("body");
		JSONObject items = (JSONObject)body.get("items");
		JSONArray item = (JSONArray)items.get("item");
		System.out.println(item);
		
		for(int i = 0 ; i < item.size() ; i++) {
			/*
			if(i < 598) {
				continue;
			}*/
			String jmcd =	((JSONObject)item.get(i)).get("jmcd").toString();
			
			CertificateSangModel cm = new CertificateSangModel(
					(String)((JSONObject)item.get(i)).get("grdCd").toString(), 
					(String)((JSONObject)item.get(i)).get("grdNm").toString(), 
					(String)((JSONObject)item.get(i)).get("jmCd").toString(), 
					(String)((JSONObject)item.get(i)).get("jmFldNm").toString(), 
					(String)((JSONObject)item.get(i)).get("pilExamCnt").toString(), 
					(String)((JSONObject)item.get(i)).get("pilPassCnt").toString(), 
					(String)((JSONObject)item.get(i)).get("silExamCnt").toString(), 
					(String)((JSONObject)item.get(i)).get("silPassCnt").toString(), 
					(String)((JSONObject)item.get(i)).get("statisYy").toString()
					
					);
			//insertCer(cm);
				
			System.out.println(""+i+" "+cm);
			
		}
		

	}
	
	public void insertCer(CertificateSangModel cm) {


		String sql = "insert into certificateSang(grdCd, grdNm, jmCd, jmFldNm, pilExamCnt, pilPassCnt, silExamCnt, silPassCnt, statisYy) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cm.getGrdCd());
			pstmt.setString(2, cm.getGrdNm());
			pstmt.setString(3, cm.getJmCd());
			pstmt.setString(4, cm.getJmFldNm());
			pstmt.setString(5, cm.getPilExamCnt());
			pstmt.setString(6, cm.getPilPassCnt());
			pstmt.setString(7, cm.getSilExamCnt());
			pstmt.setString(8, cm.getSilPassCnt());
			pstmt.setString(9, cm.getStatisYy());
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
"http://openapi.q-net.or.kr/api/service/rest/InquiryAcquStatisSVC/getSangSiList"
			+"?_type=json&baseYY=2018&ServiceKey=h9Rl76R0OAPihVKvN2LnodougR42HzY43KMDkAZVvqs1eNMFXlAn086yNNz51LBJI7BYo7E2JkWjo6tpgFS1nQ%3D%3D");
			


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
			CertificateSangParser cp = new CertificateSangParser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
