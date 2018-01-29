<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../inc/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href='./css/fullcalendar.min.css' rel='stylesheet' />
<link href='./css/fullcalendar.print.min.css' rel='stylesheet'
	media='print' />
<script src='./js/moment.min.js'></script>
<script src='./js/jquery.min.js'></script>
<script src='./js/jquery-ui.min.js'></script>
<script src='./js/fullcalendar.min.js'></script>
<script>
	$(document).ready(function() {

		$('#calendar').fullCalendar({
			defaultDate : '2017-11-12',
			editable : true,
			eventLimit : true, // allow "more" link when too many events
			events : [ {
				title : 'All Day Event',
				start : '2017-11-01'
			}, {
				title : 'Long Event',
				start : '2017-11-07',
				end : '2017-11-10'
			}, {
				id : 999,
				title : 'Repeating Event',
				start : '2017-11-09T16:00:00'
			}, {
				id : 999,
				title : 'Repeating Event',
				start : '2017-11-16T16:00:00'
			}, {
				title : 'Conference',
				start : '2017-11-11',
				end : '2017-11-13'
			}, {
				title : 'Meeting',
				start : '2017-11-12T10:30:00',
				end : '2017-11-12T12:30:00'
			}, {
				title : 'Lunch',
				start : '2017-11-12T12:00:00'
			}, {
				title : 'Meeting',
				start : '2017-11-12T14:30:00'
			}, {
				title : 'Happy Hour',
				start : '2017-11-12T17:30:00'
			}, {
				title : 'Dinner',
				start : '2017-11-12T20:00:00'
			}, {
				title : 'Birthday Party',
				start : '2017-11-13T07:00:00'
			}, {
				title : 'Click for Google',
				url : 'http://google.com/',
				start : '2017-11-28'
			} ]
		});

	});
</script>
<style>
body {
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
span.fc-title{
	color: white;
}

span.fc-time{
	color: white;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-2">
			</div>
			<div class="col-8">
				<div id='calendar'></div>
			</div>
			<div class="col-2"></div>
		</div>
	</div>
</body>
</html>