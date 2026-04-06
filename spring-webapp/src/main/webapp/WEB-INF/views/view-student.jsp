<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }
        
        .container {
            max-width: 600px;
            margin: 0 auto;
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
        }
        
        h1 {
            color: #333;
            margin-bottom: 30px;
            text-align: center;
        }
        
        .details-group {
            margin-bottom: 20px;
            padding-bottom: 15px;
            border-bottom: 1px solid #e0e0e0;
        }
        
        .details-group:last-child {
            border-bottom: none;
        }
        
        .label {
            color: #667eea;
            font-weight: bold;
            margin-bottom: 5px;
        }
        
        .value {
            color: #333;
            font-size: 1.1em;
            margin-left: 10px;
        }
        
        .button-group {
            display: flex;
            gap: 10px;
            justify-content: center;
            margin-top: 30px;
            flex-wrap: wrap;
        }
        
        .btn {
            padding: 12px 30px;
            font-size: 1em;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-weight: bold;
            transition: all 0.3s ease;
            display: inline-block;
        }
        
        .btn-primary {
            background-color: #667eea;
            color: white;
        }
        
        .btn-primary:hover {
            background-color: #5568d3;
            transform: translateY(-2px);
        }
        
        .btn-warning {
            background-color: #ed8936;
            color: white;
        }
        
        .btn-warning:hover {
            background-color: #dd6b20;
            transform: translateY(-2px);
        }
        
        .btn-danger {
            background-color: #f56565;
            color: white;
        }
        
        .btn-danger:hover {
            background-color: #e53e3e;
            transform: translateY(-2px);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Student Details</h1>
        
        <div class="details-group">
            <div class="label">Student ID:</div>
            <div class="value">${student.id}</div>
        </div>
        
        <div class="details-group">
            <div class="label">Name:</div>
            <div class="value">${student.name}</div>
        </div>
        
        <div class="details-group">
            <div class="label">Email:</div>
            <div class="value">${student.email}</div>
        </div>
        
        <div class="details-group">
            <div class="label">Phone:</div>
            <div class="value">${student.phone}</div>
        </div>
        
        <div class="details-group">
            <div class="label">GPA:</div>
            <div class="value">${student.gpa}</div>
        </div>
        
        <div class="details-group">
            <div class="label">Department:</div>
            <div class="value">${student.department}</div>
        </div>
        
        <div class="button-group">
            <a href="${pageContext.request.contextPath}/students" class="btn btn-primary">Back to List</a>
            <a href="${pageContext.request.contextPath}/students/edit/${student.id}" class="btn btn-warning">Edit</a>
            <a href="${pageContext.request.contextPath}/students/delete/${student.id}" class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete</a>
        </div>
    </div>
</body>
</html>
