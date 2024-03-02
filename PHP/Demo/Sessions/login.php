<?php
session_start();

// Dummy username and password (for demonstration purposes)
$valid_username = 'milan';
$valid_password = 'm20';

if (isset($_POST['username']) && isset($_POST['password'])) {
    $username = $_POST['username'];
    $password = $_POST['password'];

    if ($username === $valid_username && $password === $valid_password) {
        // Authentication successful, store username in session
        $_SESSION['username'] = $username;
        header('Location: home.php');
        exit();
    } else {
        echo "Invalid username or password.";
    }
}
?>