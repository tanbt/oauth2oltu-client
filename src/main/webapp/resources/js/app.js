$(document).ready(function() {
    $(".oauth-button-code").click(function () {
        var oauthUrlCode = "http://localhost:8080/oauth2/login?redirect_uri=http://localhost:8081/loginByOauth&scope=read_ekycclaims&response_type=code&client_id=clientid";
        // window.open(oauthUrl, 'targetWindow',
        //     'toolbar=no, location = no, status = no, menubar = no, scrollbars = yes, esizable = yes, width = 500px, height = 500px');
        $( location ).attr("href", oauthUrlCode);
        return false;
    });

    $(".oauth-button-token").click(function () {
        var oauthUrlToken = "http://localhost:8080/oauth2/login?redirect_uri=http://localhost:8081/loginByOauth&scope=read_ekycclaims&response_type=token&client_id=clientid";
        $( location ).attr("href", oauthUrlToken);
        return false;
    });

});
