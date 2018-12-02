<!DOCTYPE html>
<html>
<head>
    <title>Lab 2</title>
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
    <img style="margin-bottom: 8px" src="images/graph.png" alt = "Delete this">
    <div class="box" style="margin-bottom: 8px">
        <form action="calculation.php" method="get" id="form">
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
            <button type="submit" id="submit">Submit</button>
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
    </table>
</div>
</body>
</html> 