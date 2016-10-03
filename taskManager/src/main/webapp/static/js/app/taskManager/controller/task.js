'use strict';

App.controller('TaskController', [ '$scope', 'TaskService', function($scope, TaskService) {
	var self = this;
	
	self.taska = new TaskService();
	
	self.tasks = [];
	
	self.fetchAll = function(){
		self.tasks = TaskService.query();
	};
	
	self.createTask = function() {
		self.taska.$save(function() {
			self.fetchAll();
		});
	};
	
	self.updateTask = function(){
		self.taska.$update(function(){
			self.fetchAll();
		});
	};
	
	self.deleteTask = function(task) {
		console.log("Deleting task with id ", task.id);
		task.$deleteTask(function(){
			self.fetchAll();
		});
	};
	
	self.fetchAll();
	
	self.submit = function() {
		if(self.taska.id === undefined){
			console.log('Saving New Task ', self.taska);    
			self.createTask();
		}else{
			console.log('Upddating task with id ', self.taska.id);
			self.updateTask();
			console.log('Upddated task with id ', self.taska.id);
		}
		self.reset();
	}
	
	self.edit = function(task){
		console.log('Id to be edited', task.id);
        self.taska = angular.copy(task);
	};
	
	self.reset = function(){
		self.taska = new TaskService();
		$scope.myForm.$setPristine();
	};
}]);
