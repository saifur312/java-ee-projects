<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="regForm" method="post">
		Name: <input type="text" name="name" /> <br/> <br/>
		Email: <input type="text" name="email" /> <br/> <br/>
		Password: <input type="password" name="pass" /> <br/> <br/>
		Gender: <input type="radio" name="gender" value="Male"/> Male 
				<input type="radio" name="gender" value="Female"/> Female <br/> <br/>
		City: <select name="city">
				<option> Select City </option>
				<option> Dhaka </option>
				<option> Khulna </option>
				<option> Rajshahi </option>
				<option> Barishal </option>
			</select> <br/> <br/>
		<input type="submit" value="Register"/>
	</form>

</body>
</html>