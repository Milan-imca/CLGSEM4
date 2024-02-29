<!-- Q:3 Write a PHP script to create a session and reset its variable and destroy it after an hour. -->
<?php
session_start();
if (isset($_SESSION['username']) && (time() - $_SESSION['start_time'] > 30)) // repalce 30 with 3600 bcoz its done to just check the working
{
  echo "session has expired!";
  session_unset();
  session_destroy();
} else {
  echo "Username : " . $_SESSION['username'];
}

?>