<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add School Information</title>
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
        .form-container {
            max-width: 800px;
            margin: 0 auto;
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
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="welcome">Home</a></li>
                        <li class="breadcrumb-item">Teacher</li>
                        <li class="breadcrumb-item active">SCHOOL SUBMISSION</li>
                    </ol>
                </nav>

                <h2>Add New School Information</h2>
                
                <div class="form-container">
                    <!-- Single Form Starts Here -->
                    <form action="submitSchool" method="post">
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">School Name *</label>
                                <input type="text" class="form-control" name="schoolName" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Phone *</label>
                                <input type="tel" class="form-control" name="phone" required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">Principal Name *</label>
                                <input type="text" class="form-control" name="principalName" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Admission Date *</label>
                                <input type="date" class="form-control" name="admissionDate" required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">District *</label>
                                <input type="text" class="form-control" name="district" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Board of Province *</label>
                                <input type="text" class="form-control" name="boardOfProvince" required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">Student Count *</label>
                                <input type="number" class="form-control" name="studentCount" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">School ID *</label>
                                <input type="text" class="form-control" name="schoolId" required>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Address *</label>
                            <textarea class="form-control" name="address" rows="3" required></textarea>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email *</label>
                            <input type="email" class="form-control" name="email" required>
                        </div>

                        <!-- Equipment Section -->
                        <h3 class="mt-4">Equipment</h3>
                        <p>Select the equipment available at the school:</p>

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="tvProgramShow" id="tvProgramShow">
                                    <label class="form-check-label" for="tvProgramShow">TV Program/Show corner/room</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="smartphone" id="smartphone">
                                    <label class="form-check-label" for="smartphone">Smartphone</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="externalMic" id="externalMic">
                                    <label class="form-check-label" for="externalMic">External Mic (Lavalier/Clip Mic)</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="monopod" id="monopod">
                                    <label class="form-check-label" for="monopod">Monopod</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="ringLight" id="ringLight">
                                    <label class="form-check-label" for="ringLight">Ring Light</label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="editingCorner" id="editingCorner">
                                    <label class="form-check-label" for="editingCorner">Editing Corner/Room</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="webcam" id="webcam">
                                    <label class="form-check-label" for="webcam">Webcam</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="tripod" id="tripod">
                                    <label class="form-check-label" for="tripod">Tripod</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="mobileLighting" id="mobileLighting">
                                    <label class="form-check-label" for="mobileLighting">Mobile lighting</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="mobileGreenScreen" id="mobileGreenScreen">
                                    <label class="form-check-label" for="mobileGreenScreen">Mobile Green Screen set</label>
                                </div>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="editingSoftwareOpenSource" id="editingSoftwareOpenSource">
                                    <label class="form-check-label" for="editingSoftwareOpenSource">Editing Software (Open Source)</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="camera" id="camera">
                                    <label class="form-check-label" for="camera">Camera</label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="greenScreenPermanent" id="greenScreenPermanent">
                                    <label class="form-check-label" for="greenScreenPermanent">Green Screen (permanent)</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="editingSoftwarePro" id="editingSoftwarePro">
                                    <label class="form-check-label" for="editingSoftwarePro">Editing Software (Pro/paid version)</label>
                                </div>
                            </div>
                        </div>

                        <!-- Hidden Field for Equipment Level -->
                        <input type="hidden" name="equipmentLevel" id="equipmentLevel">

                        <!-- Buttons -->
                        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            <button type="reset" class="btn btn-secondary me-md-2">Reset</button>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        // Update equipment level based on selected checkboxes
        document.querySelectorAll('input[type="checkbox"]').forEach(checkbox => {
            checkbox.addEventListener('change', updateEquipmentLevel);
        });

        function updateEquipmentLevel() {
            const checkedCount = document.querySelectorAll('input[type="checkbox"]:checked').length;
            let level;

            if (checkedCount <= 4) {
                level = 1; // Level 1
            } else if (checkedCount <= 10) {
                level = 2; // Level 2
            } else {
                level = 3; // Level 3
            }

            document.getElementById('equipmentLevel').value = level;
        }
    </script>
</body>
</html>
