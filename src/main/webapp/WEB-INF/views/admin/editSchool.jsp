<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit School Information</title>
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
                <h2>Edit School Information</h2>

                <!-- Form for updating school -->
                <form:form id="editSchoolForm" action="updateSchool" method="post" modelAttribute="school">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="hidden" name="id" value="${school.id}">
                    
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" class="form-control" name="name" value="${school.name}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">District</label>
                        <input type="text" class="form-control" name="district" value="${school.district}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Address</label>
                        <input type="text" class="form-control" name="address" value="${school.address}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" class="form-control" name="email" value="${school.email}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Phone</label>
                        <input type="text" class="form-control" name="phone" value="${school.phone}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Admission Date</label>
                        <input type="text" class="form-control" name="admissionDate" value="${school.admissionDate}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label class="form-label">Status</label>
                        <select class="form-control" name="status">
                            <option value="Verified" ${school.verificationStatus == 'VERIFIED' ? 'selected' : ''}>Verified</option>
                            <option value="Pending" ${school.verificationStatus == 'PENDING' ? 'selected' : ''}>Pending</option>
                            <option value="Rejected" ${school.verificationStatus == 'REJECTED' ? 'selected' : ''}>Rejected</option>
                        </select>
                    </div>
                    
                    <!-- Buttons: Update and Cancel -->
                    <button type="button" class="btn btn-warning" onclick="showConfirmModal()">Update</button>
                    <a href="newlySubmittedSchools" class="btn btn-secondary">Cancel</a>
                </form:form>
            </div>
        </div>
    </div>

    <!-- Confirmation Modal -->
    <div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="confirmModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Confirm Update</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Are you sure you want to update the school information?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary" onclick="submitForm()">Confirm</button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function showConfirmModal() {
            var myModal = new bootstrap.Modal(document.getElementById('confirmModal'), {});
            myModal.show();
        }

        function submitForm() {
            document.getElementById('editSchoolForm').submit();
        }
    </script>
</body>
</html>
