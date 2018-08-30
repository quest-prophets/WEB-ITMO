<html>
<head> 
	<title>Лабораторная работа</title>
	<link rel="icon" href= "images/COTN.png">
	<link rel="stylesheet" href="styles.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="something.js"></script>
</head>

<body>
	<header>
		<div class="box boxHeader">
			Лабораторная Работа №1 <br>
			Нестеров Дали Константинович <br>
			P3202 
		</div>
	</header>

	<div class="content">
		<div class="formContainer">
			<div class="box boxSpaceRight">
				<form action="calculation.php" method="post" id="form">
					X: <input type="text" name="x" id="x"> <br>
					Y: <label><input type="radio" name="y" value="0"> 0</label>
					<label><input type="radio" name="y" value="1"> 1</label>
					<label><input type="radio" name="y" value="2"> 2</label> <br>
					Z: <select name="z"> 
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option></select> <br>
						<label style= margin-left:100px><input type="submit" id="submit"></label>
					</form>
					<div class="box boxError hidden" id="error">
						You are GAY
					</div>
					<div class="box boxResult hidden" id="boxResult">
						Результат:
					</div>
				</div>
				<img src="images/COTN.png" >
			</div>
		</div>
		<div class="flexCenter">
		<table>
			<thead>
				<tr>
					<td>X</td>
					<td>Y</td>
					<td>Z</td>
					<td>Результат</td>
					<td>Время</td>
					<td>Время выполнения</td>
				</tr>
			</thead>
			<tbody id="result">

			</tbody>
		</table>
	</div>
	</div>
</body> 
</html> 