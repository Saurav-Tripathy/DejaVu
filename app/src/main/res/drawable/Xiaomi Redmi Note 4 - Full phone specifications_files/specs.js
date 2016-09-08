function showBatteryPopup(evt, id) {
    var batteryPopover = $('#battery-popover');
    if (batteryPopover.html() == "") {
       batteryPopover.load('battery-popup.php3?idPhone=' + id)
    }
    
    batteryPopover.toggle(); 
    
    batteryPopover.click(function (evt2) {
       evt2.stopPropagation();
    });
    $(document).click(function (evt) {
       batteryPopover.hide();
    })
    
    evt.preventDefault();
    evt.stopPropagation();  
}
    
$gsm.onload(function () {
    // toggle price display
    var priceSpans = document.querySelectorAll("span.price");
    for (var i = 0; i < priceSpans.length; i++) {
        var priceLink = priceSpans[i].parentNode.querySelector("a");
        priceLink.onclick = function () {
            var span = this.parentNode.querySelector("span");
            span.style.display = span.style.display == "inline"? "none" : "inline";
            return false;
        }
    }

    var expandAnimationTime = collapseAnimationTime = 300;
    var linkNetworkDetail = $('.link-network-detail');
    var trToggle = $('.tr-toggle');
    var table = trToggle.parents("table");
    var predictedHeight = table.find("tr").length * 20 + "px";
    var tableHeight = linkNetworkDetail.hasClass("collapse")? predictedHeight : table.css("height");
    var nfoTd = table.find(".nfo");
    var tdWidth = nfoTd.css("width");

    linkNetworkDetail.on("click", function(evt) {
        evt.preventDefault();
        evt.stopPropagation();

        $(this).toggleClass("collapse");
        if ($(this).hasClass("collapse")) {
            table.css("display", "block");
            nfoTd.css("width", tdWidth);

            table.stop().animate({height: "24px"}, collapseAnimationTime, function () {
              trToggle.hide();
              table.css("display", "");
              nfoTd.css("width", "");
            });

            $gsm.setCookie("networkVisible", "0", 100 );
        } else {
            table.css("display", "block");
            nfoTd.css("width", tdWidth);
            trToggle.show();

            table.animate({height: tableHeight}, expandAnimationTime, function () {
                table.css({height: "", display: ""});
                nfoTd.css("width", "");
                tableHeight = table.css("height");
            });

            $gsm.setCookie("networkVisible", "1", 100 );
        }        
    });
});
