/**
 * 
 */

var app3 = angular.module('app3', []);

app3.controller("studentController", function($scope) {
	$scope.reset = function() {
		$scope.firstName = "Mahesh";
		$scope.lastName = "Parashar";
		$scope.email = "MaheshParashar@tutorialspoint.com";
	}
	$scope.reset();
});