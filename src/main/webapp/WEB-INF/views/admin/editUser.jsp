<form action="/admin/editUser" method="post">
    <!-- CSRF Token -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <!-- Hidden field for user ID -->
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
