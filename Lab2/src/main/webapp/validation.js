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
        const oldR = lastCorrectR;
        if (checkR()) {
            error.addClass("hidden");
            graphDots.children().each(function (i, dot) {
                const x = dot.getAttribute('cx');
                const y = dot.getAttribute('cy');
                dot.remove();
                if (x >= 200 && y >= 200) drawPoint((x - 200) * oldR / r + 200, (y - 200) * oldR / r + 200);
                else if (x < 200 && y > 200) drawPoint(200 - (200 - x) * oldR / r, (y - 200) * oldR / r + 200);
                else if (x > 200 && y < 200) drawPoint((x - 200) * oldR / r + 200, 200 - (200 - y) * oldR / r);
                else if (x < 200 && y < 200) drawPoint(200 - (200 - x) * oldR / r, 200 - (200 - y) * oldR / r);
            });
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

function drawPoint(x, y) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    circle.setAttributeNS(null, 'cx', x);
    circle.setAttributeNS(null, 'cy', y);
    circle.setAttributeNS(null, 'r', 3);
    circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
    graphDots.append(circle);
}

function sendData(x, y, r, toSetResult) {
    fetch(`hitCheck?x=${x}&y=${y}&r=${r}`, {method: "GET"})
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
                drawPoint(x.value / r * 160 + 200, -y / r * 160 + 200);
                sendData(x.value, y, r, toSetResult);
            }
        });
    }
}

function doGraph(e) {
    if (checkR()) {
        drawPoint(e.pageX - graph.offset().left, e.pageY - graph.offset().top);
        sendData((e.pageX - graph.offset().left - 200) * r / 160, -(e.pageY - graph.offset().top - 200) * r / 160, r);
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
