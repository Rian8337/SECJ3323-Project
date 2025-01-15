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
                    <a href="viewUsers" class="btn btn-light mb-2">User Administration</a>
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
                            <li class="breadcrumb-item"><a href="#">Administration</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Add School</li>
                        </ol>
                    </nav>
                </div>

                <h2>Add New School Information</h2>
                
                <div class="form-container">
                    <!-- Single Form Starts Here -->
                    <form action="submitSchool" method="post" modelAttribute="school">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">School Name *</label>
                                <input type="text" class="form-control" name="name" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Phone *</label>
                                <input type="tel" class="form-control" name="phone" required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">Admission Date *</label>
                                <input type="date" class="form-control" name="admissionDate" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">District *</label>
                                <input type="text" class="form-control" name="district" required>
                            </div>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">Email *</label>
                                <input type="email" class="form-control" name="email" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Board of Province *</label>
                                <input type="text" class="form-control" name="boardOfProvince" required>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Address *</label>
                            <textarea class="form-control" name="address" rows="3" required></textarea>
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
</body>
</html>
