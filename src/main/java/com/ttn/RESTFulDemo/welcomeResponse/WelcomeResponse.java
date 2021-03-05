package com.ttn.RESTFulDemo.welcomeResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeResponse {

    @RequestMapping(method = RequestMethod.GET, path = "/welcome-response")
    //@GetMapping(path = "/welcome-response")
    public String welcome()
    {
        return "Welcome to spring boot.";
    }
}