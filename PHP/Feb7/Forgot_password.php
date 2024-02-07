<!DOCTYPE html>
<html>

<head>
  <title>Forget Password</title>
</head>

<body>
  <h2>Forget Password</h2>
  <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br>

    <input type="submit" name="reset" value="Reset">
    <input type="submit" name="cancel" value="Cancel">
  </form>
</body>

</html>