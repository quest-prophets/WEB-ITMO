<%@ page import="java.util.ArrayList" %>
<%@ page import="lab2.Dot" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lab 2</title>
    <meta charset="utf-8">
    <link rel="icon" href="images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="validation.js"></script>
</head>

<body>
<header class="box boxHeader">
    <b>Kokov A.T.</b> & <b>Nesterov D.K.</b><br>
    Group No. P3202<br>
    Variant No. 96418
</header>

<div class="flexContainer" style="margin-top: -40px">
    <svg class="graph" ref="svg" xmlns="http://www.w3.org/2000/svg" width = "400" height="400">
        <g id="graph__coordinate-plane">

            <path fill="none" stroke="#000" stroke-width="1px" d="M 0 200 h 400"></path>
            <path fill="none" stroke="#000" stroke-width="1px" d="M 200 0 v 400"></path>

            <path fill="none" stroke="#000" stroke-width="1px" d="M 200 0 l -3 7"></path>
            <path fill="none" stroke="#000" stroke-width="1px" d="M 200 0 l 3 7"></path>
            <path fill="none" stroke="#000" stroke-width="1px" d="M 400 200 l -6 -3"></path>
            <path fill="none" stroke="#000" stroke-width="1px" d="M 400 200 l -6 3"></path>
        </g>
        <path fill="#3399ff" stroke="#000" stroke-width="1px" d="M 200 40 v 160 h -80 Z"></path>
        <path fill="#3399ff" stroke="#000" stroke-width="1px" d="M 40 200 q 0 160 160 160 v -160 Z"></path>
        <path fill="#3399ff" stroke="#000" stroke-width="1px" d="M 200 200 h 160 v 160 h -160 Z"></path>

        <text x="180" y="44" font-weight="400"><tspan x="180" y="44" font-size="16px">R</tspan></text>
        <text x="106" y="190" font-weight="400"><tspan x="20" y="190" font-size="16px">R</tspan></text>
        <text x="166" y="296" font-weight="400"><tspan x="209" y="380" font-size="16px">R</tspan></text>
        <text x="360" y="190" font-weight="400"><tspan x="360" y="190" font-size="16px">R</tspan></text>
        <text x="360" y="190" font-weight="400"><tspan x="90" y="190" font-size="16px">R/2</tspan></text>
        <g id="graph__points">

        </g>
    </svg>

    <div class="box" style="margin-bottom: 8px">
        <form action="../../calculation.php" method="get" id="form">
            R: &emsp;<input type="text" name="r" id="r" placeholder="[2 ... 5]"><br>
            <table style="display: inline-table">
                <tr>
                    <td>X: &ensp;</td>
                    <td><label><input type="checkbox" name="x" value="1">1 &nbsp;</label></td>
                    <td><label><input type="checkbox" name="x" value="2">2 &nbsp;</label></td>
                    <td><label><input type="checkbox" name="x" value="3">3 &nbsp;</label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label><input type="checkbox" name="x" value="0">0</label></td>
                    <td><label><input type="checkbox" name="x" value="-1">-1</label></td>
                    <td><label><input type="checkbox" name="x" value="-2">-2</label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label><input type="checkbox" name="x" value="-3">-3</label></td>
                    <td><label><input type="checkbox" name="x" value="-4">-4</label></td>
                    <td><label><input type="checkbox" name="x" value="-5">-5</label></td>
                </tr>
            </table>
            <br>
            Y: &emsp;<input type="text" name="y" id="y" placeholder="[-5 ... 3]">
            <br/> <input type="submit" id = "check" value="Check for belonging" onClick= "//checkValid(event)">
            <br/>
            <br/> <input type="button" id = "cle" value="Clear current R checks" onClick= "cl()">
            <br/>
            <br/> <input type="button" id = "clAll" value="Clear all R checks" onClick= "clearAll()">
            <br/>
            <%-- <button type="submit" id="check">Submit</button> --%>
        </form>
    </div>
    <div class="box boxError hidden" id="error">
        Y is not a number!
    </div>
    <div class="box boxResult hidden" id="boxResult">
        Результат: <span class="bold" id="resultValue"></span>
    </div>
    <table style="margin-top: 8px" class="resultTable">
        <thead>
        <tr>
            <td class="tdWithBorders">R</td>
            <td class="tdWithBorders">X</td>
            <td class="tdWithBorders">Y</td>
            <td class="tdWithBorders">Result</td>
        </tr>
        </thead>
        <tbody id="resultTable">

        </tbody>
        <script>

            function cl() {
                areaRads[rad-1].length=0; //-1
                drawArea();
                let tbl = document.getElementById("resultTable");
                let rowC = tbl.rows.length;
                for (let i = rowC - 1; i > 0; i--) {
                    if (tbl.rows[i].cells[2].textContent.trim() === rad) {
                        tbl.deleteRow(i);
                    }
                }
                fetch(`clearHistory?rad=${rad}`, { method: 'GET' });

            }
            function clearAll() {
                for (r=0; r<areaRads.length; r++) {
                    areaRads[r].length=0;
                }
                drawArea();
                let tbl = document.getElementById("resultTable");
                let rowCount = tbl.rows.length;
                for (let i = rowCount-1; i > 0; i--) {
                    tbl.deleteRow(i);
                }
                fetch(`clearHistory`, { method: 'GET'});
            }

        </script>
    </table>
</div>
</body>
</html>