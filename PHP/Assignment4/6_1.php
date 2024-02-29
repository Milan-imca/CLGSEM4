<!-- Q:6 Write a PHP script for login information once user loged in using remember me then next time credential will appear on login page. -->

<!DOCTYPE html>
</head>

<body>
  <h1>Login</h1>
  <form action="6_2.php" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" <?php if (isset($_COOKIE['username'])) {
      echo "value='" . $_COOKIE['username'] . "'";
    }
    ?>><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" <?php
    if (isset($_COOKIE['password'])) {
      echo "value='" . $_COOKIE['password'] . "'";
    }
    ?>><br><br>

    <input type="checkbox" id="remember" name="remember" <?php if (isset($_COOKIE['username'])) {
      echo "checked";
    } ?>>
    <label for="remember">Remember me</label><br><br>

    <input type="submit" name="submit" value="Login">
  </form>
</body>

</html>