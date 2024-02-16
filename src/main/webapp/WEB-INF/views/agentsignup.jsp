<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins&display=swap">
    <title>Add Account</title>
    <style>
        body {
      margin: 0;
      padding: 0;
      display: flex;
      flex-direction: column;
      align-items: center;
      height: 100vh;
      background:  linear-gradient(45deg, rgb(3, 3, 6), rgba(21, 26, 194, 0.973));
      font-family: "Sansita Swashed", cursive;
  }

  .form-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 80vh;
            width: 80%; /* Specified width for the form container */
            max-width: 400px;
            margin: auto; /* Center the container horizontally */
        }

        form {
            width: 100%;
            background-color: rgba(255, 255, 255, 0.13);
            border-radius: 10px;
            backdrop-filter: blur(10px);
            border: 2px solid rgba(255, 255, 255, 0.1);
            box-shadow: 0 0 40px rgba(8, 7, 16, 0.6);
            padding: 30px 20px; /* Adjusted padding */
            box-sizing: border-box;
            text-align: center;
        }

        form * {
            font-family: 'Poppins', sans-serif;
            color: #ffffff;
            letter-spacing: 0.5px;
            outline: none;
            border: none;
        }

        form h3 {
            font-size: 24px; /* Adjusted font size */
            font-weight: 500;
            line-height: 30px; /* Adjusted line height */
            margin-bottom: 15px; /* Adjusted margin */
        }

        label {
            display: block;
            font-size: 14px; /* Adjusted font size */
            font-weight: 500;
            margin-bottom: 4px; /* Decreased the margin */
        }

        input {
            display: block;
            height: 35px; /* Adjusted height */
            width: 100%;
            background-color: rgba(255, 255, 255, 0.07);
            border-radius: 3px;
            padding: 0 10px;
            margin-bottom: 10px; /* Adjusted margin */
            font-size: 12px; /* Adjusted font size */
            font-weight: 300;
            box-sizing: border-box;
        }

        button {
            width: 80%;
            background-color: #ffffff;
            color: #080710;
            padding: 12px 0; /* Adjusted padding */
            font-size: 16px; /* Adjusted font size */
            font-weight: 600;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #f2f2f2;
        }

     </style>
</head>
<body>



<div class="form-container">
    <form action="afteragentsignupsubmit" method="POST">
       
        <label for="id">Enter Agent Number</label>
        <input type="text" name="id" placeholder="Agent Number" required>

        <label for="name"> Enter Name</label>
        <input type="text" name="name" placeholder="Name" required>

        <label for="contact">Enter Mobile No</label>
        <input type="text" name="contact" placeholder="Mobile" required>

        <label for="address">Enter Address</label>
        <input type="text" name="address" placeholder="address" required>

        <label for="email">Enter Email</label>
        <input type="text" name="email" placeholder="email" required>
    
         <label for="password">Enter Password</label>
         <input type="password" name="password" placeholder="password" required>
        
        <button type="submit">Add Account</button>

        
    </form>
</div>
    
      

</body>
</html>
