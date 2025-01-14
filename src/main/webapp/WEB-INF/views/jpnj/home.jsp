<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JPNJ Dashboard</title>
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
                    <a href="newlySubmittedSchools" class="btn btn-light mb-2">School Verification</a>
                    <a href="#" class="btn btn-light mb-2">Reports</a>
                    <a href="#" class="btn btn-light mb-2">Settings</a>
                </div>
            </div>

            <!-- Main content -->
            <div class="col-md-10 main-content">
                <h2>Welcome to JPNJ Dashboard</h2>
                <div class="row mt-4">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Pending Verifications</h5>
                                <p class="card-text">View and verify newly submitted school information</p>
                                <a href="newlySubmittedSchools" class="btn btn-primary">View Schools</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>