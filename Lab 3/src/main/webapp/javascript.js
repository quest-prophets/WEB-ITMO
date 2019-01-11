var sector_LT;
var sector_RT;
var sector_LB;
var sector_RB;
var sectorButton1;
var sectorButton2;
var sectorButton3;
var sectorButton4;
var sectorButton5;
var sectorButton6;
var sectorButton7;
var sectorButton8;
var sectorButton9;
var sectorButtons;
var sectorsTable;
var chosenFigure;
var dots_LT;
var dots_RT;
var dots_LB;
var dots_RB;
var dayNightSwitch;
var body;

document.addEventListener("DOMContentLoaded", function () {
    body = $("body");
    sectorButton1 = $("#sectorButton1");
    sectorButton2 = $("#sectorButton2");
    sectorButton3 = $("#sectorButton3");
    sectorButton4 = $("#sectorButton4");
    sectorButton5 = $("#sectorButton5");
    sectorButton6 = $("#sectorButton6");
    sectorButton7 = $("#sectorButton7");
    sectorButton8 = $("#sectorButton8");
    sectorButton9 = $("#sectorButton9");
    sectorButtons = [sectorButton1, sectorButton2, sectorButton3, sectorButton4, sectorButton5, sectorButton6, sectorButton7, sectorButton8, sectorButton9];
    sectorsTable = $("#sectorsTable");
    sector_LT = $("#sector_LT");
    sector_RT = $("#sector_RT");
    sector_LB = $("#sector_LB");
    sector_RB = $("#sector_RB");
    dots_LT = $("#dots_LT");
    dots_RT = $("#dots_RT");
    dots_LB = $("#dots_LB");
    dots_RB = $("#dots_RB");
    dayNightSwitch = $("#dayNightSwitch");
    dayNightSwitch.change(changeTheme);
    sector_LT.contextmenu(false);
    sector_RT.contextmenu(false);
    sector_LB.contextmenu(false);
    sector_RB.contextmenu(false);
    sector_LT.contextmenu(createSectorLTmenu);
    sector_RT.contextmenu(createSectorRTmenu);
    sector_LB.contextmenu(createSectorLBmenu);
    sector_RB.contextmenu(createSectorRBmenu);
    sector_LT.click(doLT);
    sector_RT.click(doRT);
    sector_LB.click(doLB);
    sector_RB.click(doRB);
    sectorButtons.forEach(function (button) {
        button.click(changeSector);
    });
    changeTheme();
});

function createSectorLTmenu(event) {
    chosenFigure = $('#sector_LT_figure');
    sectorsTable.css({top: sector_LT.position().top + 2, left: sector_LT.position().left + 2, position: "absolute"});
    sectorButtons.forEach(function (button) {
        button.css({transform: "rotate(0deg)"});
    });
    sectorsTable.removeClass("hidden");
}

function createSectorRTmenu(event) {
    chosenFigure = $('#sector_RT_figure');
    sectorsTable.css({top: sector_RT.position().top + 2, left: sector_RT.position().left, position: "absolute"});
    sectorButtons.forEach(function (button) {
        button.css({transform: "rotate(90deg)"});
    });
    sectorsTable.removeClass("hidden");
}

function createSectorLBmenu(event) {
    chosenFigure = $('#sector_LB_figure');
    sectorsTable.css({top: sector_LB.position().top, left: sector_LB.position().left + 2, position: "absolute"});
    sectorButtons.forEach(function (button) {
        button.css({transform: "rotate(-90deg)"});
    });
    sectorsTable.removeClass("hidden");
}

function createSectorRBmenu(event) {
    chosenFigure = $('#sector_RB_figure');
    sectorsTable.css({top: sector_RB.position().top, left: sector_RB.position().left, position: "absolute"});
    sectorButtons.forEach(function (button) {
        button.css({transform: "rotate(180deg)"});
    });
    sectorsTable.removeClass("hidden");
}

function changeSector(event) {
    let target = $(event.target);
    if (sectorButton1.parent().has(target).length) {
        chosenFigure.attr("d", "M 40 200 q 0 -160 160 -160 v 160 Z");
    } else if (sectorButton2.parent().has(target).length) {
        chosenFigure.attr("d", "M 120 200 q 0 -80 80 -80 v 80 Z");
    } else if (sectorButton3.parent().has(target).length) {
        chosenFigure.attr("d", "M 40 40 h 160 v 160 h -160 Z");
    } else if (sectorButton4.parent().has(target).length) {
        chosenFigure.attr("d", "M 120 120 h 80 v 80 h -80 Z");
    } else if (sectorButton5.parent().has(target).length) {
        chosenFigure.attr("d", "");
    } else if (sectorButton6.parent().has(target).length) {
        chosenFigure.attr("d", "M 120 40 h 80 v 160 h -80 Z");
    } else if (sectorButton7.parent().has(target).length) {
        chosenFigure.attr("d", "M 40 120 h 160 v 80 h -160 Z");
    } else if (sectorButton8.parent().has(target).length) {
        chosenFigure.attr("d", "M 40 200 h 160 v -160 Z");
    } else if (sectorButton9.parent().has(target).length) {
        chosenFigure.attr("d", "M 40 200 h 160 v -80 Z");
    }
    chosenFigure.attr("fill", "#3399ff");
    sectorsTable.addClass("hidden");
}

function doLT(e) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    circle.setAttributeNS(null, 'cx', e.pageX - sector_LT.offset().left);
    circle.setAttributeNS(null, 'cy', e.pageY - sector_LT.offset().top);
    circle.setAttributeNS(null, 'r', 3);
    circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
    dots_LT.append(circle);
}

function doRT(e) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    circle.setAttributeNS(null, 'cx', e.pageX - sector_RT.offset().left);
    circle.setAttributeNS(null, 'cy', e.pageY - sector_RT.offset().top);
    circle.setAttributeNS(null, 'r', 3);
    circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
    dots_RT.append(circle);
}

function doLB(e) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    circle.setAttributeNS(null, 'cx', e.pageX - sector_LB.offset().left);
    circle.setAttributeNS(null, 'cy', e.pageY - sector_LB.offset().top);
    circle.setAttributeNS(null, 'r', 3);
    circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
    dots_LB.append(circle);
}

function doRB(e) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    circle.setAttributeNS(null, 'cx', e.pageX - sector_RB.offset().left);
    circle.setAttributeNS(null, 'cy', e.pageY - sector_RB.offset().top);
    circle.setAttributeNS(null, 'r', 3);
    circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
    dots_RB.append(circle);
}

function changeTheme(){
    let dayButtons = $('.chooseGraphSectorDay');
    let nightButtons = $('.chooseGraphSectorNight');
    if (document.getElementById("dayNightSwitch").checked) {
        body.css("background-color", "#FFFFFF");
        body.css('background-image', 'url(images/BG_day.png)');
        $("svg text").attr("fill", "black");
        $("svg path").attr("stroke", "black");
        $("#sectorsTable td").css('border', '1px solid black');
        nightButtons.addClass("chooseGraphSectorDay");
        nightButtons.removeClass('chooseGraphSectorNight');
    } else {
        body.css("background-color", "#151515");
        body.css('background-image', 'url(images/BG_night.png)');
        $("svg text").attr("fill", "white");
        $("svg path").attr("stroke", "white");
        $("#sectorsTable td").css('border', '1px solid white');
        dayButtons.addClass("chooseGraphSectorNight");
        dayButtons.removeClass('chooseGraphSectorDay');
    }
    body.css("background-size", "cover");
}