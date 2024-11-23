<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Users</title>
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

        .table {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .table th {
            background-color: #0066cc;
            color: #ffffff;
            text-align: center;
        }

        .table td {
            text-align: center;
        }

        .btn-warning {
            background-color: #ffcc00;
            border-color: #ffcc00;
            color: #ffffff;
            transition: background-color 0.3s ease;
        }

        .btn-warning:hover {
            background-color: #e6b800;
            border-color: #e6b800;
        }

        .btn-danger {
            background-color: #e74c3c;
            border-color: #e74c3c;
            color: #ffffff;
            transition: background-color 0.3s ease;
        }

        .btn-danger:hover {
            background-color: #c0392b;
            border-color: #c0392b;
        }

        .btn {
            font-size: 14px;
            font-weight: 600;
            padding: 8px 16px;
        }

        .table-striped tbody tr:nth-child(odd) {
            background-color: #f9f9f9;
        }

        .table-bordered td, .table-bordered th {
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="my-4">Manage Users</h2>
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
