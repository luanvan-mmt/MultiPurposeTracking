<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<script src="../js/function.js"/></script>
<!-- <script src="/Map/function/Sha1Digest.js" /></script> -->
<style>
body {
	top: 50px;
}
</style>
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
			var center = {lat: 10.000, lng: 105.000 };
			var iconPosition = "/Map/img/red-location-icon.png";
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 15,
				center : center,
				mapTypeId : 'terrain'
			});
			addMarker(center, null, null, "You are here");
			// This event listener will call addMarker() when the map is clicked.
			map.addListener('click', function(event) {
				addMarker(event.latLng, null, null, event.latLng.lat() + "<br>"
						+ event.latLng.lng());
			});
			//Hien thi search box
			searchBox();
		}

	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD33TSkbvpSLniSl4eN-j75TpyLHvIj9uQ&libraries=places&callback=initMap">		
	</script>
	
</body>
</html>