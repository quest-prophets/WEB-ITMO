var error;
var boxResult;
var resultValue;
var resultTable;
var graph;
var graphDots;
var rElement;
var r;
var xs;
var yElement;
var y;
var lastCorrectR;

document.addEventListener("DOMContentLoaded", function () {
    error = $('#error');
    boxResult = $('#boxResult');
    resultValue = $('#resultValue');
    resultTable = $('#resultTable');
    graph = $('#graph');
    graphDots = $('#graphDots');
    rElement = $('#r');
    xs = $('[name="x"]');
    yElement = $('#y');
    graph.bind("click", doGraph);
    $('#check').bind("click", doForm);
    $('#clearAll').bind("click", clear);
    rElement.bind("input", changeR);
    yElement.bind("input", changeY);
});

function updateValues() {
    r = rElement.val();
    y = yElement.val();
}

function checkR() {
    updateValues();
    if (r === "") setError("R is not defined!");
    else if (r < 2 || r > 5) setError("R must be in range [2 ... 5]");
    else if (isNaN(Number(r))) setError("R is not a number!");
    else {
        lastCorrectR = r;
        return true;
    }
}

function checkY() {
    updateValues();
    if (y === "") setError("Y is not defined!");
    else if (y < -5 || y > 3) setError("Y must be in range [-5 ... 3]");
    else if (isNaN(Number(y))) setError("Y is not a number!");
    else return true;
}

function setError(text) {
    error.removeClass("hidden");
    boxResult.addClass("hidden");
    error.text(text);
}

function setResult(text) {
    boxResult.removeClass("hidden");
    error.addClass("hidden");
    resultValue.text(text);
}

function changeR() {
    if (rElement.val() !== "") {
        if (checkR()) {
            error.addClass("hidden");
            recomputePoints(r);
        }
    }
}

function changeY() {
    if (yElement.val() !== "") {
        if (checkY()) {
            if (rElement.val() !== "") {
                if (checkR()) error.addClass("hidden");
            }
        }
    }
}

function drawPoint(x, y, isGreen) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    circle.setAttributeNS(null, 'cx', x);
    circle.setAttributeNS(null, 'cy', y);
    circle.setAttributeNS(null, 'r', 3);
    if (isGreen) circle.setAttributeNS(null, 'style', 'fill: green; stroke: green; stroke-width: 1px;');
    else circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
    graphDots.append(circle);
}

function drawPointR(x, y, r, isGreen) {
    drawPoint(x / r * 160 + 200, -y / r * 160 + 200, isGreen);
}

function sendData(x, y, r, toSetResult) {
    return fetch(`hitCheck?x=${x}&y=${y}&r=${r}`, {method: "GET"})
        .then(response => response.text())
        .then(function (resultText) {
            resultTable.append("<tr>\n" +
                "<td class=\"tdWithBorders\">" + r + "</td>\n" +
                "<td class=\"tdWithBorders\">" + x + "</td>\n" +
                "<td class=\"tdWithBorders\">" + y + "</td>\n" +
                "<td class=\"tdWithBorders\">" + resultText.split(" ")[0] + "</td>\n" +
                "<td class=\"tdWithBorders\">" + resultText.split(" ")[1] + "</td>\n" +
                "</tr>");
            if (toSetResult) setResult(resultText.split(" ")[0]);
            else boxResult.addClass("hidden");
            return resultText.split(" ")[0] === "True";
        })
}

function recomputePoints(r) {
    return fetch(`areaCheck/recompute?r=${r}`, {method: "GET"})
        .then(response => response.json())
        .then(function (results) {
            graphDots.children().remove();
            results.forEach((res) => {
                drawPointR(res.x, res.y, r, res.res);
            });
        })
}

function doForm() {
    if (checkR() && checkY()) {
        let xChecked = 0;
        let toSetResult = true;
        xs.each((i, x) => {
            if (x.checked) xChecked++
        });
        if (xChecked > 1) toSetResult = false;
        xs.each(function (i, x) {
            if (x.checked) {
                sendData(x.value, y, r, toSetResult)
                    .then(result => drawPointR(x.value,y, r, result));
            }
        });
    }
}

function doGraph(e) {
    if (checkR()) {
        sendData((e.pageX - graph.offset().left - 200) * r / 160, -(e.pageY - graph.offset().top - 200) * r / 160, r, true)
            .then(result => drawPoint(e.pageX - graph.offset().left, e.pageY - graph.offset().top, result));
    }
}

function clear() {
    fetch(`clearHistory`, {method: "GET"})
        .then(response => response.text())
        .then(() => {
            $("#resultTable").html("");
            graphDots.children().each((i, dot) => dot.remove());
        })
}
