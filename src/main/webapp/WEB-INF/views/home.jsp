<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.js"></script>
	
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style>
		::-webkit-scrollbar {
            width: 2px;
        }
        /* Track */
        ::-webkit-scrollbar-track {
            background: #f1f1f1;
        }

        /* Handle */
        ::-webkit-scrollbar-thumb {
            background: #888;
        }

        /* Handle on hover */
        ::-webkit-scrollbar-thumb:hover {
            background: #555;
        }
	</style>
	<script>
	
	function init(){
		data = {"sdate":"20191229",
				"edate":"20200208",
				"flag" : "1"
				};
		$.get( "selectCertiByDate" , data, success)
		
		$(".certi").on("click", function(){
			//1320
			param = {"code":"1320"};
			$.get( "selectCertiByCode" , param, function(data, textStatus, jqXHR){
				var str = '';

				str += '<b>직무분야</b> : ' + data[0].obligfldnm + ' > ' + data[0].mdobligfldnm + '<br>';
				str += '<b>자격구분</b> : ' + data[0].qualgbnm+ '<br><br>';
				$.each(data, function(idx, val) {
					console.log(val.qualgbnm);
					str += '<h4  style="text-align:center;">' + val.description+'</h4>';
					str += '<table style="text-align:center;width:100%">';
					str += '<tr><td>원서접수 시작일자 </td><td>' + moment(val.examregstartdt).format('YYYY-MM-DD')+'</td></tr>';
					str += '<tr><td>원서접수 종료일자 </td><td>' + moment(val.examregenddt).format('YYYY-MM-DD')+'</td></tr>';
					str += '<tr><td>시험 시작 일자 </td><td>' + moment(val.examstartdt).format('YYYY-MM-DD')+'</td></tr>';
					str += '<tr><td>시험 종료 일자 </td><td>' + moment(val.examenddt).format('YYYY-MM-DD')+'</td></tr>';
					str += '<tr><td>합격자 발표일 </td><td>' + moment(val.passenddt).format('YYYY-MM-DD')+'</td></tr>';
					str += '<tr><td>합격자 발표 종료일 </td><td>' + moment(val.passstartdt).format('YYYY-MM-DD')+'</td></tr>';
					str += '</table><br>';
					
					
					/*
					str += '<br>';
					str += '직무분야 : ' + val.obligfldnm + '>' + val.mdobligfldnm+'<br>';
					str += '자격구분 : ' + val.qualgbnm+'<br>';
					str += '회차 : ' + val.description+'<br>';
					str += '원서접수 시작일자 : ' + val.examregstartdt+'<br>';
					str += '원서접수 종료일자 : ' + val.examregenddt+'<br>';
					str += '시험 시작 일자 : ' + val.examstartdt+'<br>';
					str += '시험 종료 일자 : ' + val.examenddt+'<br>';
					str += '합격자 발표일 : ' + val.passenddt+'<br>';
					str += '합격자 발표 종료일 : ' + val.passstartdt+'<br>';
					str += '<br>';*/
				});
				console.log('str : ' + str)

				$('#schedule').html(str);

				$('.modal-title').html(data[0].jmfldnm);
			})
			
		});
		

        $("#schedule").mCustomScrollbar();
		//$("#mydiv").load("selectCertiByDate",sv);
	}
	function success(data, textStatus, jqXHR){
		$.each(data, function(idx, val) {
			console.log(idx + " " + val.jmfldnm, val.examregstartdt, val.examregenddt);
		});
	}
	
	$(init);

	</script>
	
</head>
<body>

<div class="container">
  <h2>Large Modal</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg certi" data-toggle="modal" data-target="#myModal">Open Large Modal</button>
</div>
<jsp:include page="detail.jsp"></jsp:include>
</body>
</html>
