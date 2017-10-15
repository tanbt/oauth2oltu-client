$(document).ready(function() {
    console.log("loadled");

    $(".oauth-button").click(function () {
        var oauthUrl = "http://localhost:8080/oauth2/login?redirect_uri=http://localhost:8081/loginByOauth&scope=read_ekycclaims&response_type=code&client_id=clientid";
        // window.open(oauthUrl, 'targetWindow',
        //     'toolbar=no, location = no, status = no, menubar = no, scrollbars = yes, esizable = yes, width = 500px, height = 500px');
        window.location.replace(oauthUrl);
        return false;
    });

});
