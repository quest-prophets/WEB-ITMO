document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("submit").addEventListener("click", function(event){
		event.preventDefault();
		var x = document.getElementById("x").value;
		if (!isNaN(Number(x))) {
			document.getElementById("error").classList.add("hidden");
		}
		else{
			document.getElementById("error").classList.remove("hidden");
		}
	})
})