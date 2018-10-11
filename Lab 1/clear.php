<?php
session_start();
$_SESSION['history'] = null;
header("location:index.php");
?>