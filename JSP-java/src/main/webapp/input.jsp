<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Form & Scope Demo</title>
</head>
<body>
<h2>User Information Form</h2>
<form action="display.jsp" method="post">
    <label>Name:</label>
    <input type="text" name="userName" required><br><br>

    <label>Favorite Color:</label>
    <input type="text" name="favColor" required><br><br>

    <button type="submit">Submit and Test Scopes</button>
</form>
</body>
</html>