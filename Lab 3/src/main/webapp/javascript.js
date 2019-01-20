var chosenFigure;
var sectorButtons;
var chosenArea;

document.addEventListener("DOMContentLoaded", function () {
    updateButtonsList();
    $("#dayNightSwitch").change(changeTheme);
    $("#overlay").css({
        top: $("#sector_LT").position().top,
        left: $("#sector_LT").position().left,
        position: "absolute"
    });
    if ($("#mainform\\:jsfSwitch").attr("value") === "true") {
        document.getElementById("dayNightSwitch").checked = true;
    }
    changeTheme();
    enterEditMode();
    setAreasByBeanValue();
});

function createSectorLTmenu() {
    updateButtonsList();
    chosenFigure = $('#sector_LT_figure');
    chosenArea = $('#mainForm\\:sectorBeanLT');
    $("#sectorsTable").css({
        top: $("#sector_LT").position().top + 2,
        left: $("#sector_LT").position().left + 2,
        position: "absolute"
    });
    sectorButtons.forEach(button => button.css("transform", "rotate(0deg)"));
    $("#sectorsTable").removeClass("hidden");
}

function createSectorRTmenu() {
    updateButtonsList();
    chosenFigure = $('#sector_RT_figure');
    chosenArea = $('#mainForm\\:sectorBeanRT');
    $("#sectorsTable").css({
        top: $("#sector_RT").position().top + 2,
        left: $("#sector_RT").position().left,
        position: "absolute"
    });
    sectorButtons.forEach(button => button.css("transform", "rotate(90deg)"));
    $("#sectorsTable").removeClass("hidden");
}

function createSectorLBmenu() {
    updateButtonsList();
    chosenFigure = $('#sector_LB_figure');
    chosenArea = $('#mainForm\\:sectorBeanLB');
    $("#sectorsTable").css({
        top: $("#sector_LB").position().top,
        left: $("#sector_LB").position().left + 2,
        position: "absolute"
    });
    sectorButtons.forEach(button => button.css("transform", "rotate(-90deg)"));
    $("#sectorsTable").removeClass("hidden");
}

function createSectorRBmenu() {
    chosenFigure = $('#sector_RB_figure');
    chosenArea = $('#mainForm\\:sectorBeanRB');
    $("#sectorsTable").css({
        top: $("#sector_RB").position().top,
        left: $("#sector_RB").position().left,
        position: "absolute"
    });
    sectorButtons.forEach(button => button.css("transform", "rotate(180deg)"));
    $("#sectorsTable").removeClass("hidden");
}

function updateButtonsList() {
    sectorButtons = [$("#sectorButton1"), $("#sectorButton2"), $("#sectorButton3"), $("#sectorButton4"), $("#sectorButton5"), $("#sectorButton6"), $("#sectorButton7"), $("#sectorButton8"), $("#sectorButton9")];
    sectorButtons.forEach(button => button.click(changeSector));
}

function changeSector(event) {
    let target = $(event.target);
    if ($("#sectorButton1").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 200 q 0 -160 160 -160 v 160 Z");
        chosenArea.val("1");
    } else if ($("#sectorButton2").parent().has(target).length) {
        chosenFigure.attr("d", "M 120 200 q 0 -80 80 -80 v 80 Z");
        chosenArea.val("2");
    } else if ($("#sectorButton3").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 40 h 160 v 160 h -160 Z");
        chosenArea.val("3");
    } else if ($("#sectorButton4").parent().has(target).length) {
        chosenFigure.attr("d", "M 120 120 h 80 v 80 h -80 Z");
        chosenArea.val("4");
    } else if ($("#sectorButton5").parent().has(target).length) {
        chosenFigure.attr("d", "");
        chosenArea.val("5");
    } else if ($("#sectorButton6").parent().has(target).length) {
        chosenFigure.attr("d", "M 120 40 h 80 v 160 h -80 Z");
        chosenArea.val("6");
    } else if ($("#sectorButton7").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 120 h 160 v 80 h -160 Z");
        chosenArea.val("7");
    } else if ($("#sectorButton8").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 200 h 160 v -160 Z");
        chosenArea.val("8");
    } else if ($("#sectorButton9").parent().has(target).length) {
        chosenFigure.attr("d", "M 40 200 h 160 v -80 Z");
        chosenArea.val("9");
    }
    chosenFigure.attr("fill", "#3399ff");
    $("#sectorsTable").addClass("hidden");
}

