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
    sector_LT = $("#sector_LT");
    sector_RT = $("#sector_RT");
    sector_LB = $("#sector_LB");
    sector_RB = $("#sector_RB");
    sector_LT.contextmenu(false);
    sector_RT.contextmenu(false);
    sector_LB.contextmenu(false);
    sector_RB.contextmenu(false);
    sector_LT.contextmenu(createSectorLTmenu); // когда придумаешь как объединить все функции в одну - объединишь ;-) пока не надо)
    sector_RT.contextmenu(createSectorRTmenu);
    sector_LB.contextmenu(createSectorLBmenu);
    sector_RB.contextmenu(createSectorRBmenu);
});

function createSectorLTmenu(event) {
    sectorButton1.css({top: sector_LT.position().top +2, left: sector_LT.position().left +2, position: "absolute"});
    sectorButton2.css({top: sector_LT.position().top +2, left: sector_LT.position().left +68, position: "absolute"});
    sectorButton3.css({top: sector_LT.position().top +2, left: sector_LT.position().left +134, position: "absolute"});
    sectorButton4.css({top: sector_LT.position().top +68, left: sector_LT.position().left +2, position: "absolute"});
    sectorButton5.css({top: sector_LT.position().top +68, left: sector_LT.position().left +68, position: "absolute"});
    sectorButton6.css({top: sector_LT.position().top +68, left: sector_LT.position().left +134, position: "absolute"});
    sectorButton7.css({top: sector_LT.position().top +134, left: sector_LT.position().left +2, position: "absolute"});
    sectorButton8.css({top: sector_LT.position().top +134, left: sector_LT.position().left +68, position: "absolute"});
    sectorButton9.css({top: sector_LT.position().top +134, left: sector_LT.position().left +134, position: "absolute"});

    sectorButton1.removeClass("hidden");
    sectorButton2.removeClass("hidden");
    sectorButton3.removeClass("hidden");
    sectorButton4.removeClass("hidden");
    sectorButton5.removeClass("hidden");
    sectorButton6.removeClass("hidden");
    sectorButton7.removeClass("hidden");
    sectorButton8.removeClass("hidden");
    sectorButton9.removeClass("hidden");
}

function createSectorRTmenu(event) {
    console.log(event.target.id);
    let button1 = $("<img src='images/favicon.ico'>");
    $("body").append(button1);
    button1.css({top: sector_LT.position().top, left: sector_LT.position().left, position: "absolute"});
    console.log(sector_LT.position().top);
}

function createSectorLBmenu(event) {
    console.log(event.target.id);
    let button1 = $("<img src='images/favicon.ico'>");
    $("body").append(button1);
    button1.css({top: sector_LT.position().top, left: sector_LT.position().left, position: "absolute"});
    console.log(sector_LT.position().top);
}

function createSectorRBmenu(event) {
    console.log(event.target.id);
    let button1 = $("<img src='images/favicon.ico'>");
    $("body").append(button1);
    button1.css({top: sector_LT.position().top, left: sector_LT.position().left, position: "absolute"});
    console.log(sector_LT.position().top);
}
