var angular_router_app = angular.module("angular_router_app", [ 'ngRoute' ]);

angular_router_app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/addStudent', {
		templateUrl : 'addStudent.htm',
		controller : 'AddStudentController'
	}).when('/viewStudents', {
		templateUrl : 'viewStudents.htm',
		controller : 'ViewStudentsController'
	}).otherwise({
		redirectTo : '/addStudent'
	});
} ]);

angular_router_app.controller('AddStudentController', function($scope) {
	$scope.message = "This page will be used to display add student form";
});


angular_router_app.controller('ViewStudentsController', function($scope) {
	$scope.message = "This page will be used to display all the students";
});