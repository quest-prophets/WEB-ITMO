function submit(event){
	event.preventDefault();
	var y = Number(document.getElementById("y").value);
	var error = document.getElementById("error");
	var boxResult = document.getElementById("boxResult");
	var resultValue = document.getElementById("resultValue");
	if (isNaN(y)) {
		boxResult.classList.add("hidden");
		error.classList.remove("hidden");
		error.textContent = "Значение Y — не число!"
	}
	else if (y < -3 || y > 5){
		boxResult.classList.add("hidden");
		error.classList.remove("hidden");
		error.textContent = "Y не может быть меньше -3 или больше 5"
	}
	else {
		function something(formData) {
    	var params = new URLSearchParams();
    	for (var kv of formData) { params.append(kv[0], kv[1]); };
    	return params.toString();
  		}
		var formData = new FormData(document.getElementById("form"));
		var url = "calculation.php?" + something(formData);
		fetch(url, { method: "GET"})
		.then(function(response) { return response.text(); })
		.then(function(html) {
			document.getElementById("resultTable").insertAdjacentHTML("beforeend", html);
			error.classList.add("hidden");
			boxResult.classList.remove("hidden");
			resultValue.textContent = document.querySelector("#resultTable tr:last-of-type td:nth-last-of-type(3)").textContent;
		});
	}
}



function buttonAction(event){
	event.preventDefault();
	var x = 0;
    document.querySelector("#x").value = event.currentTarget.innerText;
    Array.prototype.slice.call(document.querySelectorAll("button")).forEach(function(el){el.classList.remove("active")});
    event.currentTarget.classList.add("active");
}

document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("submit").addEventListener("click", submit);
	Array.prototype.slice.call(document.querySelectorAll("button")).forEach(function (e) { e.addEventListener("click", buttonAction)});
})
