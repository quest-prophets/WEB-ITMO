<html>
<head> 
	<title>title</title>
	<link rel="icon" href= "images/COTN.png">
	<link rel="stylesheet" href="styles.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="something.js"></script>
</head>

<body> 
	<table width="80%"> <tr>
		<td class = "box boxHeader" >
			Нестеров Дали Константинович <br>
			Группа P3202 <br>
			Вариант 18211
		</td>
		<td >
			<img src="images/graph.png" >
		</td>
		<td ></td>
		<tr>
			<td></td>
			<td class="box">
				<form action="calculation.php" method="get" id="form">
					R: <label><input type="radio" name="r" value="1" checked> 1</label> 
					<label><input type="radio" name="r" value="2"> 2</label> 
					<label><input type="radio" name="r" value="3"> 3</label> 
					<label><input type="radio" name="r" value="4"> 4</label> 
					<label><input type="radio" name="r" value="5"> 5</label> <br>
					Y: <input type="text" name="y" id="y" placeholder="(-3 ... 5)"> <br>
					X: <input type="hidden" id="x" name="x"><button value="-2" type="button" > -2 </button> 
					<button value="-1.5" type="button" > -1.5 </button> 
					<button value="-1" type="button" > -1 </button> 
					<button value="-0.5" type="button" > -0.5 </button> 
					<button value="0" type="button" > 0 </button> 
					<button value="0.5" type="button" > 0.5 </button> 
					<button value="1" type="button" > 1 </button> 
					<button value="1.5" type="button" "> 1.5 </button> 
					<button value="2" type="button" > 2 </button>  </input><br>
					<label style= margin-left:40%><input type="submit" id="submit"></label>
				</form>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td class="box boxError hidden" id="error" >
				Значение Y — не число!
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td class="box boxResult hidden" id="boxResult">
				Результат: <span class="bold" id="resultValue"></span>
			</td>
			<td></td>
		</tr>

		<tr>
			<td></td>
			<td>
				<table class="resultTable">
					<thead>
						<tr>
							<td class = "tdWithBorders">X</td>
							<td class = "tdWithBorders">Y</td>
							<td class = "tdWithBorders">R</td>
							<td class = "tdWithBorders">Результат</td>
							<td class = "tdWithBorders">Время</td>
							<td class = "tdWithBorders">Время выполнения<br>(в микросекундах)</td>
						</tr>
					</thead>
					<tbody id="resultTable">
					</tbody>
				</table>

			</td>
			<td></td>
		</tr>		
	</tr> </table> 
</body> 
</html> 