function submit(event) {
    event.preventDefault();
    var y = document.getElementById("y").value
    var r = document.getElementById("r").value
    console.log(y);

    var error = document.getElementById("error");
    var boxResult = document.getElementById("boxResult");
    var resultValue = document.getElementById("resultValue");
    if (y === "") {
        error.classList.remove("hidden");
        error.textContent = "Значение Y — не число!";
    } else if (r === "") {
        error.classList.remove("hidden");
        error.textContent = "Значение R — не число!";
    } else {
        y = Number(y);
        if (isNaN(y)) {
            boxResult.classList.add("hidden");
            error.classList.remove("hidden");
            error.textContent = "Значение Y — не число!"
        } else if (y < -5 || y > 3) {
            boxResult.classList.add("hidden");
            error.classList.remove("hidden");
            error.textContent = "Y must be in range [-5 ... 3]"
        } else if (r < 2 || r > 5) {
            boxResult.classList.add("hidden");
            error.classList.remove("hidden");
            error.textContent = "R must be in range [2 ... 5]";
        } else {
            function something(formData) {
                var params = new URLSearchParams();
                for (var kv of formData) {
                    params.append(kv[0], kv[1]);
                }
                return params.toString();
            }

            var formData = new FormData(document.getElementById("form"));
            var url = "calculation.php?" + something(formData);
            fetch(url, {method: "GET"})
                .then(function (response) {
                    return response.text();
                })
                .then(function (html) {
                    document.getElementById("resultTable").insertAdjacentHTML("beforeend", html);
                    error.classList.add("hidden");
                    boxResult.classList.remove("hidden");
                    resultValue.textContent = document.querySelector("#resultTable tr:last-of-type td:nth-of-type(4)").textContent;
                });
        }
    }

}

function placePoint(e) {
    const svg = e.target.closest('svg');
    const referencePt = svg.createSVGPoint();
    referencePt.x = e.clientX;
    referencePt.y = e.clientY;
    const axisDim = 400;
    const rDim = 160;
    const {x: graphX, y: graphY} = referencePt.matrixTransform(
        svg.getScreenCTM().inverse());

    const r = document.getElementById("r").value;
    const x = ((graphX - (axisDim / 2)) / rDim) * r;
    const y = -((graphY - (axisDim / 2)) / rDim) * r;

    fetch(`hitCheck?x=${x}&y=${y}&r=${r}`, {method: "GET"})
        .then(response => response.text())
        .then(text => console.log(text))

}


function buttonAction(event) {
    event.preventDefault();
    document.querySelector("#x").value = event.currentTarget.innerText;
    Array.prototype.slice.call(document.querySelectorAll("button")).forEach(function (el) {
        el.classList.remove("active")
    });
    event.currentTarget.classList.add("active");
}

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("check").addEventListener("click", submit);
    document.querySelector("svg").addEventListener("click", placePoint);
    Array.prototype.slice.call(document.querySelectorAll("button")).forEach(function (e) {
        if (e.id !== "clearButton") e.addEventListener("click", buttonAction)
    });
});