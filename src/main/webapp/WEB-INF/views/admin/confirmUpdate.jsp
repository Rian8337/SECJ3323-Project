<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirm Update</title>
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
                <div class="alert alert-success" role="alert">
                    <h4 class="alert-heading">Update Successful!</h4>
                    <p>School information has been updated successfully.</p>
                    <hr>
                    <p>Updated School Details:</p>
                    <ul>
                        <li><strong>School Name:</strong> ${school.schoolName}</li>
                        <li><strong>Principal Name:</strong> ${school.principalName}</li>
                        <li><strong>Status:</strong> ${school.status}</li>
                    </ul>
                    <div class="mt-3">
                        <a href="newlySubmittedSchools" class="btn btn-primary">Back to School List</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>