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

$result = check($_POST['x'], $_POST['y'], $_POST['r']) ? "True": "False";

$end = microtime(true); 
$executionTime = $end - $start ?>

<tr>
	<td><?= $_POST['x']; ?> </td>
	<td><?= $_POST['y']; ?> </td>
	<td><?= $_POST['r']; ?> </td>
	<td><?= $result; ?></td>
	<td><?= date('H:i:s') ?> </td>
	<td><?= $executionTime ?></td>
</tr>

