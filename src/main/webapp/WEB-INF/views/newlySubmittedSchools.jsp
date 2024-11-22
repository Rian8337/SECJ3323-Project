<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Newly Submitted Schools</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .sidebar {
            background-color: #f8f9fa;
            min-height: 100vh;
            padding: 20px;
        }
        .main-content {
            padding: 20px;
        }
        .table-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-2 sidebar">
                <div class="d-flex flex-column">
                    <a href="#" class="btn btn-light mb-2">Dashboard</a>
                    <a href="#" class="btn btn-light mb-2">Students</a>
                    <a href="#" class="btn btn-light mb-2">Administration</a>
                    <a href="#" class="btn btn-light mb-2">Teachers</a>
                    <a href="#" class="btn btn-light mb-2">Financial</a>
                    <a href="#" class="btn btn-light mb-2">Contents</a>
                    <a href="#" class="btn btn-light mb-2">Settings</a>
                </div>
            </div>

            <!-- Main content -->
            <div class="col-md-10 main-content">
                <!-- Breadcrumb -->
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="admin">Home</a></li>
                        <li class="breadcrumb-item"><a href="admin">Administration</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Newly Submitted Schools</li>
                    </ol>
                </nav>

                <h2>Newly Submitted Schools</h2>

                <!-- Table -->
                <div class="table-container">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>School Name</th>
                                <th>Status</th>
                                <th>View</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="school" items="${schools}">
                                <tr>
                                    <td>${school.schoolName}</td>
                                    <td>
                                        <span class="badge 
                                            ${school.status == 'Verified' ? 'bg-success' : 
                                              school.status == 'Pending' ? 'bg-warning text-dark' : 
                                              'bg-danger'}">
                                            ${school.status}
                                        </span>
                                    </td>
                                    <td>
                                        <a href="schoolInfo?id=${school.schoolId}" class="btn btn-link">View</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <!-- Back Button -->
                <div class="mt-3">
                    <a href="admin" class="btn btn-primary">Back</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>