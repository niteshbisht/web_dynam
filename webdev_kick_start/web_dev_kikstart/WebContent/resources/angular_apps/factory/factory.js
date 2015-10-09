/**
 * angular factory example
 */

var mainFac = angular.module('mainFactN', []);





mainFac.factory('MathService', function() {
	var factory = {};
	factory.multiply = function(a, b) {
		return (a*b);
	}
	return factory;
});

mainFac.controller('CalcController', function($scope, CalcService) {
	$scope.square = function() {
		$scope.result = CalcService.square($scope.number);
	}
});

mainFac.service('CalcService', function(MathService) {
	this.square = function(a) {
		return MathService.multiply(a, a);
	}
});