<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        var data = [{"seriesCd" : "21", //계열코드
            "jmfldnm" : "가스기술사", //종목명
            "description" : "2020년도1회1차", //회차
            "EXAM_REG_START_DT" : "20200103", //원서접수시작일자
            "EXAM_REG_END_DT" : "20200109", //원서접수종료일자
            "EXAM_START_DT" : "20200321", //시험시작일자
            "EXAM_END_DT" : "20200321", //시험종료일자
            "PASS_START_DT" : "20200324", //합격자발표시작일자
            "PASS_END_DT" : "20200324", //합격자발표종료일자
        },
        {"seriesCd" : "22", //계열코드
            "jmfldnm" : "정보처리기사", //종목명
            "description" : "2020년도1회1차", //회차
            "EXAM_REG_START_DT" : "20200105", //원서접수시작일자
            "EXAM_REG_END_DT" : "202001012", //원서접수종료일자
            "EXAM_START_DT" : "20200305", //시험시작일자
            "EXAM_END_DT" : "20200305", //시험종료일자
            "PASS_START_DT" : "20200325", //합격자발표시작일자
            "PASS_END_DT" : "20200325", //합격자발표종료일자
        },
        {"seriesCd" : "23", //계열코드
            "jmfldnm" : "정보보안기사", //종목명
            "description" : "2020년도1회1차", //회차
            "EXAM_REG_START_DT" : "20200113", //원서접수시작일자
            "EXAM_REG_END_DT" : "20200119", //원서접수종료일자
            "EXAM_START_DT" : "20200219", //시험시작일자
            "EXAM_END_DT" : "20200219", //시험종료일자
            "PASS_START_DT" : "20200323", //합격자발표시작일자
            "PASS_END_DT" : "20200323", //합격자발표종료일자
        },
        {"seriesCd" : "22", //계열코드
            "jmfldnm" : "보건복지기사", //종목명
            "description" : "2020년도1회1차", //회차
            "EXAM_REG_START_DT" : "20200105", //원서접수시작일자
            "EXAM_REG_END_DT" : "202001012", //원서접수종료일자
            "EXAM_START_DT" : "20200305", //시험시작일자
            "EXAM_END_DT" : "20200305", //시험종료일자
            "PASS_START_DT" : "20200325", //합격자발표시작일자
            "PASS_END_DT" : "20200325", //합격자발표종료일자
        },
        {"seriesCd" : "22", //계열코드
            "jmfldnm" : "미용사", //종목명
            "description" : "2020년도1회1차", //회차
            "EXAM_REG_START_DT" : "20200105", //원서접수시작일자
            "EXAM_REG_END_DT" : "202001012", //원서접수종료일자
            "EXAM_START_DT" : "20200305", //시험시작일자
            "EXAM_END_DT" : "20200305", //시험종료일자
            "PASS_START_DT" : "20200325", //합격자발표시작일자
            "PASS_END_DT" : "20200325", //합격자발표종료일자
        },
        {"seriesCd" : "22", //계열코드
            "jmfldnm" : "타투전문가", //종목명
            "description" : "2020년도1회1차", //회차
            "EXAM_REG_START_DT" : "20200105", //원서접수시작일자
            "EXAM_REG_END_DT" : "202001012", //원서접수종료일자
            "EXAM_START_DT" : "20200305", //시험시작일자
            "EXAM_END_DT" : "20200305", //시험종료일자
            "PASS_START_DT" : "20200325", //합격자발표시작일자
            "PASS_END_DT" : "20200325", //합격자발표종료일자
        },
        {"seriesCd" : "22", //계열코드
            "jmfldnm" : "싱어송라이터", //종목명
            "description" : "2020년도1회1차", //회차
            "EXAM_REG_START_DT" : "20200105", //원서접수시작일자
            "EXAM_REG_END_DT" : "202001012", //원서접수종료일자
            "EXAM_START_DT" : "20200305", //시험시작일자
            "EXAM_END_DT" : "20200305", //시험종료일자
            "PASS_START_DT" : "20200325", //합격자발표시작일자
            "PASS_END_DT" : "20200325", //합격자발표종료일자
        }];
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
                    view: undefined,
                };

                Calendar.prototype.init = function () {
                    if (! this.options.datetime || this.options.datetime == 'now') {
                        this.options.datetime = moment();
                    }
                    if (! this.options.view) {
                        this.options.view = 'month';
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
                    console.log($currentDate);

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
                        td.className = 'calendar-day';
                        tr.appendChild(td);
                    }

                    thead.appendChild(tr);

                    var week = 0, i;
                    while (week < 6) {
                        tr = document.createElement('tr');
                        tr.className = 'calendar-month-row';
                        for (i = 0; i < 7; i++) {
                            td = document.createElement('td');
                            td.appendChild(document.createTextNode(datetime.format('D')));
                            div = document.createElement('div');
                            div.id = datetime.format('YYYYMMDD');
                            div.className = 'calendar-month-row-data';
                            td.appendChild(div);
                            if (month !== datetime.month()) {
                                td.className = 'calendar-prior-months-date';
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

                    for(i = 0; i < data.length; i++){
                        tmp = $('#' + data[i].EXAM_START_DT);
                        console.log(tmp)
                        tmp.append("<div>" + data[i].jmfldnm + "</div>");
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

            })(jQuery);

            /*
            | ------------------------------------------------------------------------------
            | Installation
            | ------------------------------------------------------------------------------
            */
            $('#calendar').calendar();
        }

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
        .calendar-month-row-data::-webkit-scrollbar {
            width: 2px;
        }
        /* Track */
        .calendar-month-row-data::-webkit-scrollbar-track {
            background: #f1f1f1;
        }

        /* Handle */
        .calendar-month-row-data::-webkit-scrollbar-thumb {
            background: #888;
        }

        /* Handle on hover */
        .calendar-month-row-data::-webkit-scrollbar-thumb:hover {
            background: #555;
        }
        .calendar-prior-months-date {
            color: #DDD;
        }
        .calendar-current-date {
            text-align: center;
            display: inline-block;
            width: 115px;
        }
        .calendar-day {
            text-align: center;
        }
        table tr td {
            width: 14vw;
        }

    </style>
</head>
<body>
<div class="container">
    <h1 class="page-header">
        <i class="fa fa-calendar"></i> 자갈취
    </h1>
    <div class="calendar" id="calendar">
        <!-- Calendar toolbar -->
        <div class="calendar-toolbar">
            <div class="calendar-toolbar-filter">
                <div class="radio">
                    <label><input type="radio" name="filter" checked>시험일</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="filter">접수기간</label>
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
</body>
</html>