var sector_LT;

document.addEventListener("DOMContentLoaded", function () {
    sector_LT = $("#sector_LT");
    sector_LT.contextmenu(false);
    sector_LT.contextmenu(createSectorLTMenu);
});

function createSectorLTMenu() {
    let button1 = $("<img src='images/favicon.ico'>");
    $("body").append(button1);
    button1.css({top: sector_LT.position().top, left: sector_LT.position().left, position: "absolute"});
    console.log(sector_LT.position().top);
}

function createSectorRTMenu() {
    let button1 = $("<img src='images/favicon.ico'>");
    $("body").append(button1);
    button1.css({top: sector_LT.position().top, left: sector_LT.position().left, position: "absolute"});
    console.log(sector_LT.position().top);
}

function createSectorLBMenu() {
    let button1 = $("<img src='images/favicon.ico'>");
    $("body").append(button1);
    button1.css({top: sector_LT.position().top, left: sector_LT.position().left, position: "absolute"});
    console.log(sector_LT.position().top);
}

function createSectorRBMenu() {
    let button1 = $("<img src='images/favicon.ico'>");
    $("body").append(button1);
    button1.css({top: sector_LT.position().top, left: sector_LT.position().left, position: "absolute"});
    console.log(sector_LT.position().top);
}
