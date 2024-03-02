<?php 
  session_start();

  echo "Username : ".$_SESSION['username']."<br>";
  echo "Address : ".$_SESSION['address'];
?>