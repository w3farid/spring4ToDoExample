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
            <div class="row justify-content-center">               
                <div class="col-md-8">
                    <c:if test="${data.addStatus == 'success'}">
                        <div class="alert alert-success">Task added Successful</div>
                    </c:if>
                    <c:if test="${data.addStatus == 'error'}">
                        <div class="alert alert-success">Task added Failed</div>
                    </c:if>
                    <fieldset>
                        <legend>${data.formTitle}</legend>

                        <form action="<c:url value="/task/add"/>" method="post">
                            <div class="form-group">
                                <label for="task_name">Task Name</label>
                                <textarea class="form-control" id="task_name" name="task_name"></textarea>
                            </div>
                            <button type="submit" class="btn btn-primary float-right">Add Task</button>
                        </form>
                    </fieldset>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-md-8 pt-5">
                    <c:if test="${data.status == 'success'}">
                        <div class="alert alert-success">Task Completed Successful</div>
                    </c:if>
                    <c:if test="${data.status == 'error'}">
                        <div class="alert alert-success">Task Completed failed</div>
                    </c:if>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Task Name</th>
                                <th>Created Date(YYYY-MM-dd)</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${data.taskList}">
                                <tr>
                                    <td>${item.taskName}</td>
                                    <td>${item.createdDate}</td>
                                    <td><a class="btn btn-success" href="<c:url value="/task/done/${item.id}"/>">Done</a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
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
