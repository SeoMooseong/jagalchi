<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<script src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
	var evtSource ;
	isStart = false;
	function start() {
		if(!isStart){
			isStart = true;
			evtSource = new EventSource("review_sse?rjmcd="+$('#rjmcd').val());
			evtSource.onmessage = rcvData
		}
	}
	function stop() {
		if(isStart){
			isStart = false;
			evtSource.close();
		}
	}
	function rcvData(event) {
		jData = JSON.parse(event.data)
		console.log(jData);
		drawReview(jData);
	};
	var arr = [];
		function getStatistics(){
			
			$.get('selectStatistics',{code:$('#rjmcd').val()}, function(data){

				arr = [];
				arr.push(["자격증", "필기 합격률",{ role: 'style' }, "실기 합격률",{ role: 'style' }]);
				
				for(i = 0 ; i < data.length ; i++){
					brr = [];
					brr.push(data[i].jmnm);
					brr.push(data[i].pil);
					brr.push(data[i].pilColor);
					brr.push(data[i].sil);
					brr.push(data[i].silColor);
					arr.push(brr);
				}
				console.log(arr);
				google.charts.load('current', {'packages':['corechart']});
	        	google.charts.setOnLoadCallback(drawChart);
				$('#schedule').scrollTop(0);
			})
			
        	
        	$.get('review',{'rjmcd':$('#rjmcd').val()}, function(data){
				drawReview(data);
				$('#review').scrollTop($('#review')[0].scrollHeight);
			})

		}
		function drawChart() { // array 안에 array를 그려서 chart가 만들어짐
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
			
			$.post("review", data, function(result){
				drawReview(result);
				$("#rcontent").val('');
				$('#review').scrollTop($('#review')[0].scrollHeight);
			})
			
			
		}
		function deleteReview(rno){
			$.ajax({
				type:"post",
				url:"deleteReview",
				data : {
					"rno" :  rno,
					"rjmcd" :  $('#rjmcd').val()
				},
				success: function(result){
					drawReview(result);
				},
				error: function(xhr, status, error) {
					alert(error);
				}	
			});
		}
		function modifyReviewBtn(rno){
    	
    		var originalData = $('#content' + rno).text();
    		$('div.delete-modify').css('display', 'none');	
    		param = {
    			rno : rno,
    			data : originalData
    		}
    		console.log(param)
    		str = "<textarea class='form-control' id='econtent'></textarea>";
    		str += "<div style='display:flex; justify-content:flex-end;'><span class='dm-hover' onclick='doModify(" + rno + ")'><i class='fas fa-check' /></span><span class='dm-hover' onclick='undoModify("+rno+ ",\"" +originalData+"\")'><i class='fas fa-undo'></i></span></div>"
    		
    		$('#content'+ rno).html(str);
    		$('#econtent').val(originalData);
		}
		function doModify(rno){
			$.ajax({
				type:"post",
				url:"updateReview",
				data : {
					"rno" :  rno,
					"rcontent" : $('#econtent').val(),
					"rjmcd" :  $('#rjmcd').val()
				},
				success: function(result){
					drawReview(result);
					$(".delete-modify").css("display", "flex");
					$('#review').scrollTop($('#review')[0].scrollHeight);
				},
				error: function(xhr, status, error) {
					alert(error);
				}	
			});
		}
		function undoModify(rno, data){
			console.log(rno, data)
			$("#content"+ rno).empty();
			$("#content"+ rno).text(data);
			$("div.delete-modify").css("display", "flex");
		}
		function drawReview(data){ 
			
			//str = "<h3>후기</h3>";
			str = "";
			for(i = 0 ; i < data.length ; i++){
				str += "<hr class='boundary'>";
				str += "<div class='id-date'><b>"+data[i].rid+"</b><span style='float: right;'>"+moment(data[i].rdate).format('YYYY-MM-DD')+"</span></div>";
				str += "<div id='content"+data[i].rno+"'>"+data[i].rcontent+"</div>";
				if("${isLogin.id}"  == data[i].rid ){
					str += "<div class='delete-modify'><span class='dm-hover' onclick='modifyReviewBtn("+data[i].rno+")'><i class='fas fa-eraser' />수정</span><span class='dm-hover' onclick='deleteReview("+data[i].rno+")'><i class='far fa-trash-alt' />삭제</span></div>"
					//str += "<div id='delete-modify'><p class='dm-hover' id='delete-review' name='"+data[i].rno+"'><i class='far fa-trash-alt'></i>삭제</p>&nbsp&nbsp<p class='dm-hover' id='modify-review'  name='"+data[i].rno+"'><i class='fas fa-eraser'></i>수정</p></div>";
				}
			}
			$('#review').html(str);
		}
		function closeButton(){
			stop();
		}
		
	</script>
	<style type="text/css">
	.delete-modify {
		display:flex;
		justify-content: flex-end;
	}
	.boundary {
		margin-top: 7px;
		margin-bottom: 7px; 
	}
	.dm-hover:hover{
		color:lightgray;
		cursor: pointer;
	}
	.dm-hover{
		color:gray;
		font-size: 12px;
		margin-left:5px;
	}
	p {
		margin-bottom: 0px;
	}
	#content {
		margin-top: 5px;
	}
	#review {
		max-height: 230px;
		overflow-y: auto;
	}
	</style>
</header>
<!-- Modal -->
<div class="modal" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h2 class="modal-title" style="text-align: center;">Modal Header</h2>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-sm-6">
						<div id="schedule"
							style="width: 100%; max-height: 250px; overflow-y: auto !important;">
					
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
						<h3>후기</h3>
						<div id="review">
						
							
						</div>
						<hr>
						<b>댓글 작성</b><br>
						<div style="display: flex;justify-content: space-between;">
							<textarea style="width:88%" class="form-control" id="rcontent"></textarea>
							<button style="width:10%" class="btn btn-info" onclick="insertReview()">작성</button>
						</div>
						<input type="hidden" id="rjmcd">

					</div>
					<div class="col-sm-1"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default close" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>