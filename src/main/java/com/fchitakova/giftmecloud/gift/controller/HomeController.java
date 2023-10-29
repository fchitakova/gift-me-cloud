package com.fchitakova.giftmecloud.gift.controller;

import com.fchitakova.giftmecloud.gift.model.dto.GiftDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        if (true) {
            model.addAttribute("gift", new GiftDTO());
            return "gifts-feed";
        }
        return "index";
    }
}
