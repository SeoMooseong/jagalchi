<%@ page import="org.json.simple.*"%>
<%@ page language="java" contentType="text/event-stream; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.spring.jagalchi.*"%>
    <%
    /*
    JSONArray arry = sdao.selectStock();
    out.print(arry.toString());
    
	JSONObject ob1 = new JSONObject();
	JSONObject ob2 = new JSONObject();
	JSONObject ob3 = new JSONObject();
	
	
	ob1.put("stock", (int)(Math.random()*99+1));
	ob2.put("stock", (int)(Math.random()*99+1));
	ob3.put("stock", (int)(Math.random()*99+1));
	arry.add(ob1);
	arry.add(ob2);
	arry.add(ob3);
	*/
	String str;
	str = String.format("data:%s\n\n", request.getAttribute("jarr"));
	out.print("retry:10\n");
	out.print(str);
    
    %>