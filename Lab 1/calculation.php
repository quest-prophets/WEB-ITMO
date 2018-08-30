<?php $start = microtime(true);
// CALCULATION
$end = microtime(true); ?>

<tr>
	<td><?= $_POST['x']; ?> </td>
	<td><?= $_POST['y']; ?> </td>
	<td><?= $_POST['z']; ?> </td>
	<td><?= rand(0,1) == 1 ? "true" : "false"; ?></td>
	<td><?= date('H:i:s') ?> </td>
	<td><?= round($end - $start) ?></td>
</tr>