//magic method
function setAreasByBeanValue() {
    $("#overlay").css({
        top: $("#sector_LT").position().top,
        left: $("#sector_LT").position().left,
        position: "absolute"
    });
    changeTheme();
    [$("#mainForm\\:sectorBeanLT"), $("#mainForm\\:sectorBeanRT"), $("#mainForm\\:sectorBeanLB"), $("#mainForm\\:sectorBeanRB")].forEach(function (sectorBean, index) {
        switch (index) {
            case 0:
                chosenFigure = $("#sector_LT_figure");
                break;
            case 1:
                chosenFigure = $("#sector_RT_figure");
                break;
            case 2:
                chosenFigure = $("#sector_LB_figure");
                break;
            case 3:
                chosenFigure = $("#sector_RB_figure");
                break;
        }

        switch (sectorBean.val()) {
            case "1":
                chosenFigure.attr("d", "M 40 200 q 0 -160 160 -160 v 160 Z");
                chosenFigure.attr("fill", "#3399ff");
                break;
            case "2":
                chosenFigure.attr("d", "M 120 200 q 0 -80 80 -80 v 80 Z");
                chosenFigure.attr("fill", "#3399ff");
                break;
            case "3":
                chosenFigure.attr("d", "M 40 40 h 160 v 160 h -160 Z");
                chosenFigure.attr("fill", "#3399ff");
                break;
            case "4":
                chosenFigure.attr("d", "M 120 120 h 80 v 80 h -80 Z");
                chosenFigure.attr("fill", "#3399ff");
                break;
            case "5":
                chosenFigure.attr("d", "");
                break;
            case "6":
                chosenFigure.attr("d", "M 120 40 h 80 v 160 h -80 Z");
                chosenFigure.attr("fill", "#3399ff");
                break;
            case "7":
                chosenFigure.attr("d", "M 40 120 h 160 v 80 h -160 Z");
                chosenFigure.attr("fill", "#3399ff");
                break;
            case "8":
                chosenFigure.attr("d", "M 40 200 h 160 v -160 Z");
                chosenFigure.attr("fill", "#3399ff");
                break;
            case "9":
                chosenFigure.attr("d", "M 40 200 h 160 v -80 Z");
                chosenFigure.attr("fill", "#3399ff");
                break;
        }
    })
}

function drawPoint(e) {
    $("#mainForm\\:x_input").val(Math.round((e.pageX - $("#overlay").offset().left - 200) / 160 * $("#mainForm\\:r").val() * 1000) / 1000);
    $("#mainForm\\:y").val(Math.round(-(e.pageY - $("#overlay").offset().top - 200) / 160 * $("#mainForm\\:r").val() * 1000) / 1000);
    $("#mainForm\\:check").click();
}

function changeTheme() {
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
        $(".box").css("color", "#000000");
        $("#mainform\\:jsfSwitch").val("true");
    } else {
        $("body").css("background-color", "#151515");
        $("body").css('background-image', 'url(images/BG_night.png)');
        $("svg text").attr("fill", "white");
        $("svg path").attr("stroke", "white");
        $("#sectorsTable td").css('border', '1px solid white');
        dayButtons.addClass("chooseGraphSectorNight");
        dayButtons.removeClass('chooseGraphSectorDay');
        $(".box").css("background-color", "rgba(65, 65, 65, 0.7)");
        $(".box").css("color", "#FFFFFF");
        $("#mainform\\:jsfSwitch").val("false");
    }
    $("body").css("background-size", "cover");
}

function enterEditMode() {
    $("#mainForm\\:save").removeClass("hidden");
    $("#r").addClass("hidden");
    $("#rSlider").addClass("hidden");
    $("#x").addClass("hidden");
    $("#y").addClass("hidden");
    $("#boxText").addClass("hidden");
    $("#check").addClass("hidden");
    $("#clearAll").addClass("hidden");
    $("#mainForm\\:edit").addClass("hidden");
    $("#error").addClass("hidden");
    $("#boxResult").addClass("hidden");
    $("#overlay").addClass("hidden");
}

function enterDotMode() {
    $("#mainForm\\:save").addClass("hidden");
    $("#r").removeClass("hidden");
    $("#rSlider").removeClass("hidden");
    $("#x").removeClass("hidden");
    $("#y").removeClass("hidden");
    $("#boxText").removeClass("hidden");
    $("#check").removeClass("hidden");
    $("#clearAll").removeClass("hidden");
    $("#mainForm\\:edit").removeClass("hidden");
    $("#overlay").removeClass("hidden");
    $("#sectorsTable").addClass("hidden");
}