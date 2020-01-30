<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${isLogin == null }">
<script language="javascript">
window.location.href = 'login';
alert('로그인 후 이용가능합니다.');
</script>
</c:if> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>자갈취-자격증 따러 갈 취준생</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/088b1a9afe.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.js"></script>
    <script>
    
	
	
       	window.onload = function(){
            /*
            | ------------------------------------------------------------------------------
            | Calendar plugin (rough draft)
            | ------------------------------------------------------------------------------
            */
            (function($){
                var Calendar = function (elem, options) {
                    this.elem = elem;
                    this.options = $.extend({}, Calendar.DEFAULTS, options);
                    this.init();
                };

                Calendar.DEFAULTS = {
                    datetime: undefined,
                    dayFormat: 'DDD',
                    weekFormat: 'DDD',
                    monthFormat: 'MM/DD/YYYY',
                    filter: undefined,
                };

                Calendar.prototype.init = function () {
                    if (! this.options.datetime || this.options.datetime == 'now') {
                        this.options.datetime = moment();
                    }
                    if (! this.options.filter) {
                        this.options.filter = 'exam';
                    }
                    this.initScaffold()
                        .initStyle()
                        .renderMonthView();
                }

                Calendar.prototype.initScaffold = function () {

                    var $elem = $(this.elem),
                        $view = $elem.find('.calendar-view'),
                        $currentDate = $elem.find('.calendar-current-date');

                    if (! $view.length) {
                        this.view = document.createElement('div');
                        this.view.className = 'calendar-view';
                        this.elem.appendChild(this.view);
                    } else {
                        this.view = $view[0];
                    }

                    if ($currentDate.length > 0) {
                        var dayFormat = $currentDate.data('day-format'),
                            weekFormat = $currentDate.data('week-format'),
                            monthFormat = $currentDate.data('month-format');
                        this.currentDate = $currentDate[0];
                        if (dayFormat) {
                            this.options.dayFormat = dayFormat;
                        }
                        if (weekFormat) {
                            this.options.weekFormat = weekFormat;
                        }
                        if (monthFormat) {
                            this.options.monthFormat = monthFormat;
                        }
                    }
                    return this;
                }

                Calendar.prototype.initStyle = function () {
                    return this;
                }

                Calendar.prototype.renderMonthView = function () {

                    var datetime = this.options.datetime.clone(),
                        month = datetime.month();
                    datetime.startOf('month').startOf('week');
                    var $view = $(this.view),
                        table = document.createElement('table'),
                        thead = document.createElement('thead'),
                        tbody = document.createElement('tbody');

                    $view.html('');
                    table.appendChild(thead);
                    table.appendChild(tbody);
                    table.className = 'table table-bordered';

                    tr = document.createElement('tr');
                    tr.calssName = 'calendar-month-row';

                    day = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
                    for(i = 0; i < 7; i++){
                        td = document.createElement('td');
                        td.appendChild(document.createTextNode(day[i]));
                        td.classList.add('calendar-day');
                        tr.appendChild(td);
                    }

                    thead.appendChild(tr);

                    var week = 0;
                    var i;

                    var sdate = datetime.format('YYYYMMDD');
                    var edate = datetime.add(41, 'day').format('YYYYMMDD');
                    var today = moment(new Date()).format('YYYYMMDD');
                    datetime.add(-41, 'day');
					
                    while (week < 6) {
                        tr = document.createElement('tr');
                        tr.className = 'calendar-month-row';
                        for (i = 0; i < 7; i++) {
                            td = document.createElement('td');
                            td.appendChild(document.createTextNode(datetime.format('D')));
                            div = document.createElement('div');
                            div.id = datetime.format('YYYYMMDD');
                            div.classList.add('calendar-month-row-data');
                            td.appendChild(div);

                            if (month !== datetime.month()) {
                                td.classList.add('calendar-other-months-date');
                            }

                            if (datetime.format('YYYYMMDD') == today){
                                if(td.classList.contains('calendar-other-months-date')){
                                    td.style.border = "2px rgba(238, 11, 3, 0.15) solid";
                                }else{
                                    td.style.border = "2px rgba(238, 11, 3, 0.51) solid";
                                }
                            }
                            tr.appendChild(td);
                            datetime.add(1, 'day');
                        }
                        tbody.appendChild(tr);
                        week++;
                    }

                    $view[0].appendChild(table);

                    if (this.currentDate) {
                        $(this.currentDate).html(
                            this.options.datetime.format(this.options.monthFormat)
                        );
                    }
                    if(this.options.filter == "exam"){ //통신이 이루어져야함
                    	$.get("selectCertiByDate", {
                       		"sdate" : sdate,
                       		"edate" : edate,
                       		"flag" : "1"
                        },
                        function(data, status){
                        	console.log(data)
                        	for(i = 0; i < data.length; i++){
                                tmp = $('#' + data[i].examstartdt);
                                tmp.append("<div class='" + data[i].jmcd + " calendar-date-onclick'><span data-toggle='modal' data-target='#myModal'>" + data[i].jmfldnm + "</span></div>");
                            }
                        });
                    }else{
                    	$.get("selectCertiByDate", {
                       		"sdate" : sdate,
                       		"edate" : edate,
                       		"flag" : "2"
                        },
                        function(data, status){
                        	for(i = 0; i < data.length; i++){
                                tmp = $('#' + data[i].examregstartdt);
                                tmp.append("<div class='" + data[i].jmcd + " calendar-date-onclick'><span data-toggle='modal' data-target='#myModal'>" + data[i].jmfldnm + "</span></div>");
                                tmp = $('#' + data[i].examregenddt);
                                tmp.append("<div class='" + data[i].jmcd + " calendar-date-onclick'><span data-toggle='modal' data-target='#myModal'>" + data[i].jmfldnm + "</span></div>");
                            }
                        });
                        
                    }

                }

                Calendar.prototype.next = function () {
                    this.options.datetime.endOf('month').add(1, 'day');
                    this.renderMonthView();
                }

                Calendar.prototype.prev = function () {
                    this.options.datetime.startOf('month').subtract(1, 'day');
                    this.renderMonthView();
                }

                Calendar.prototype.today = function () {
                    this.options.datetime = moment();
                    this.renderMonthView();
                }

                Calendar.prototype.filterByExam = function() {
                    this.options.filter = "exam";
                    this.renderMonthView();
                }

                Calendar.prototype.filterByReg = function() {
                    this.options.filter = "reg";
                    this.renderMonthView();
                }

                function Plugin(option) {
                    return this.each(function () {
                        var $this = $(this),
                            data  = $this.data('bs.calendar'),
                            options = typeof option == 'object' && option;

                        if (! data) {
                            data = new Calendar(this, options);
                            $this.data('bs.calendar', data);
                        }

                        switch (option) {
                            case 'today':
                                data.today();
                                break;
                            case 'prev':
                                data.prev();
                                break;
                            case 'next':
                                data.next();
                                break;
                            case 'exam':
                                data.filterByExam();
                                break;
                            case 'reg':
                                data.filterByReg();
                                break;
                            default:
                                break;
                        }
                    });
                };

                var noConflict = $.fn.calendar;

                $.fn.calendar             = Plugin;
                $.fn.calendar.Constructor = Calendar;

                $.fn.calendar.noConflict = function () {
                    $.fn.calendar = noConflict;
                    return this;
                };

                // Public data API.
                $('[data-toggle="calendar"]').click(function(){
                    var $this = $(this),
                        $elem = $this.parents('.calendar'),
                        action = $this.data('action');
                    if (action) {
                        $elem.calendar(action);
                    }
                });

                $('input[name="filter"]').change(function(){
                    var $this = $(this);
                    var $elem = $this.parents('.calendar');

                    $elem.calendar($('input[name="filter"]:checked').val());
                })

            })(jQuery);

            /*
            | ------------------------------------------------------------------------------
            | Installation
            | ------------------------------------------------------------------------------
            */
            $('#calendar').calendar();
            init();
        }

        
        function init(){
        	$(document).on("click",".calendar-date-onclick",function(){
    			//1320
				//$('#schedule').scrollTop(60)
				//console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
				//console.log(document.getElementById('schedule').scrollTop)
				//console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
				
        		//$('#schedule').animate({scrollTop:0}, 'fast');
    			//document.getElementById('schedule').scrollTop = 0;
				param = {"code":this.classList.item(0)};
				code = this.classList.item(0);
    			$.get( "selectCertiByCode" , param, function(data, textStatus, jqXHR){
    				var str = '';
    				if(data[0].obligfldnm == ' ' || data[0].mdobligfldnm == ' '){
						str += '<b>직무분야</b> : ' + data[0].obligfldnm + data[0].mdobligfldnm + '<br>';
					}else{
						str += '<b>직무분야</b> : ' + data[0].obligfldnm + ' > ' + data[0].mdobligfldnm + '<br>';
					}
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
    				});
    				console.log('str : ' + str)

    				$('#schedule').html(str);
    				$('#rjmcd').val(code);
    				$('.modal-title').html(data[0].jmfldnm);
    				
    				getStatistics();
    			})
    		});
    		
        	$(document).on("click","#delete-review",function(){
        		console.log(this);
        		deleteReview(this);
        	});
        	$(document).on("click","#modify-review",function(){
        		str = "";
        		str += "<div style='display: flex;justify-content: space-between;'>";
        		str += "<textarea style='width:88%' class='form-control' id='rcontent'></textarea>";
        		str += "<button style='width:10%' class='btn btn-info' onclick='updateReview()'>작성</button>";
        		str += "</div>";
        		console.log('content'+$(this).attr('name'));
        		console.log($('#content'+$(this).attr('name')));
        		$('#content'+$(this).attr('name')).html(str);
        	});
    		//$("#mydiv").load("selectCertiByDate",sv);
    	}
    	//$(init);
    </script>
    <style>
        .calendar-toolbar{
            display: flex;
            justify-content: space-between;
            align-items: flex-end;
        }
        .calendar-toolbar-date {
            margin-bottom: 10px;
        }
        .calendar-month-row {
            height: 100px;
        }
        .calendar-month-row-data{
            max-height: 60px;
            overflow-y: auto;
        }
        /* width */
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
        .calendar-other-months-date {
            color: #DDD;
        }
        .calendar-current-date {
            text-align: center;
            display: inline-block;
            width: 115px;
        }
        .calendar-day {
            background-color: rgba(65, 105, 225, 0.56);
            color: white;
            text-align: center;
            border-bottom-width: 0px !important;
        }
        table tr td {
            width: 14vw;
        }
        .calendar-month-today{
            border: 2px rgba(238, 11, 3, .51) solid !important;
        }
        .calendar-month-row-data{
        	font-size:11px;
        }
        .calendar-date-onclick span{
        	cursor: pointer;
        }
        #logout{
        	cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="page-header">
        <i class="fa fa-calendar"></i> 자갈취
    </h1>
    <c:if test="${isLogin != null }">
		<span onclick="location='logout'" id="logout">로그아웃</span>
	</c:if>
    <div class="calendar" id="calendar">
        <!-- Calendar toolbar -->
        <div class="calendar-toolbar">
            <div class="calendar-toolbar-filter">
                <div class="radio">
                    <label><input type="radio" name="filter" value="exam" checked>시험일</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="filter" value="reg">접수기간</label>
                </div>
            </div>
            <div class="calendar-toolbar-date">
                <!-- Calendar "today" button -->
                <button data-toggle="calendar" data-action="today" class="btn btn-default">
                    Today
                </button>
                <!-- Calendar "prev" button -->
                <button data-toggle="calendar" data-action="prev" class="btn btn-default">
                    <i class="fa fa-chevron-left"></i>
                </button>
                <!-- Calendar "date-indicator" span -->
                <div class="calendar-current-date"
                     data-day-format="MM/DD/YYYY"
                     data-week-format="MM/DD/YYYY"
                     data-month-format="MMM, YYYY">
                    (placeholder)
                </div>
                <!-- Calendar "next" button -->
                <button data-toggle="calendar" data-action="next" class="btn btn-default">
                    <i class="fa fa-chevron-right"></i>
                </button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="detail.jsp"></jsp:include>
</body>
</html>