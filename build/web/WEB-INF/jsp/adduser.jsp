<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${data.pageTitle}</title>
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>" type="text/css"/>
        <script src="<c:url value="/assets/js/angular.min.js"/>"></script>
    </head>
    <body ng-app="taskApp" ng-controller="taskCtrl">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <nav class="nav">
                        <a class="nav-link active" href="<c:url value="/user/add" />">Add New User</a>
                    </nav>
                </div>
            </div>  
        </div>
    </div>
    <script>
        const taskApp = angular.module("taskApp", []);
        taskApp.controller("taskCtrl", function ($scope, $http) {
            $scope.abc = "hello";
            $scope.getAllCompletedTask = function () {
                $http.get("/ToDo/task/donetask")
                        .then(function (response) {
                            //console.log(response);
                            $scope.myWelcome = response.data;
                        });
            };
        });
    </script>
</body>
</html>
