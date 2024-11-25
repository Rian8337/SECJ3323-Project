<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="my-4">Edit User</h2>
        <form action="updateUser" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${user.name}">
            </div>
            <div class="mb-3">
                <label for="institution" class="form-label">Institution</label>
                <select class="form-select" id="institution" name="institution">
                    <option value="PPD" ${user.institution == 'PPD' ? 'selected' : ''}>PPD</option>
                    <option value="JPNJ" ${user.institution == 'JPNJ' ? 'selected' : ''}>JPNJ</option>
                    <option value="Student" ${user.institution == 'Student' ? 'selected' : ''}>Student</option>
                    <option value="Teacher" ${user.institution == 'Teacher' ? 'selected' : ''}>Teacher</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${user.email}">
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}">
            </div>
            <button type="submit" class="btn btn-primary">Update User</button>
            
        </form>
    </div>
</body>
</html>
