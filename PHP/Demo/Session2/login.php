<?php
session_start();

$db_host = 'localhost';
$db_username = 'root';
$db_password = '';
$db_name = 'registeration';

$conn = mysqli_connect($db_host, $db_username, $db_password, $db_name);

if (!$conn) {
  echo ("Connection failed: ");
}

if (isset($_POST['username']) && isset($_POST['password'])) {
  $username = $_POST['username'];
  $password = $_POST['password'];

  $sql = "SELECT * FROM user_details WHERE email='$username' AND password='$password'";
  $result = mysqli_query($conn, $sql);

  if (mysqli_num_rows($result) == 1) {
    // Authentication successful, store username in session
    $_SESSION['username'] = $username;
    header('Location: home.php');
    exit();
  } else {
    echo "Invalid username or password.";
  }
}

?>
