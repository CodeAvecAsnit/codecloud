<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Students</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            padding: 20px;
        }
        
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }
        
        .button-group {
            margin-bottom: 25px;
            text-align: center;
        }
        
        .btn {
            padding: 10px 20px;
            margin: 5px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-weight: bold;
            display: inline-block;
            transition: all 0.3s ease;
        }
        
        .btn-primary {
            background-color: #667eea;
            color: white;
        }
        
        .btn-primary:hover {
            background-color: #5568d3;
            transform: translateY(-2px);
        }
        
        .btn-success {
            background-color: #48bb78;
            color: white;
        }
        
        .btn-success:hover {
            background-color: #38a169;
        }
        
        .btn-warning {
            background-color: #ed8936;
            color: white;
        }
        
        .btn-warning:hover {
            background-color: #dd6b20;
        }
        
        .btn-danger {
            background-color: #f56565;
            color: white;
        }
        
        .btn-danger:hover {
            background-color: #e53e3e;
        }
        
        .table-responsive {
            overflow-x: auto;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        
        th {
            background-color: #667eea;
            color: white;
            padding: 12px;
            text-align: left;
            font-weight: bold;
        }
        
        td {
            padding: 12px;
            border-bottom: 1px solid #e0e0e0;
        }
        
        tr:hover {
            background-color: #f9f9f9;
        }
        
        .no-data {
            text-align: center;
            color: #999;
            padding: 40px;
            font-size: 1.1em;
        }
        
        .action-buttons {
            display: flex;
            gap: 8px;
        }
        
        .action-buttons .btn {
            padding: 6px 12px;
            font-size: 0.9em;
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Student List</h1>
        
        <div class="button-group">
            <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Home</a>
            <a href="${pageContext.request.contextPath}/students/new" class="btn btn-success">Add New Student</a>
        </div>
        
        <div class="table-responsive">
            <c:if test="${not empty students}">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>GPA</th>
                            <th>Department</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.id}</td>
                                <td>${student.name}</td>
                                <td>${student.email}</td>
                                <td>${student.phone}</td>
                                <td>${student.gpa}</td>
                                <td>${student.department}</td>
                                <td>
                                    <div class="action-buttons">
                                        <a href="${pageContext.request.contextPath}/students/${student.id}" class="btn btn-primary">View</a>
                                        <a href="${pageContext.request.contextPath}/students/edit/${student.id}" class="btn btn-warning">Edit</a>
                                        <a href="${pageContext.request.contextPath}/students/delete/${student.id}" class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            
            <c:if test="${empty students}">
                <div class="no-data">
                    <p>No students found. <a href="${pageContext.request.contextPath}/students/new">Add one now!</a></p>
                </div>
            </c:if>
        </div>
    </div>
</body>
</html>
