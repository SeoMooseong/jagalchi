<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
	function init(){
		data = {"sdate":"20200101",
				"edate":"20200231"
				};
		$.get( "selectCertiByDate" , data, success)
		
		//$("#mydiv").load("selectCertiByDate",sv);
	}
	function success(data, textStatus, jqXHR){
		$.each(data, function(idx, val) {
			console.log(idx + " " + val.jmfldnm);
		});
	}
	$(init);
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
	<div id="mydiv">
		
	</div>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
