$(document).ready(function() {
    $(".oauth-button-code").click(function () {
        var oauthUrlCode = "http://localhost:8080/oauth2/login?redirect_uri=http://localhost:8081/loginByOauth&scope=user:read&response_type=code&client_id=testid1234";
        // window.open(oauthUrl, 'targetWindow',
        //     'toolbar=no, location = no, status = no, menubar = no, scrollbars = yes, esizable = yes, width = 500px, height = 500px');
        $( location ).attr("href", oauthUrlCode);
        return false;
    });

    $(".oauth-button-token").click(function () {
        var oauthUrlToken = "http://localhost:8080/oauth2/login?redirect_uri=http://localhost:8081/loginByOauth&scope=user:read&response_type=token&client_id=testid1234";
        $( location ).attr("href", oauthUrlToken);
        return false;
    });

});
