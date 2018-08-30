<html>
<head> 
	<title>Лабораторная работа</title>
	<link rel="icon" href= "images/COTN.png">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style type="text/css">
	header{
		margin-bottom: 120px;
	}
	body{
		background: url("images/BG.png") no-repeat center center;
		-webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		background-size: cover; 
	}
	.box{
		background-color: #e8e8e8;
		border-radius: 15px;
		display: inline-block;
		padding: 10px;
		line-height: 35px;
		font-size: 18px;
	}
	.boxHeader{
		line-height: 20px;
		font-size: 16px;
	}
	
	.content{

	}
	.boxError{
		top:670px;
		line-height: 10px;
		background-color: #ff6666;
	}
	.hidden{
		display: none;
	}
	.formContainer{
		display: flex;
		align-items: center;
		justify-content: center;
	}
	@media (max-width: 960px) {
		.formContainer{
			flex-direction: column;
		}
		header{
			margin-bottom: 70px;
		}
	}
	@media (min-width: 961px){
		.boxSpaceRight{
		margin-right: 50px;
	}
	}
</style>
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
				<form action="calculation.php" method="post">
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
				</div>
				<img src="images/COTN.png" >
			</div>
		</div>
		
	</div>
</body> 
</html> 