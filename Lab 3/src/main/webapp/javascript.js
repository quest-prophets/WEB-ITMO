var chosenFigure;
var sectorButtons;

document.addEventListener("DOMContentLoaded", function () {
    sectorButtons = [$("#sectorButton1"), $("#sectorButton2"), $("#sectorButton3"), $("#sectorButton4"), $("#sectorButton5"), $("#sectorButton6"), $("#sectorButton7"), $("#sectorButton8"), $("#sectorButton9")];
    $("#dayNightSwitch").change(changeTheme);
    $("#sector_LT").click(createSectorLTmenu);
    $("#sector_RT").click(createSectorRTmenu);
    $("#sector_LB").click(createSectorLBmenu);
    $("#sector_RB").click(createSectorRBmenu);
    sectorButtons.forEach(function (button) {
        button.click(changeSector);
    });
    $("#edit").click(enterEditMode);
    $("#save").click(enterDotMode);
    $("#overlay").click(drawPoint);
    $("#clearAll").click(clearDots);
    changeTheme();
    enterEditMode();
});

function createSectorLTmenu(event) {
    chosenFigure = $('#sector_LT_figure');
    $("#sectorsTable").css({top: $("#sector_LT").position().top + 2, left: $("#sector_LT").position().left + 2, position: "absolute"});
    sectorButtons.forEach(function (button) {
        button.css({transform: "rotate(0deg)"});
    });
    $("#sectorsTable").removeClass("hidden");
}

function createSectorRTmenu(event) {
    chosenFigure = $('#sector_RT_figure');
    $("#sectorsTable").css({top: $("#sector_RT").position().top + 2, left: $("#sector_RT").position().left, position: "absolute"});
    sectorButtons.forEach(function (button) {
        button.css({transform: "rotate(90deg)"});
    });
    $("#sectorsTable").removeClass("hidden");
}

function createSectorLBmenu(event) {
    chosenFigure = $('#sector_LB_figure');
    $("#sectorsTable").css({top: $("#sector_LB").position().top, left: $("#sector_LB").position().left + 2, position: "absolute"});
    sectorButtons.forEach(function (button) {
        button.css({transform: "rotate(-90deg)"});
    });
    $("#sectorsTable").removeClass("hidden");
}

function createSectorRBmenu(event) {
    chosenFigure = $('#sector_RB_figure');
    $("#sectorsTable").css({top: $("#sector_RB").position().top, left: $("#sector_RB").position().left, position: "absolute"});
    sectorButtons.forEach(function (button) {
        button.css({transform: "rotate(180deg)"});
    });
    $("#sectorsTable").removeClass("hidden");
}

function changeSector(event) {
    let target = $(event.target);
    if ($("#sectorButton1").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 200 q 0 -160 160 -160 v 160 Z");
    } else if ($("#sectorButton2").parent().has(target).length) {
        chosenFigure.attr("d", "M 120 200 q 0 -80 80 -80 v 80 Z");
    } else if ($("#sectorButton3").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 40 h 160 v 160 h -160 Z");
    } else if ($("#sectorButton4").parent().has(target).length) {
        chosenFigure.attr("d", "M 120 120 h 80 v 80 h -80 Z");
    } else if ($("#sectorButton5").parent().has(target).length) {
        chosenFigure.attr("d", "");
    } else if ($("#sectorButton6").parent().has(target).length) {
        chosenFigure.attr("d", "M 120 40 h 80 v 160 h -80 Z");
    } else if ($("#sectorButton7").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 120 h 160 v 80 h -160 Z");
    } else if ($("#sectorButton8").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 200 h 160 v -160 Z");
    } else if ($("#sectorButton9").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 200 h 160 v -80 Z");
    }
    chosenFigure.attr("fill", "#3399ff");
    $("#sectorsTable").addClass("hidden");
}

function drawPoint(e) {
    const circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    circle.setAttributeNS(null, 'cx', e.pageX - $("#overlay").offset().left);
    circle.setAttributeNS(null, 'cy', e.pageY - $("#overlay").offset().top);
    circle.setAttributeNS(null, 'r', 3);
    circle.setAttributeNS(null, 'style', 'fill: red; stroke: red; stroke-width: 1px;');
    $("#overlay").append(circle);
}

function clearDots() {
    $("#overlay").children().each((i, dot) => dot.remove());
}

function changeTheme(){
    let dayButtons = $('.chooseGraphSectorDay');
    let nightButtons = $('.chooseGraphSectorNight');
    if (document.getElementById("dayNightSwitch").checked) {
        $("body").css("background-color", "#FFFFFF");
        $("body").css('background-image', 'url(images/BG_day.png)');
        $("svg text").attr("fill", "black");
        $("svg path").attr("stroke", "black");
        $("#sectorsTable td").css('border', '1px solid black');
        nightButtons.addClass("chooseGraphSectorDay");
        nightButtons.removeClass('chooseGraphSectorNight');
        $(".box").css("background-color", "rgba(255, 255, 255, 0.7)");
        $(".box").css("color", "#000000")
    } else {
        $("body").css("background-color", "#151515");
        $("body").css('background-image', 'url(images/BG_night.png)');
        $("svg text").attr("fill", "white");
        $("svg path").attr("stroke", "white");
        $("#sectorsTable td").css('border', '1px solid white');
        dayButtons.addClass("chooseGraphSectorNight");
        dayButtons.removeClass('chooseGraphSectorDay');
        $(".box").css("background-color", "rgba(65, 65, 65, 0.7)");
        $(".box").css("color", "#FFFFFF")
    }
    $("body").css("background-size", "cover");
}

function enterEditMode() {
    $("#save").removeClass("hidden");
    $("#r").addClass("hidden");
    $("#rSlider").addClass("hidden");
    $("#x").addClass("hidden");
    $("#y").addClass("hidden");
    $("#boxText").addClass("hidden");
    $("#check").addClass("hidden");
    $("#clearAll").addClass("hidden");
    $("#edit").addClass("hidden");
    $("#error").addClass("hidden");
    $("#boxResult").addClass("hidden");
    $("#overlay").addClass("hidden");
}

function enterDotMode() {
    $("#save").addClass("hidden");
    $("#r").removeClass("hidden");
    $("#rSlider").removeClass("hidden");
    $("#x").removeClass("hidden");
    $("#y").removeClass("hidden");
    $("#boxText").removeClass("hidden");
    $("#check").removeClass("hidden");
    $("#clearAll").removeClass("hidden");
    $("#edit").removeClass("hidden");
    $("#overlay").removeClass("hidden");
    $("#sectorsTable").addClass("hidden");
}