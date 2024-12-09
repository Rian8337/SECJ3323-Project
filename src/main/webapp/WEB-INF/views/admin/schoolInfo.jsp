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
                            <td>${school.schoolName}</td>
                        </tr>
                        <tr>
                            <th>Principal Name</th>
                            <td>${school.principalName}</td>
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
                                    ${school.status == 'Verified' ? 'bg-success' : 
                                      school.status == 'Pending' ? 'bg-warning text-dark' : 
                                      'bg-danger'}">
                                    ${school.status}
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <th>School ID</th>
                            <td>${school.schoolId}</td>
                        </tr>
                        <tr>
                            <th>Video</th>
                            <td>
                                <div>
                                    <img src="https://img.youtube.com/vi/${school.video.videoUrl.split('=')[1]}/hqdefault.jpg" alt="Video Thumbnail" width="150">
                                    <p>Created by: ${school.video.studentName}</p>
                                    <a href="${school.video.videoUrl}" target="_blank">Watch Video</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>

                <!-- Back and Update Buttons -->
                <div class="mt-3">
                    <a href="../admin/newlySubmittedSchools" class="btn btn-primary me-2">Back</a>
                    <a href="editSchool?id=${school.schoolId}" class="btn btn-warning">Update</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
