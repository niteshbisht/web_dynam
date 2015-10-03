/**
 * @author sysxcomintl
 */

function webstart() {

	alert('ia m loaded');
	if (Window.navigator && Window.navigator.geolocation) {
		Window.navigator.geolocation.getCurrentPosition(geo_success, geo_error);
	} else {
		error('GeoLocation is not supported.');
	}
}

/*document.ready(function() {
 // wire up button click.
 $('#go').click(function() {
 // test for pressence of geolocation.
 if (navigator && navigator.geolocation) {
 navigator.geolocation.getCurrentPosition(geo_success, geo_error);
 } else {
 error('GeoLocation is not supported.');
 }
 });
 });*/

function geo_success(position) {
	printLatLong(position.coords.latitude, position.coords.longitude);
}
// The PositionError object returned contains the following attributes:
// code: a numeric response code.
// PERMISSION_DENIED = 1
// POSITION_UNAVAILABLE = 2
// TIMEOUT = 3
//message: Primarily for debugging. It's recommended not to show this error to users.
function geo_error(err) {
	if (err.code == 1) {
		error('The user denied the request for location information.')
	} else if (err.code == 2) {
		error('Your location information is unavailable.')
	} else if (err.code == 3) {
		error('The request to get your location timed out.')
	} else {
		error('An unknown error occurred while requesting your location.')

	}
}
//output lat and long .
function printLatLong(lat, long) {
	$('body').append('<p>Lat: ' + lat + '</p>');
	$('body').append('<p>Long: ' + long + '</p>');
}

function error(msg) {
	alert(msg);
}

function showSystemDate() {
	var date = new Date();
	var div = document.getElementById("systemdate");
	var dateContent = document.createTextNode(date.toDateString());
	div.appendChild(dateContent);
	if (window.navigator.appName == 'Microsoft Internet Explorer') {
		document.createElement("header");
		document.createElement("nav");
		document.createElement("footer");
	}

	var storage_support = window.sessionStorage || window.localStorage;
	var user_id = "A1B2C3D4";
	var user_data = {
		name : "Paul Walker",
		occupation : "Actor",
		favorite_color : "Blue"
	};

	sessionStorage.setItem(user_id, JSON.stringify(user_data));
}
