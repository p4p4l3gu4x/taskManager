'use strict';

App.factory('TaskService', [ '$resource', function($resource) {
	return $resource('http://localhost:8080/task/:id'
		, {id: '@id'},
		{
		update : {
			method : 'PUT'
		}, deleteTask:{
			method : 'DELETE'
		}
	});
} ]);
