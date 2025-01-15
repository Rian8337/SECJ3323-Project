<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	    <style>
	        body {
	            font-family: Arial, sans-serif;
	            background-color: #f4f6f9;
	        }
	
	        .sidebar {
	            background-color: #2c3e50;
	            min-height: 100vh;
	            color: white;
	            padding: 20px;
	        }
	
	       .sidebar a {
	    color: ;  /* Default text color */
	    font-weight: 500;
	    padding: 10px 15px;
	    border-radius: 5px;
	    margin-bottom: 10px;
	    display: block;
	    text-decoration: none;
	}
	        .sidebar a:hover {
	            color: #3498db;
	            background-color: #34495e;
	            border-radius: 4px;
	        }
	
	        .main-content {
	            padding: 20px;
	        }
	
	        .status-box {
	            margin-top: 50px;
	        }
	
	.breadcrumb-container {
	    background-color: #d1e7ff;  
	    margin-bottom: 0; 
	    width: 100%; 
	    padding: 20px 0;  
	}
	
	
	
	        .breadcrumb a {
	            text-decoration: none;
	            color: #007bff;
	        }
	
	        .breadcrumb a:hover {
	            text-decoration: underline;
	        }
	
	        .breadcrumb .active {
	            color: blue;
	        }
	
	        h1 {
	            font-size: 2.5rem;
	            color: #2c3e50;
	            font-weight: 700;
	        }
	
	        h3 {
	            color: black;
	        }
	
	        .btn-primary {
	            background-color: #3498db;
	            border-color: #3498db;
	        }
	
	        .btn-primary:hover {
	            background-color: #2980b9;
	            border-color: #2980b9;
	        }
	
	        .breadcrumb-item a {
	            font-size: 1rem;
	            font-weight: 600;
	        }
	
	        .breadcrumb-item.active {
	            font-size: 1rem;
	            font-weight: 600;
	            color: #7f8c8d;
	        }
	
	      /* Customize form buttons */
	form button {
	    background-color: blue;  /* Blue background */
	    color: red;  /* Red text color */
	    border: none;
	    padding: 10px 20px;
	    font-size: 1.1rem;
	    border-radius: 5px;
	    cursor: pointer;
	    transition: background-color 0.3s, color 0.3s;
	}
	
	form button:hover {
	    background-color: #1abc9c;  /* Green background on hover */
	    color: white;  /* White text on hover */
	}
	
	
	        /* Responsive Design */
	        @media (max-width: 768px) {
	            .sidebar {
	                width: 100%;
	                height: auto;
	                margin-bottom: 20px;
	            }
	            
	            .main-content {
	                padding: 15px;
	            }
	
	            .breadcrumb-container {
	                padding-left: 0;
	            }
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
                    <a href="admin/viewUsers" class="btn btn-light mb-2">User Administration</a>
                    <a href="#" class="btn btn-light mb-2">Teachers</a>
                    <a href="#" class="btn btn-light mb-2">Financial</a>
                    <a href="#" class="btn btn-light mb-2">Contents</a>
                    <a href="#" class="btn btn-light mb-2">Settings</a>
                </div>
            </div>

            <!-- Main Content -->
            <div class="col-md-10 main-content">
                <!-- Breadcrumb Navigation -->
                <div class="breadcrumb-container mb-4">
                    <h3>School Administration</h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Administration</li>
                        </ol>
                    </nav>
                </div>

                <!-- Welcome Message -->
                <h1>WELCOME, ADMIN..</h1>

                <!-- Newly Submitted Schools Button -->
                <form action="admin/addSchool" method="get">
                    <button type="submit" class="btn btn-primary">Add School</button>
                </form>
                <!-- New View Schools Button Added --> <!-- edited -->
                <form action="${pageContext.request.contextPath}/admin/newlySubmittedSchools" method="get"> <!-- edited -->
                    <button type="submit" class="btn btn-primary mt-3">View Schools</button> <!-- edited -->
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
