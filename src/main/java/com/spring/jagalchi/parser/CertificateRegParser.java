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

import org.json.*;

public class CertificateRegParser {
	//String oracleURL = "jdbc:oracle:thin:@localhost:1521:orcl";
	String oracleURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String id="scott";
	String pass = "tiger";

	Connection conn = null;
	public CertificateRegParser() {

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
		
		String sql = "select distinct jmcd from certificate";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JSONParser jsonparser = new JSONParser();
				JSONObject jsonobject = null;
				try {
					jsonobject = (JSONObject)jsonparser.parse(readUrl(rs.getString(1)));
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
				/*
					for(int i = 0 ; i < item.size() ; i++) {
						
						if(i < 598) {
							continue;
						}
						String jmcd =	((JSONObject)item.get(i)).get("jmcd").toString();
						
							CertificateRegModel cm = new CertificateRegModel(
									(String)((JSONObject)item.get(i)).get("abseManCnt").toString(), 
									(String)((JSONObject)item.get(i)).get("cnclManCnt").toString(), 
									(String)((JSONObject)item.get(i)).get("dtlTrendClsifNm").toString(), 
									(String)((JSONObject)item.get(i)).get("dtlTrendDtlClsifNm").toString(), 
									(String)((JSONObject)item.get(i)).get("exameeCnt").toString(), 
									(String)((JSONObject)item.get(i)).get("grdNm").toString(), 
									(String)((JSONObject)item.get(i)).get("jmNm").toString(), 
									(String)((JSONObject)item.get(i)).get("passManCnt").toString(), 
									(String)((JSONObject)item.get(i)).get("recvrCnt").toString(), 
									(String)((JSONObject)item.get(i)).get("trendDivNm").toString()
									(String)((JSONObject)item.get(i)).get("trendDtlDivNm").toString(), 
									(String)((JSONObject)item.get(i)).get("numOfRows").toString(), 
									(String)((JSONObject)item.get(i)).get("pageNo").toString(), 
									(String)((JSONObject)item.get(i)).get("totalCount").toString()
									
									);
						//insertCer(cm);
							
						System.out.println(""+i+" "+cm);
						
					}

					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				*/
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e1.printStackTrace();
		}
	}
	
	public void insertCer(CertificateRegModel cm) {


		String sql = "insert into certificatereg(abseManCnt, cnclManCnt, dtlTrendClsifNm, dtlTrendDtlClsifNm, exameeCnt, grdNm, jmNm, passManCnt, recvrCnt, trendDivNm, trendDtlDivNm, numOfRows, pageNo, totalCount) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cm.getAbseManCnt());
			pstmt.setString(2, cm.getCnclManCnt());
			pstmt.setString(3, cm.getDtlTrendClsifNm());
			pstmt.setString(4, cm.getDtlTrendDtlClsifNm());
			pstmt.setString(5, cm.getExameeCnt());
			pstmt.setString(6, cm.getGrdNm());
			pstmt.setString(7, cm.getJmNm());
			pstmt.setString(8, cm.getPassManCnt());
			pstmt.setString(9, cm.getRecvrCnt());
			pstmt.setString(10, cm.getTrendDivNm());
			pstmt.setString(11, cm.getTrendDtlDivNm());
			pstmt.setString(12, cm.getNumOfRows());
			pstmt.setString(13, cm.getPageNo());
			pstmt.setString(14, cm.getTotalCount());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private static String readUrl(String code) throws Exception {
		BufferedInputStream reader = null;
		System.out.println(code);
		try {
			/*
           URL url = new URL(
                   "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/"
                   + "searchDailyBoxOfficeList.json"
                   + "?key=[서비스키]"
                   + "&targetDt=20150101");*/

			URL url = new URL(
					"http://openapi.q-net.or.kr/api/service/rest/InquiryRecpTotPtcondSVC/getTrendList?_type=json&"
			+"baseYY=2018&jmCd=1320&trendDiv=01&pageNo=1&numOfRows=10&ServiceKey=h9Rl76R0OAPihVKvN2LnodougR42HzY43KMDkAZVvqs1eNMFXlAn086yNNz51LBJI7BYo7E2JkWjo6tpgFS1nQ%3D%3D");
			


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
			CertificateRegParser cp = new CertificateRegParser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
