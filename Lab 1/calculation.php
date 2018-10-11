<style type="text/css">
	.tdWithBorders{
		padding: 4px;
		border: 1px solid #000000;
	}
</style>

<?php 
$x = $_GET['x'];
if ($x == "") {
	$x = "0";
}
$y = $_GET['y'];

$r = $_GET['r'];


$start = microtime(true);

function check($x,$y,$r){
	if ($x >= 0 && $y >= 0){
		if($x <= $r/2 && $y <= $r) return True;
	}
	else if ($x >= 0 && $y <= 0){
		if($x*$x - $y*$y <= $r*$r) return True;
	}
	else if ($x <= 0 && $y >= 0){
		if (-$x + $y <= $r/2) return True;
	}
	else return False;
}



$result = check($x, $y, $r) ? "True": "False";

$end = microtime(true); 
$executionTime = $end - $start; 
$time = date('H:i:s');
$full_data = array($x, $y, $r, $result, $time, $executionTime);
session_start();
if (!isset($_SESSION['history'])) {
		$_SESSION['history'] = array();
	}
	array_push($_SESSION['history'], $full_data);
?>

<tr>
	<td class = "tdWithBorders"><?php echo $x; ?> </td>
	<td class = "tdWithBorders"><?php echo $y; ?> </td>
	<td class = "tdWithBorders"><?php echo $r; ?> </td>
	<td class = "tdWithBorders"><?php echo $result; ?></td>
	<td class = "tdWithBorders"><?php echo $time ?> </td>
	<td class = "tdWithBorders"><?php echo $executionTime ?></td>
</tr>

