<?php
session_start();

// Check if user is logged in
if (!isset($_SESSION['username'])) {
  header('Location: index.php');
  exit();
}

$username = $_SESSION['username'];
?>

<!DOCTYPE html>
<html>

<head>
  <title>Home Page</title>
</head>

<body>
  <h2>Welcome,
    <?php echo $username; ?>
  </h2>
  <a href="logout.php">Logout</a>
</body>

</html>