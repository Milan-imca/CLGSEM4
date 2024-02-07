<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
</head>

<body>
  <h2>Login Page</h2>
  <form action="Home.php" method="post">
    <label for="username">username : </label>
    <input type="text" name="username" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d@!@#$%^&*]{8,}$"
      required>
    <br>
    <label for="password">password : </label>
    <input type="password" name="password" required>
    <br>

    <a href="Forgot_password.php">Forgot Password?</a><br>
    <input type="submit" value="LOGIN">
  </form>
</body>

</html>