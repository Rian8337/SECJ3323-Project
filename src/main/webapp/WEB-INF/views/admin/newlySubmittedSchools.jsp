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

                <!-- Filter and Sort Section -->
                <div class="row mb-3">
                    <div class="col-md-4">
                        <input type="text" id="schoolNameFilter" onkeyup="filterSchools()" placeholder="Filter by School Name" class="form-control mb-2">
                    </div>
                    <div class="col-md-4">
                        <input type="text" id="districtFilter" onkeyup="filterSchools()" placeholder="Filter by District" class="form-control mb-2">
                    </div>
                    <div class="col-md-4">
                        <select id="statusFilter" onchange="filterSchools()" class="form-control mb-2">
                            <option value="">Filter by Status</option>
                            <option value="Verified">Verified</option>
                            <option value="Pending">Pending</option>
                            <option value="Rejected">Rejected</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <input type="text" id="equipmentLevelFilter" onkeyup="filterSchools()" placeholder="Filter by Equipment Level" class="form-control mb-2">
                    </div>
                    <div class="col-md-4">
                        <select id="sortByEquipmentLevel" onchange="sortTable()" class="form-control mb-2">
                            <option value="desc">Sort by Equipment Level: Highest to Lowest</option>
                            <option value="asc">Sort by Equipment Level: Lowest to Highest</option>
                        </select>
                    </div>
                </div>

                <!-- Table -->
                <div class="table-container">
                    <table class="table table-bordered" id="schoolTable">
                        <thead>
                            <tr>
                                <th>School Name</th>
                                <th>District</th>
                                <th>Status</th>
                                <th>Equipment Level</th>
                                <th>Total Students</th>
                                <th>Total Videos</th>
                                <th>View</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="school" items="${schools}">
                                <tr>
                                    <td>${school.schoolName}</td>
                                    <td>${school.district}</td>
                                    <td>
                                        <span class="badge 
                                            ${school.status == 'Verified' ? 'bg-success' : 
                                              school.status == 'Pending' ? 'bg-warning text-dark' : 
                                              'bg-danger'}">
                                            ${school.status}
                                        </span>
                                    </td>
                                    <td>${school.equipmentLevel}</td>
                                    <td>${school.totalStudents}</td>
                                    <td>${school.totalVideos}</td>
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
                    <a href="../admin" class="btn btn-primary">Back</a>
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript for filtering and sorting -->
    <script>
        // Function to filter schools based on search criteria
        function filterSchools() {
            // Get filter values
            var schoolNameFilter = document.getElementById('schoolNameFilter').value.toLowerCase();
            var districtFilter = document.getElementById('districtFilter').value.toLowerCase();
            var statusFilter = document.getElementById('statusFilter').value.toLowerCase();
            var equipmentLevelFilter = document.getElementById('equipmentLevelFilter').value.toLowerCase();
        
            // Get all rows from the table except the header row
            var rows = document.querySelectorAll('#schoolTable tbody tr');
        
            // Loop through all rows and hide those that don't match the filter criteria
            rows.forEach(function(row) {
                var schoolName = row.querySelector('td:nth-child(1)').textContent.toLowerCase();
                var district = row.querySelector('td:nth-child(2)').textContent.toLowerCase();
                var status = row.querySelector('td:nth-child(3)').textContent.toLowerCase();
                var equipmentLevel = row.querySelector('td:nth-child(4)').textContent.toLowerCase();
        
                // Check if the row matches all filter conditions
                if (schoolName.indexOf(schoolNameFilter) > -1 &&
                    district.indexOf(districtFilter) > -1 &&
                    status.indexOf(statusFilter) > -1 &&
                    equipmentLevel.indexOf(equipmentLevelFilter) > -1) {
                    row.style.display = '';  // Show the row if it matches the filters
                } else {
                    row.style.display = 'none';  // Hide the row if it does not match
                }
            });
        }

        // Function to sort the table by equipment level
        function sortTable() {
            var table = document.getElementById("schoolTable");
            var rows = Array.from(table.rows).slice(1); // Get all rows except the header
        
            // Get the selected sort direction
            var sortDirection = document.getElementById('sortByEquipmentLevel').value;
        
            rows.sort(function(rowA, rowB) {
                var levelA = parseInt(rowA.cells[3].textContent); // Equipment Level for rowA
                var levelB = parseInt(rowB.cells[3].textContent); // Equipment Level for rowB
        
                if (sortDirection === 'desc') {
                    return levelB - levelA; // Sort descending
                } else {
                    return levelA - levelB; // Sort ascending
                }
            });
        
            // Re-order the rows in the table
            rows.forEach(function(row) {
                table.appendChild(row);
            });
        }
    </script>
</body>
</html>
