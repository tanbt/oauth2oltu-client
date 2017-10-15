package com.javatpoint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

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


}
