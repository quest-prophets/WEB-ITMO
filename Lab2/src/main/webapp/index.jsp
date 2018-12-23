<%@ page import="lab2.Result" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lab 2</title>
    <meta charset="utf-8">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript" src="validation.js"></script>
</head>

<body>
<header class="box boxHeader">
    <b>Kokov A.T.</b> & <b>Nesterov D.K.</b><br>
    Group No. P3202<br>
    Variant No. 96418
</header>

<div class="flexColumn" style="margin-top: 25px">
    <div class="flexRow">
        <div class="flexColumn">
            <div class="box" style="margin-right: 50px">
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
                <br> <input type="button" id="check" value="Check for belonging">
                <br> <input type="button" id="clearCurrent" value="Clear all current dots">
                <br> <input type="button" id="clearAll" value="Clear all dots">
            </div>
            <div class="box boxError hidden" id="error" style="margin-top: 15px"></div>
            <div class="box boxResult hidden" id="boxResult" style="margin-top: 15px">
                Result: <span class="bold" id="resultValue"></span>
            </div>
        </div>

        <svg id="graph" xmlns="http://www.w3.org/2000/svg" width="400" height="400">
            <path fill="none" stroke="#000" stroke-width="1px" d="M 0 200 h 400"></path>
            <path fill="none" stroke="#000" stroke-width="1px" d="M 200 0 v 400"></path>

            <path fill="none" stroke="#000" stroke-width="1px" d="M 200 0 l -3 7"></path>
            <path fill="none" stroke="#000" stroke-width="1px" d="M 200 0 l 3 7"></path>
            <path fill="none" stroke="#000" stroke-width="1px" d="M 400 200 l -6 -3"></path>
            <path fill="none" stroke="#000" stroke-width="1px" d="M 400 200 l -6 3"></path>

            <path fill="#3399ff" stroke="#000" stroke-width="1px" d="M 200 40 v 160 h -80 Z"></path>
            <path fill="#3399ff" stroke="#000" stroke-width="1px" d="M 40 200 q 0 160 160 160 v -160 Z"></path>
            <path fill="#3399ff" stroke="#000" stroke-width="1px" d="M 200 200 h 160 v 160 h -160 Z"></path>

            <text x="180" y="44" font-weight="400">
                <tspan x="180" y="44" font-size="16px">R</tspan>
            </text>
            <text x="106" y="190" font-weight="400">
                <tspan x="20" y="190" font-size="16px">R</tspan>
            </text>
            <text x="166" y="296" font-weight="400">
                <tspan x="209" y="380" font-size="16px">R</tspan>
            </text>
            <text x="360" y="190" font-weight="400">
                <tspan x="360" y="190" font-size="16px">R</tspan>
            </text>
            <text x="360" y="190" font-weight="400">
                <tspan x="90" y="190" font-size="16px">R/2</tspan>
            </text>
            <g id="graphDots"></g>
        </svg>
    </div>

    <table style="margin-top: 25px" class="resultTable">
        <thead>
        <tr>
            <td class="tdWithBorders">R</td>
            <td class="tdWithBorders">X</td>
            <td class="tdWithBorders">Y</td>
            <td class="tdWithBorders">Result</td>
            <td class="tdWithBorders">Time</td>
        </tr>
        </thead>
        <tbody id="resultTable">
        <%! List<Result> list; %>
        <%! int length;%>
        <% list = (List<Result>) session.getAttribute("dotChecks"); %>
        <% if (!(list == null)) {%>
        <% length = list.size(); %>
        <% for (int i = 0; i < length; i++) { %>
        <tr class="rows">
            <td class="tdWithBorders">
                <%= list.get(i).r %>
            </td>
            <td class="tdWithBorders">
                <%= list.get(i).x %>
            </td>
            <td class="tdWithBorders">
                <%= list.get(i).y %>
            </td>
            <td class="tdWithBorders">
                <%= list.get(i).res %>
            </td>
            <td class="tdWithBorders">
                <%-- Lesha DO the T I M E --%>
            </td>
        </tr>
        <%}%>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>