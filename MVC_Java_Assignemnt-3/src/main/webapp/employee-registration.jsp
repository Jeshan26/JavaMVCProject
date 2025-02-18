<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="./css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Register 
            <span class="register-link"> 
                <a href="Login.jsp">Login</a>
            </span>
        </h2>
        <form action="<%=request.getContextPath()%>/signupServlet" method="post">
            <label for="username">Username</label>
            <input 
            	type="text" 
            	id="username" 
            	name="username" 
            	required 
            	minlength="5" 
            	maxlength="5" 
            	pattern="^[a-zA-Z0-9_]{5}$" 
            	title="Username must be exactly 5 characters (letters, numbers, underscore only)." 
            	/>

            <label for="password">Password</label>
            <input 
            	type="password" 
            	id="password" 
            	name="password" 
            	required 
            	pattern="^[a-zA-Z0-9$_]*$" 
            	title="Only letters, numbers, $, and underscore (_) are allowed." 
            />

            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
