<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Teacher</title>
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
        .status-box {
            margin-top: 50px;
        }
        .school-info {
            margin-top: 30px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            padding: 20px;
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
                    <a href="#" class="btn btn-light mb-2">Student</a>
                    <a href="#" class="btn btn-light mb-2">Parents</a>
                    <a href="#" class="btn btn-light mb-2">Teachers</a>
                    <a href="#" class="btn btn-light mb-2">Contents</a>
                    <a href="#" class="btn btn-light mb-2">Settings</a>
                </div>
            </div>

            <!-- Main content -->
            <div class="col-md-10 main-content">
                <!-- Breadcrumb -->
                <div class="breadcrumb-container mb-4">
                    <h3>Teacher</h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="welcome">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Teacher</li>
                        </ol>
                    </nav>
                </div>
                
                <h1>WELCOME, TEACHER..</h1>
                
                <div class="status-box">
                    <h3>SCHOOL INFORMATION STATUS:</h3>
                    
                    <c:choose>
                        <c:when test="${hasVerifiedSchool}">
                            <div class="school-info">
                                <table class="table table-bordered">
                                    <tr>
                                        <th>School Name</th>
                                        <td>${school.name}</td>
                                    </tr>
                                    <tr>
                                        <th>District</th>
                                        <td>${school.district}</td>
                                    </tr>
                                    <tr>
                                        <th>Address</th>
                                        <td>${school.address}</td>
                                    </tr>
                                    <tr>
                                        <th>Email</th>
                                        <td>${school.email}</td>
                                    </tr>
                                    <tr>
                                        <th>Phone</th>
                                        <td>${school.phone}</td>
                                    </tr>
                                    <tr>
                                        <th>Status</th>
                                        <td>
                                            <span class="badge bg-success">VERIFIED</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Equipment Level</th>
                                        <td>${school.equipmentLevel}</td>
                                    </tr>
                                </table>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <p class="text-warning">No school information available. Please contact your administrator.</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</body>
</html>