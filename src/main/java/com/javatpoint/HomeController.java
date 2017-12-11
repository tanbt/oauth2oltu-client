package com.javatpoint;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Controller
public class HomeController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);


    private static final String HOST_TOKEN_URL =
            "http://localhost:8080/oauth/token";

    private static final String USER_RESOURCE_ENDPOINT =
            "http://localhost:8080/oauth/user";

    private static final String CLIENT_REDIRECT_URL =
            "http://localhost:8081/loginByOauth";

    private static final String CLIENT_ID = "testid1234";
    private static final String CLIENT_SECRET = "testid1234secret";

    @RequestMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("home", "msg",
                "Welcome to Client " + "Website.");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin() {
        //check oauth query parameter
        return new ModelAndView("login", "msg", "Hello First Spring");
    }

    @RequestMapping(value = "/loginByOauth", method = RequestMethod.GET)
    public ModelAndView getLoginOauth(HttpServletRequest request) {
        String oauthCode = request.getParameter("code");
        if (oauthCode != null) {
            JsonObject respondedJson = getAccessToken(oauthCode);
            if (respondedJson == null) {
                return new ModelAndView("welcome", "msg",
                        "Cannot get Access Token");
            }
            String accessToken = respondedJson.get("access_token").getAsString();

            JsonObject userResourceData = getUserResource(accessToken);
            if (userResourceData == null) {
                return new ModelAndView("welcome", "msg", "Cannot get user" +
                        " data");
            }

            return new ModelAndView("welcome", "msg", userResourceData);
        } else {
            return new ModelAndView("welcome", "msg", "Missing " +
                    "authentication code");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView postLogin(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if (userName .equals("demo") && password.equals("demo")) {
            return new ModelAndView("home", "msg", "Welcome, " + userName
                    + ".");
        }

        return new ModelAndView("home", "msg", "Please <a href=\"/login\">" +
                " try again</a>.");
    }

    // Based on API Documentation, responding data is always JSON.
    private JsonObject getAccessToken(String code) {
        try {
            String response = Request.Post(HOST_TOKEN_URL)
                    .bodyForm(
                            Form.form()
                                    .add("redirect_uri",  CLIENT_REDIRECT_URL)
                                    .add("grant_type", "authorization_code")
                                    .add("code", code)
                                    .add("client_id", CLIENT_ID)
                                    .add("client_secret", CLIENT_SECRET)
                                    .build())
                    .execute().returnContent().asString();
            JsonParser parser = new JsonParser();
            return parser.parse(response).getAsJsonObject();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    private JsonObject getUserResource(String accessToken) {
        try {
            String response = Request.Get(USER_RESOURCE_ENDPOINT)
                    .addHeader("Authorization", "Bearer " + accessToken)
                    .execute().returnContent().asString();
            JsonParser parser = new JsonParser();
            return parser.parse(response).getAsJsonObject();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }
}
