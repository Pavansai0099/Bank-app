<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Customer</title>
</head>
<style>
.button {
    padding: 10px;
    background-color: #007BFF;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    position:fixed;
    top:65%;
    left:48%;
    
}

.button:hover {
    background-color: #0056b3;
    
}

 .container {
    background-color: #fff;
    padding: 20px;
    
    position:fixed;
    top:30%;
    right:35%;
    width:300px;
    height:250px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
.accountno{
padding:7px;
border-radius:10px;

position:fixed;
left:49%;
}
label{

}
</style>
<body>

<div class=container>
<h2 align="center">Delete Customer</h2>
    <form action="DeleteCustomerServlet" method="post">
        <label for="accountno">Account Number:</label>
        <br>
        <input type="text" class="accountno" name="accountno" required><br><br>
        <button class="button" >Delete Customer</button>
    </form>
    </div>
</body>
</html>