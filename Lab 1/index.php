<html>
<head> 
	<title>title</title>
	<link rel="icon" href= "images/COTN.png">
	<link rel="stylesheet" href="styles.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="something.js"></script>
</head>

<body> 
	<div class="box boxHeader">
		Нестеров Дали Константинович <br>
		Группа P3202 <br>
		Вариант 18211
	</div>

	<div class="content">
		<div class="formContainer">
			<div class="box boxSpaceRight">
				<form action="calculation.php" method="post" id="form">
					X: <input type="text" name="x" id="x"> <br>
					Y: <input type="text" name="y" id="y" placeholder="(-3 ... 5)"> <br>
					R: <label><input type="radio" name="r" value="1" checked> 1</label> 
					<label><input type="radio" name="r" value="2"> 2</label> 
					<label><input type="radio" name="r" value="3"> 3</label> 
					<label><input type="radio" name="r" value="4"> 4</label> 
					<label><input type="radio" name="r" value="5"> 5</label> <br>
					<label style= margin-left:100px><input type="submit" id="submit"></label>
					</form>
					<div class="box boxError hidden" id="error">
						Значение Y &ndash; не число!
					</div>
					<div class="box boxResult hidden" id="boxResult">
						Результат: <span class="bold" id="resultValue"></span>
					</div>
				</div>
				<img src="images/graph.png" >
			</div>
		</div>

		<div class="flexCenter">
		<table>
			<thead>
				<tr>
					<td>X</td>
					<td>Y</td>
					<td>R</td>
					<td>Результат</td>
					<td>Время</td>
					<td>Время выполнения<br>(в микросекундах)</td>
				</tr>
			</thead>
			<tbody id="resultTable">
			</tbody>
		</table>
		</div> 
	</div>
</body> 
</html> 