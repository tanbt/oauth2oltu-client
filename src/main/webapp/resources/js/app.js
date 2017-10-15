$(document).ready(function() {
    console.log("loadled");

    $(".oauth-button").click(function () {
        var oauthUrl = "http://localhost:8080/oauth2/login?redirect=http://localhost:8081/login&client_id=123456#more-parameters-here";
        window.open(oauthUrl, 'targetWindow',
            'toolbar=no, location = no, status = no, menubar = no, scrollbars = yes, esizable = yes, width = 500px, height = 500px');
        return false;
    });

});
