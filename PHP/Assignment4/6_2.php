<?php
if (isset($_POST['submit'])) {
  $username = $_POST['username'];
  $password = $_POST['password'];

  // You should validate the username and password here

  if ($_POST['remember'] == 'on') {
    // Set cookies for username and password with expiration time of 30 days (can take simple variable too if you want)
    setcookie('username', $username, time() + (30 * 24 * 60 * 60), '/');
    setcookie('password', $password, time() + (30 * 24 * 60 * 60), '/');
  }

  // Redirect to the home page 
  header("Location: 6_1.php");
  exit();
}
?>