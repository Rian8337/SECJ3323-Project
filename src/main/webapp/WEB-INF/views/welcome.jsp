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
                    <p class="text-danger">NOT SUBMITTED</p>
                    
                    <form action="addSchool" method="get">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
