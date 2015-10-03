/**
 * angular demos
 */

var demoApp = angular.module('demoApp', []);

/*
 * demoApp.config(function($routeProvider) { $routeProvider.when('/', {
 * controller : "SimpleController", templateUrl : "View1.html"
 * }).when('/partial2', { controller : "SimpleController", templateUrl :
 * "View2.html" }).otherwise({ redirectTo : '/' });
 * 
 * });
 */

demoApp.controller('SimpleController', function($scope) {
	$scope.customers = [ {
		name : 'dave',
		city : 'san-fransisco'
	}, {
		name : 'nitesh',
		city : 'delhi'
	}, {
		name : 'izzy',
		city : 'sanjose'
	}, {
		name : 'mia',
		city : 'los-angeles'
	} ];
});

demoApp.controller('studentController', function($scope) {
	$scope.student = {
		firstName : "Mahesh",
		lastName : "Parashar",
		fees : 500,
		subjects : [ {
			name : 'Physics',
			marks : 70
		}, {
			name : 'Chemistry',
			marks : 80
		}, {
			name : 'Math',
			marks : 65
		}, {
			name : 'English',
			marks : 75
		}, {
			name : 'Hindi',
			marks : 67
		} ],
		fullName : function() {
			var studentObject;
			studentObject = $scope.student;
			return studentObject.firstName + " " + studentObject.lastName;
		}
	}
	
	/*$scope.reset = function(){
		$scope.firstName = "Mahesh";
		$scope.lastName = "Parashar";
		$scope.email = "MaheshParashar@tutorialspoint.com";
		}
		$scope.reset();*/
});

/*
 * $(document).ready(function() { function disableBack() { alert("show Me");
 * window.history.forward(); alert("show Me E"); }
 * 
 * alert("show Me Di"); window.onload = disableBack(); window.onpageshow =
 * function(evt) { alert("show Me fun(eve)") if (evt.persisted) disableBack();
 * alert("show Me After If") } });
 */

/*function preventBack() {
	window.history.forward();
}

setTimeout("preventBack()", 0);
window.onunload = function() {
	null
};*/