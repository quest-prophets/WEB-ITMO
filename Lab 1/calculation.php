<style type="text/css">
	.tdWithBorders{
		padding: 4px;
		border: 1px solid #000000;
	}
</style>

<?php $start = microtime(true);

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

$result = check($_GET['x'], $_GET['y'], $_GET['r']) ? "True": "False";

$end = microtime(true); 
$executionTime = $end - $start ?>

<tr>
	<td class = "tdWithBorders"><?= $_GET['x']; ?> </td>
	<td class = "tdWithBorders"><?= $_GET['y']; ?> </td>
	<td class = "tdWithBorders"><?= $_GET['r']; ?> </td>
	<td class = "tdWithBorders"><?= $result; ?></td>
	<td class = "tdWithBorders"><?= date('H:i:s') ?> </td>
	<td class = "tdWithBorders"><?= $executionTime ?></td>
</tr>

