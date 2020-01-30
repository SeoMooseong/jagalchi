<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<script src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		function getStatistics(){
			/*
			$.get('selectStatistics',{'code':$('#rjmcd')}, function(data){
				alert(date);
				drawReview(data);
			})
			*/
			google.charts.load('current', {'packages':['corechart']});
        	google.charts.setOnLoadCallback(drawChart);
        	
        	$.get('review',{'rjmcd':$('#rjmcd').val()}, function(data){
				alert("aaa"+date);
				drawReview(data);
			})
		}
		function drawChart() { // array 안에 array를 그려서 chart가 만들어짐
			arr = [["자격증", "합격률", { role: 'style' }],
				["정처기", 50, '#b87333'],
				["정보기", 70, '#b87333'],
				["네관", 60, '#b87333']
				];
			
			var data = google.visualization
			.arrayToDataTable(arr);
			
			var options = { // JSon 형식
				title : '대분류 내 자격증별 합격률',
				curveType : 'none', // curveType으로는 none과 function이 있는데, none인 경우 straight한 선으로 그려지고, function인 경우 smooth한 그래프 그려짐
				legend : {
					position : 'none'
				},
				vAxis: {title:'단위 %',maxValue:100,minValue:0}
			// legend는 각 라인에 대한 설명구	
			};
			var chart = new google.visualization.ColumnChart(document
					.getElementById('statistics'));
			chart.draw(data, options); // 차트 그려지는 부분(data를 바탕으로 options에 맞게 그려짐)
	    }
		
		function insertReview(){
			
			data = { "rjmcd" :$("#rjmcd").val(),
			 "rdate" :  moment(new Date()).format('YYYYMMDD'),
			 "rcontent" : $("#rcontent").val()}
			
			$.get("insertReview", data, function(result){
				drawReview(result);
			})
		}
		
		function drawReview(data){
			str = "";
			for(i = 0 ; i < data.length() ; i++){
				str = "<hr>";
				str = "<b>"+data[i].rid+"</b><span style='float: right;'>"+data[i].rdate+"</span>";
				str = "<p>"+data[i].rcontent+"</p>";
				str = "<input type='hidden' id="+data[i].rno+">"
			}
			
		}
		
	</script>
</header>
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h2 class="modal-title" style="text-align: center;">Modal
					Header</h2>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-6">
						<div id="schedule"
							style="width: 100%; max-height: 250px; overflow-y: auto !important;];">

						</div>
					</div>
					<div class="col-sm-6">
						<div id="statistics"></div>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-10">
						<div id="review">
							<h3>후기</h3>

							<hr>
							<b>nickname</b><span style="float: right;">2020-01-01</span>
							<p>정처기는 필수 입니다. 꼭 따세요!!!</p>
							<input type="hidden" id="1">

							<hr>
							<b>nickname</b><span style="float: right;">2020-01-01</span>
							<p>정처기는 필수 입니다. 꼭 따세요!!!</p>
							<input type="hidden" id="2">

							<hr>
							<b>nickname</b><span style="float: right;">2020-01-01</span>
							<p>정처기는 필수 입니다. 꼭 따세요!!!</p>
							<input type="hidden" id="3">

							<hr>
							<b>nickname</b><span style="float: right;">2020-01-01</span>
							<p>정처기는 필수 입니다. 꼭 따세요!!!</p>
							<input type="hidden" id="4">
						</div>
						<hr>
						<b>작성자 닉네임</b><br>
						<div style="display: flex;justify-content: space-between;">
							<textarea style="width:88%" class="form-control" id="rcontent"></textarea>
							<button style="width:10%" class="button" onclick="insertReview()">작성</button>
						</div>
						<input type="hidden" id="rjmcd">

					</div>
					<div class="col-sm-1"></div>
				</div>





			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>