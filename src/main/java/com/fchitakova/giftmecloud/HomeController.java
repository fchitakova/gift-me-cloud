package com.fchitakova.giftmecloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        /**
         * TO DO: Change if statement's condition to check if the current user is authenticated ,
         * when authentication is added.
         *
         */
        if (true) {
            return "gifts-feed";
        }
        return "index";
    }
}
