(function () {
    "use strict";

    var path = window.location.pathname;
    var links = document.querySelectorAll(".main-nav a");

    links.forEach(function (link) {
        var href = link.getAttribute("href");
        var esActivo = href === path || (href !== "/" && path.indexOf(href) === 0);
        if (esActivo) {
            link.classList.add("active");
        }
    });
})();
