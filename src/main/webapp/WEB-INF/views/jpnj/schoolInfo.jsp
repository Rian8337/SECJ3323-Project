<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>School Information</title>
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
                    <a href="#" class="btn btn-light mb-2">School Verification</a>
                    <a href="#" class="btn btn-light mb-2">Reports</a>
                    <a href="#" class="btn btn-light mb-2">Settings</a>
                </div>
            </div>

            <!-- Main content -->
            <div class="col-md-10 main-content">
                <!-- Breadcrumb -->
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="admin">Home</a></li>
                        <li class="breadcrumb-item"><a href="admin">JPNJ</a></li>
                        <li class="breadcrumb-item"><a href="newlySubmittedSchools">Newly Submitted Schools</a></li>
                        <li class="breadcrumb-item active" aria-current="page">School Information</li>
                    </ol>
                </nav>

                <h2>School Information</h2>

                <!-- School Information Table -->
                <div class="table-container">
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
                            <th>Admission Date</th>
                            <td>${school.admissionDate}</td>
                        </tr>
                        <tr>
                            <th>Status</th>
                            <td>
                                <span class="badge 
                                    ${school.verificationStatus == 'VERIFIED' ? 'bg-success' : 
                                        school.verificationStatus == 'PENDING' ? 'bg-warning text-dark' : 
                                        'bg-danger'}">
                                    ${school.verificationStatus}
                                </span>
                            </td>
                        </tr>
                    </table>
                </div>

                <!-- Back and Update Buttons -->
                <div class="mt-3">
                    <form action="verifySchool" method="post" style="display: inline;">
                        <input type="hidden" name="id" value="${school.id}">
                        <input type="hidden" name="action" value="accept">
                        <button type="submit" class="btn btn-success me-2">Accept</button>
                    </form>
                    <form action="verifySchool" method="post" style="display: inline;">
                        <input type="hidden" name="id" value="${school.id}">
                        <input type="hidden" name="action" value="reject">
                        <button type="submit" class="btn btn-danger">Reject</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
