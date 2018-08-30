<style type="text/css"> 
		body{
    	background: url("images/BG.png") no-repeat center center;
    	-webkit-background-size: cover;
    	-moz-background-size: cover;
    	-o-background-size: cover;
   		background-size: cover; 
   		font-weight: bold;
		}
</style>

<?php $start = microtime(true);
// CALCULATION
$end = microtime(true); ?>


<table border="true" >
	<thead>
		<tr>
			<td>X</td>
			<td>Y</td>
			<td>Z</td>
			<td>Время</td>
			<td>Время выполнения</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><?= $_POST['x']; ?> </td>
			<td><?= $_POST['y']; ?> </td>
			<td><?= $_POST['z']; ?> </td>
			<td><?= date('H:i:s') ?> </td>
			<td><?= round($end - $start) ?></td>
		</tr>
	</tbody>
</table>
