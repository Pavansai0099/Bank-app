<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
<style>  .button {
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
        .input{
        padding:7px;
        border-radius:10px;
        position:fixed;
        left:49%;
        }
        label{
        
        }
        </style>
</head>
<body>
 
   <div class="container">
   <h2 align="center">Customer Details</h2>
    <form action="CustomerDetailsServlet" method="post">
    
        <label for="accountno">Account Number:</label>
        <br>
    
        <input type="text" id="accountno" class="input" name="accountno" required><br><br>
        <input type="submit" class="button" value="View Customer">
    </form>
    </div>
</body>
</html>