<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page import="control.tracker.*"%> --%>
<%@ page import="org.json.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<!-- <link rel="shortcut icon" type="image/x-icon" href="/Map/img/tracker.png" /> -->
<title>Tracking</title>
<link href="../css/mapCSS.css" rel="stylesheet">
<script src="../js/function.js" /></script>
<!-- <script src="/Map/function/Sha1Digest.js" /></script> -->
</head>
<body>

	<!--<div id="floating-panel">
		<input onclick="clearMarkers();" type=button value="Hide Markers">
		<input onclick="showMarkers();" type=button value="Show All Markers">
		<input onclick="deleteMarkers();" type=button value="Delete Markers">
	</div> -->
	<input id="pac-input" class="controls" type="text" placeholder="Search Box">
	<div id="map"></div>
	<!-- <p>Click on the map to add markers.</p>  -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
		//document.write(username+"<br>"+salt);
		//INIT MAP
		/* var iconPosition = "/Map/img/red-location-icon.png"; */
		function initMap() {
			var center = {
				lat : 10.0300058003897,
				lng : 105.772376060486
			};
			var iconPosition = "../img/user-icon.png";
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 15,
				center : center,
				mapTypeId : 'terrain'
			});
			addMarker(center, iconPosition, null, "You are here");
			// This event listener will call addMarker() when the map is clicked.
			map.addListener('click', function(event) {
				addMarker(event.latLng, iconPosition, null, event.latLng.lat()
						+ "<br>" + event.latLng.lng());
			});

			var listObj = {};
			function startTime() {
				//Lay danh sach user 
				//var listObj=${listObj};
				deleteMarkers();

				$.getJSON(
					'http://localhost:8080/Map/apiKaa/getAlltUserTrack/cec457653901327bfb6f747d9614e2c183ebc3de',
					function(data) {
						listObj = data;
						for (var i = 0; i < listObj.length; i++) {
							var nameObj = listObj[i].event.username;
							var latObj = parseFloat(listObj[i].event.lat);
							var lngObj = parseFloat(listObj[i].event.lng);
							var locationObj = {
								lat : latObj,
								lng : lngObj

							};

							// Dinh nghia thong tin Sinh vien o day								
							addMarker(locationObj, iconPosition,
									nameObj + "",
									"<a href=\"/Map/tracker/trackUser/username="+nameObj+"\">"
											+ nameObj + "</a><br>");
						}
					});

				var t = setTimeout(startTime, 10000);
			}
			startTime();

			//Hien thi search box
			searchBox();
		}
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD33TSkbvpSLniSl4eN-j75TpyLHvIj9uQ&libraries=places&callback=initMap">
		
	</script>

</body>
</html>