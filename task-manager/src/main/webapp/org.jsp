<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Organization Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .section-title {
            color: #0d6efd;
            margin-bottom: 20px;
            border-bottom: 2px solid #0d6efd;
            padding-bottom: 10px;
        }
        .result-box {
            background-color: #e9ecef;
            padding: 15px;
            border-radius: 5px;
            margin-top: 20px;
            min-height: 100px;
            max-height: 400px;
            overflow-y: auto;
        }
        .btn-group-custom {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center mb-4">Organization Management</h1>
        
        <!-- Organization Form -->
        <form id="orgForm">
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="orgId" class="form-label">Organization ID (for Update/Read)</label>
                    <input type="number" class="form-control" id="orgId" name="id" placeholder="Enter ID to read/update">
                </div>
                <div class="col-md-6">
                    <label for="version" class="form-label">Version</label>
                    <input type="number" class="form-control" id="version" name="version" placeholder="Version (optional)">
                </div>
            </div>

            <h5 class="section-title">Basic Information</h5>
            <div class="row mb-3">
                <div class="col-md-12">
                    <label for="name" class="form-label">Organization Name *</label>
                    <input type="text" class="form-control" id="name" name="name" required placeholder="Enter organization name">
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-12">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" name="description" rows="3" placeholder="Enter description"></textarea>
                </div>
            </div>

            <h5 class="section-title">Address Information</h5>
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="addressLine1" class="form-label">Address Line 1</label>
                    <input type="text" class="form-control" id="addressLine1" name="addressLine1" placeholder="Street address">
                </div>
                <div class="col-md-6">
                    <label for="addressLine2" class="form-label">Address Line 2</label>
                    <input type="text" class="form-control" id="addressLine2" name="addressLine2" placeholder="Apt, suite, etc.">
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-4">
                    <label for="city" class="form-label">City</label>
                    <input type="text" class="form-control" id="city" name="city" placeholder="City">
                </div>
                <div class="col-md-4">
                    <label for="state" class="form-label">State</label>
                    <input type="text" class="form-control" id="state" name="state" placeholder="State">
                </div>
                <div class="col-md-4">
                    <label for="zipCode" class="form-label">Zip Code</label>
                    <input type="text" class="form-control" id="zipCode" name="zipCode" placeholder="ZIP">
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-12">
                    <label for="country" class="form-label">Country</label>
                    <input type="text" class="form-control" id="country" name="country" placeholder="Country">
                </div>
            </div>

            <h5 class="section-title">Contact Information</h5>
            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="phoneNumber" class="form-label">Phone Number</label>
                    <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Phone number">
                </div>
                <div class="col-md-6">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Email address">
                </div>
            </div>

            <div class="btn-group-custom d-flex gap-2">
                <button type="button" class="btn btn-primary flex-fill" onclick="createOrg()">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                    </svg>
                    Create
                </button>
                <button type="button" class="btn btn-warning flex-fill" onclick="updateOrg()">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                    </svg>
                    Update
                </button>
                <button type="button" class="btn btn-success flex-fill" onclick="readOrg()">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                        <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                        <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                    </svg>
                    Read
                </button>
                <button type="button" class="btn btn-secondary flex-fill" onclick="clearForm()">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                    </svg>
                    Clear
                </button>
            </div>
        </form>

        <!-- Result Display -->
        <div class="result-box" id="resultBox">
            <strong>Result:</strong>
            <pre id="resultText" style="margin-top: 10px; white-space: pre-wrap;">Perform an operation to see results here...</pre>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        const contextPath = '<%= request.getContextPath() %>';
        const servletPath = contextPath + '/org';

        function displayResult(message, isError = false) {
            const resultText = document.getElementById('resultText');
            resultText.textContent = message;
            resultText.style.color = isError ? 'red' : 'green';
        }

        function displayJSON(data) {
            const resultText = document.getElementById('resultText');
            resultText.textContent = JSON.stringify(data, null, 2);
            resultText.style.color = 'blue';
        }

        function getFormData() {
            const formData = new URLSearchParams();
            const form = document.getElementById('orgForm');
            const inputs = form.querySelectorAll('input, textarea');
            
            inputs.forEach(input => {
                if (input.value && input.value.trim() !== '') {
                    formData.append(input.name, input.value.trim());
                }
            });
            
            return formData;
        }

        function createOrg() {
            const name = document.getElementById('name').value.trim();
            if (!name) {
                displayResult('Error: Organization name is required!', true);
                return;
            }

            const formData = getFormData();
            // Remove id and version for create operation
            formData.delete('id');
            formData.delete('version');

            fetch(servletPath + '/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: formData
            })
            .then(response => response.json())
            .then(data => {
                displayResult('Success: ' + data);
            })
            .catch(error => {
                displayResult('Error: ' + error.message, true);
            });
        }

        function updateOrg() {
            const orgId = document.getElementById('orgId').value.trim();
            if (!orgId) {
                displayResult('Error: Organization ID is required for update!', true);
                return;
            }

            const name = document.getElementById('name').value.trim();
            if (!name) {
                displayResult('Error: Organization name is required!', true);
                return;
            }

            const formData = getFormData();

            fetch(servletPath + '/' + orgId + '/', {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: formData
            })
            .then(response => response.json())
            .then(data => {
                displayResult('Success: ' + data);
            })
            .catch(error => {
                displayResult('Error: ' + error.message, true);
            });
        }

        function readOrg() {
            const orgId = document.getElementById('orgId').value.trim();
            if (!orgId) {
                displayResult('Error: Organization ID is required for read!', true);
                return;
            }

            fetch(servletPath + '/' + orgId + '/', {
                method: 'GET'
            })
            .then(response => response.json())
            .then(data => {
                // Populate form with data
                if (data && typeof data === 'object') {
                    document.getElementById('orgId').value = data.id || '';
                    document.getElementById('version').value = data.version || '';
                    document.getElementById('name').value = data.name || '';
                    document.getElementById('description').value = data.description || '';
                    document.getElementById('addressLine1').value = data.addressLine1 || '';
                    document.getElementById('addressLine2').value = data.addressLine2 || '';
                    document.getElementById('city').value = data.city || '';
                    document.getElementById('state').value = data.state || '';
                    document.getElementById('zipCode').value = data.zipCode || '';
                    document.getElementById('country').value = data.country || '';
                    document.getElementById('phoneNumber').value = data.phoneNumber || '';
                    document.getElementById('email').value = data.email || '';
                    
                    displayJSON(data);
                } else {
                    displayResult('Success: ' + JSON.stringify(data));
                }
            })
            .catch(error => {
                displayResult('Error: ' + error.message, true);
            });
        }

        function clearForm() {
            document.getElementById('orgForm').reset();
            displayResult('Form cleared. Ready for new entry.');
        }
    </script>
</body>
</html>