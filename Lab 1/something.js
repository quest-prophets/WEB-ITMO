function submit(event){
	event.preventDefault();
	var y = document.getElementById("y").value;
	var error = document.getElementById("error");
	var boxResult = document.getElementById("boxResult");
	var resultValue = document.getElementById("resultValue");
	if (!isNaN(Number(y))) {
		var formData = new FormData(document.getElementById("form"));
		fetch("calculation.php", { method: "POST", body: formData })
		.then(function(response) { return response.text(); })
		.then(function(html) {
			document.getElementById("resultTable").insertAdjacentHTML("beforeend", html);
			error.classList.add("hidden");
			boxResult.classList.remove("hidden");
			resultValue.textContent = document.querySelector("#resultTable tr:last-of-type td:nth-last-of-type(3)").textContent;
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