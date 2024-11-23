<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f7fc;
            font-family: 'Arial', sans-serif;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 40px;
        }
        h2 {
            color: #0066cc;
            font-size: 32px;
            font-weight: 600;
            margin-bottom: 30px;
        }
        .btn-back {
            background-color: #6c757d;
            color: #ffffff;
            font-weight: 600;
            margin-bottom: 20px;
        }
        .filter-section {
            margin-bottom: 20px;
        }
        .table th {
            background-color: #0066cc;
            color: #ffffff;
            text-align: center;
        }
        .table td {
            text-align: center;
        }
    </style>
    <script>
        function filterUsers() {
            var filterValue = document.getElementById("filter").value.toLowerCase();
            var rows = document.getElementsByTagName("tr");

            for (var i = 1; i < rows.length; i++) {
                var name = rows[i].getElementsByTagName("td")[0].innerText.toLowerCase();
                if (name.startsWith(filterValue) || filterValue === "") {
                    rows[i].style.display = "";
                } else {
                    rows[i].style.display = "none";
                }
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <a href="admin" class="btn btn-back">Back to Admin Panel</a>
        
        <h2 class="my-4">Manage Users</h2>

        <!-- Filter Section -->
        <div class="filter-section">
            <label for="filter" class="form-label">Filter by Name:</label>
            <select id="filter" class="form-select" onchange="filterUsers()">
                <option value="">All</option>
                <c:forEach var="letter" items="${['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']}">
                    <option value="${letter.toLowerCase()}">${letter}</option>
                </c:forEach>
                <c:forEach var="number" begin="0" end="9">
                    <option value="${number}">${number}</option>
                </c:forEach>
            </select>
        </div>

        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Institution</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.institution}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td>
                            <a href="editUser?id=${user.id}" class="btn btn-warning">Edit</a>
                            <a href="deleteUser?id=${user.id}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
