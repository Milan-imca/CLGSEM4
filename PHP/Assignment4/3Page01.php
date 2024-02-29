<?php 
  session_start();
  $_SESSION['username'] = "Milan";
  $_SESSION['start_time'] = time();

  if(isset($_SESSION['username'])){
    echo "Session is set!";
  }
  else{
    echo "Session is not set";
  }
?>