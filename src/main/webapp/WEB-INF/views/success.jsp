<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success - School Information</title>
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
        .success-message {
            margin-top: 30px;
            margin-bottom: 30px;
        }
        .button-container {
            margin-top: 20px;
        }
        .nav-item {
            margin-bottom: 10px;
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
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="welcome">Home</a></li>
                        <li class="breadcrumb-item">Teacher</li>
                        <li class="breadcrumb-item active">SCHOOL SUBMISSION</li>
                    </ol>
                </nav>

                <div class="success-message">
                    <h3>Details Saved Successfully</h3>
                </div>

                <div class="button-container">
                    <button class="btn btn-primary" onclick="cancelOperation()">
                        return
                    </button>
                </div>
            </div>
        </div>
    </div>

    <script>

        function cancelOperation() {
            window.location.href = 'welcome';
        }
    </script>
</body>
</html>