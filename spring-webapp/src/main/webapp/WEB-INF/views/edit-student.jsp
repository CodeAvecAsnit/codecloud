<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
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
        
        .form-group {
            margin-bottom: 20px;
        }
        
        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
            font-weight: 500;
        }
        
        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="number"],
        textarea,
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 1em;
            font-family: inherit;
            transition: border-color 0.3s ease;
        }
        
        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="tel"]:focus,
        input[type="number"]:focus,
        textarea:focus,
        select:focus {
            outline: none;
            border-color: #f5576c;
            box-shadow: 0 0 5px rgba(245, 87, 108, 0.3);
        }
        
        .button-group {
            display: flex;
            gap: 10px;
            justify-content: center;
            margin-top: 30px;
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
        
        .btn-warning {
            background-color: #ed8936;
            color: white;
        }
        
        .btn-warning:hover {
            background-color: #dd6b20;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(237, 137, 54, 0.4);
        }
        
        .btn-secondary {
            background-color: #999;
            color: white;
        }
        
        .btn-secondary:hover {
            background-color: #777;
            transform: translateY(-2px);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Student</h1>
        
        <form method="POST" action="${pageContext.request.contextPath}/students/update">
            <input type="hidden" name="id" value="${student.id}">
            
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${student.name}" required>
            </div>
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${student.email}" required>
            </div>
            
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" value="${student.phone}" required>
            </div>
            
            <div class="form-group">
                <label for="gpa">GPA:</label>
                <input type="number" id="gpa" name="gpa" step="0.01" value="${student.gpa}" required>
            </div>
            
            <div class="form-group">
                <label for="department">Department:</label>
                <select id="department" name="department" required>
                    <option value="">-- Select Department --</option>
                    <option value="Computer Science" <c:if test="${student.department == 'Computer Science'}">selected</c:if>>Computer Science</option>
                    <option value="Engineering" <c:if test="${student.department == 'Engineering'}">selected</c:if>>Engineering</option>
                    <option value="Business" <c:if test="${student.department == 'Business'}">selected</c:if>>Business</option>
                    <option value="Arts" <c:if test="${student.department == 'Arts'}">selected</c:if>>Arts</option>
                    <option value="Science" <c:if test="${student.department == 'Science'}">selected</c:if>>Science</option>
                    <option value="Medicine" <c:if test="${student.department == 'Medicine'}">selected</c:if>>Medicine</option>
                </select>
            </div>
            
            <div class="button-group">
                <button type="submit" class="btn btn-warning">Update Student</button>
                <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
