<?php 

  session_start();

  session_unset(); // variable free ho jayenge 
  session_destroy(); // values empty ho jayenge

  echo "session destroy";
?>