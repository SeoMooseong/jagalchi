<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
	function init(){
		data = {"sdate":"20200101",
				"edate":"20200231",
				"flag" : "2"
				};
		$.get( "selectCertiByDate" , data, success)
		
		//$("#mydiv").load("selectCertiByDate",sv);
	}
	function success(data, textStatus, jqXHR){
		$.each(data, function(idx, val) {
			console.log(idx + " " + val.jmfldnm, val.examregstartdt, val.examregenddt);
		});
	}
	$(init);
	</script>
	
	  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
</head>
<body>

<div class="container">
  <h2>Large Modal</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Large Modal</button>
</div>
<jsp:include page="detail.jsp"></jsp:include>
</body>
</html>
