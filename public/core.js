// public/core.js
var scotchTodo = angular.module('angularTest', []);


scotchTodo.controller("control", function($scope){
	var employees = [
			{FirstName : "Amit" , LastName:"Semwal", EmpCode:101},
			{FirstName : "Ashish" , LastName:"Sharma", EmpCode:102},
			{FirstName : "A" , LastName:"b", EmpCode:103}
	];
	$scope.employees = employees;
})

scotchTodo.controller("like", function($scope){
	var languages = [
			{Name : "C" , likes:0, dislikes:0},
			{Name : "Java" , likes:0, dislikes:0},
			{Name : ".net" , likes:0, dislikes:0},
	];
	$scope.languages = languages;
	
	$scope.incrementLikes = function (language) {
		language.likes++;
	}
	$scope.incrementDislikes = function (language) {
		language.dislikes++;
	}
})
function mainController($scope, $http) {
    $scope.formData = {};

    // when landing on the page, get all todos and show them
    $http.get('/api/todos')
        .success(function(data) {
            $scope.todos = data;
            console.log(data);
        })
        .error(function(data) {
            console.log('Error: ' + data);
        });

    // when submitting the add form, send the text to the node API
    $scope.createTodo = function() {
        $http.post('/api/todos', $scope.formData)
            .success(function(data) {
                $scope.formData = {}; // clear the form so our user is ready to enter another
                $scope.todos = data;
                console.log(data);
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
    };

    // delete a todo after checking it
    $scope.deleteTodo = function(id) {
        $http.delete('/api/todos/' + id)
            .success(function(data) {
                $scope.todos = data;
                console.log(data);
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
    };

}
