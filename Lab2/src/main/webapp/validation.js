function submit(event) {
    event.preventDefault();
    let y = document.getElementById("y").value;
    let r = document.getElementById("r").value;
    let error = document.getElementById("error");
    let boxResult = document.getElementById("boxResult");
    if (y === "") {
        error.classList.remove("hidden");
        error.textContent = "Y is not defined!";
    } else if (r === "") {
        error.classList.remove("hidden");
        error.textContent = "R is not defined!";
    } else {
        y = Number(y);
        if (isNaN(y)) {
            boxResult.classList.add("hidden");
            error.classList.remove("hidden");
            error.textContent = "Y is not a number!"
        }
        r = Number(r);
        if (isNaN(r)) {
            boxResult.classList.add("hidden");
            error.classList.remove("hidden");
            error.textContent = "R is not a number!"
        } else if (y < -5 || y > 3) {
            boxResult.classList.add("hidden");
            error.classList.remove("hidden");
            error.textContent = "Y must be in range [-5 ... 3]"
        } else if (r < 2 || r > 5) {
            boxResult.classList.add("hidden");
            error.classList.remove("hidden");
            error.textContent = "R must be in range [2 ... 5]";
        }
    }

}

function placePointForm(e) {
    const r = document.getElementById("r").value;
    const xs = document.getElementsByName("x");
    const y = document.getElementById("y").value;
    let resultValue = document.getElementById("resultValue");


    //let AJAXRequest = function (url, callback) {
    //    let clb = callback || addData;
    //    let req = new XMLHttpRequest();
//
    //    req.onreadystatechange = function () {
    //        if (req.readyState === 4 && req.status === 200) {
    //            clb((req.responseText));
    //        }
    //    };
//
    //    req.open("GET", url);
    //    req.send();
    //};
//
//    let addData = function (data) {
 //       let element = document.createElement("html");
 //        element.innerHTML = data;
 //        console.log("hellooo");
  //       console.log(data);
 //        let row = element.getElementsByTagName("tr")[0];
  //      row.removeChild(row.lastChild);
 //       document.getElementById("resultTable").appendChild(row);
  //   };

    const svgns = "http://www.w3.org/2000/svg";
    xs.forEach(function (x) {
        if (x.checked) {
            const circle = document.createElementNS(svgns, 'circle');
            circle.setAttributeNS(null, 'cx', x.value / r * 160 + 200);
            circle.setAttributeNS(null, 'cy', -y / r * 160 + 200);
            circle.setAttributeNS(null, 'r', 3);
            circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
            document.getElementById("graph").appendChild(circle);

            fetch(`hitCheck?x=${x.value}&y=${y}&r=${r}`, {method: "GET"})
               .then(response => response.text())
               .then(text => console.log(text))
//
            //fetch(("hitCheck?x=" + x + "&y=" + y + "&r=" + r), {method: "GET"})
            //    .then(response => response.text())
            //    .then(function (html) {
            //        console.log(html);
            //        document.getElementById("resultTable").insertAdjacentHTML("beforeend", html);
            //        resultValue.textContent = document.querySelector("#resultTable tr:last-of-type td:nth-of-type(4)").textContent;
            //    });
//
            // AJAXRequest("hitCheck?x=" + x + "&y=" + y + "&r=" + r);

        }
    });

}

function placePointGraph(e) {
    const r = document.getElementById("r").value;
    const error = document.getElementById("error");
    let boxResult = document.getElementById("boxResult");
    if (r === "") {
        error.classList.remove("hidden");
        error.textContent = "Enter R!";
    } else if (r < 2 || r > 5) {
        boxResult.classList.add("hidden");
        error.classList.remove("hidden");
        error.textContent = "R must be in range [2 ... 5]";
    } else {
        const svgns = "http://www.w3.org/2000/svg";
        const circle = document.createElementNS(svgns, 'circle');
        const graph = $('#graph');
        circle.setAttributeNS(null, 'cx', e.pageX - graph.offset().left);
        circle.setAttributeNS(null, 'cy', e.pageY - graph.offset().top);
        circle.setAttributeNS(null, 'r', 3);
        circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
        document.getElementById("graph").appendChild(circle);

        const x = (e.pageX - graph.offset().left - 200) * r / 160;
        const y = -(e.pageY - graph.offset().top - 200) * r / 160;
        console.log(x);
        console.log(y);

        fetch(`hitCheck?x=${x}&y=${y}&r=${r}`, {method: "GET"})
            .then(response => response.text())
            .then(text => console.log(text))
    }
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
    document.getElementById("check").addEventListener("click", placePointForm);
    document.getElementById("graph").addEventListener("click", placePointGraph);
    //document.querySelector("svg").addEventListener("click", placePointForm);
    Array.prototype.slice.call(document.querySelectorAll("button")).forEach(function (e) {
        if (e.id !== "clearButton") e.addEventListener("click", buttonAction)
    });
});