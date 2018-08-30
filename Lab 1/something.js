function submit(event){
	event.preventDefault();
	var x = document.getElementById("x").value;
	var error = document.getElementById("error");
	var boxResult = document.getElementById("boxResult");
	if (!isNaN(Number(x))) {
		var formData = new FormData(document.getElementById("form"));
		fetch("calculation.php", { method: "POST", body: formData })
		.then(function(response) { return response.text(); })
		.then(function(html) {
			document.getElementById("result").insertAdjacentHTML("beforeend", html);
			error.classList.add("hidden");
			boxResult.classList.remove("hidden");
			boxResult.textContent = "Результат: " + document.querySelector("#result tr:last-of-type td:nth-last-of-type(3)").textContent;
		});
	}
	else {
		boxResult.classList.add("hidden");
		error.classList.remove("hidden");
	}
}

document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("submit").addEventListener("click", submit);
})