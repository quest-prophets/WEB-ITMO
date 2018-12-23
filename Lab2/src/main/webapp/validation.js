var error;
var boxResult;
var resultValue;
var resultTable;
var graph
var rElement;
var r;
var xs;
var yElement;
var y;

document.addEventListener("DOMContentLoaded", function () {
    error = $('#error');
    boxResult = $('#boxResult');
    resultValue = $('#resultValue');
    resultTable = $('#resultTable');
    graph = $('#graph');
    rElement = $('#r');
    xs = $('[name="x"]');
    yElement = $('#y');
    document.getElementById("graph").addEventListener("click", doGraph);
    document.getElementById("check").addEventListener("click", doForm);

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
    else return true;
}

function checkY() {
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

function drawPoint(x, y) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    circle.setAttributeNS(null, 'cx', x);
    circle.setAttributeNS(null, 'cy', y);
    circle.setAttributeNS(null, 'r', 3);
    circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
    graph.append(circle);
}

function sendData(x, y, r) {
    fetch(`hitCheck?x=${x}&y=${y}&r=${r}`, {method: "GET"})
        .then(response => response.text())
        .then(function (result) {
            resultTable.append("<tr>\n" +
                "<td class=\"tdWithBorders\">" + r + "</td>\n" +
                "<td class=\"tdWithBorders\">" + x + "</td>\n" +
                "<td class=\"tdWithBorders\">" + y + "</td>\n" +
                "<td class=\"tdWithBorders\">" + result + "</td>\n" +
                "</tr>");
            setResult(result);
        })
}

function doForm(e) {
    if (checkR() && checkY()) {
        xs.each(function (i, x) {
            if (x.checked) {
                drawPoint(x.value / r * 160 + 200, -y / r * 160 + 200);
                sendData(x.value, y, r);
            }
        })
    }
}

function doGraph(e) {
    if (checkR()) {
        drawPoint(e.pageX - graph.offset().left, e.pageY - graph.offset().top);
        sendData((e.pageX - graph.offset().left - 200) * r / 160, -(e.pageY - graph.offset().top - 200) * r / 160, r);
    }
}
