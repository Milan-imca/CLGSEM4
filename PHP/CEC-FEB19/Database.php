<?php
// Database connection details
$db_hostname = '127.0.0.1';
$db_username = 'root';
$db_password = '';
$db_name = 'gls';

// Create connection
$conn = mysqli_connect($db_hostname, $db_username, $db_password, $db_name);

// Check connection
if (!$conn) {
  die("Connection failed: " . mysqli_connect_error());
}
?>