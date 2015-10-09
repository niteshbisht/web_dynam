/**
 * ajax Controls Angular
 */

var ajax_app = angular.module("ajax_app", []);
ajax_app.controller("ajaxController", function($scope, $http) {
	var url = "../data/data.json";
	console.log(url);
	$http.get(url).success(function(response) {
		$scope.students = response;
		console.log($scope.students);
	});
});
