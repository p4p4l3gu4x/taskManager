<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="TaskApp">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>My Task Manager</title>
	<script src="/static/js/lib/angular/angular.min.js"></script>
	<script src="/static/js/lib/angular/angular-resource.min.js"></script>
	<script src="/static/js/app.js"></script>
	<script src="/static/js/app/taskManager/service/task.js"></script>
	<script src="/static/js/app/taskManager/controller/task.js"></script>
</head>
<body>
	<div ng-controller="TaskController as ctrl">
		<table>
			<form ng-submit="ctrl.submit()" name="myForm">
				<input type="text" ng-model="ctrl.taska.taskTitle" />
				<input type="text" ng-model="ctrl.taska.taskDescription" />
				<input type="text" ng-model="ctrl.taska.status" />
				<input type="text" ng-model="ctrl.taska.priority" />
				<input type="submit"  value="Add"/>
			</form>
		</table>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Task</th>
					<th>Description</th>
					<th>Status</th>
					<th>Priority</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="task in ctrl.tasks">
					<td><span ng-bind="task.id"/></td>
					<td><span ng-bind="task.taskTitle"/></td>
					<td><span ng-bind="task.taskDescription"/></td>
					<td><span ng-bind="task.status"/></td>
					<td><span ng-bind="task.priority"/></td>
					<td>
						<button  ng-click="ctrl.edit(task)">Editar</button>
					</td>
					<td>
						<button  ng-click="ctrl.deleteTask(task)">Excluir</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>