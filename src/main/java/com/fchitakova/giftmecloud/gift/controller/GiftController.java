package com.fchitakova.giftmecloud.gift.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("api/v1/gifts")
public class GiftController {

    @PostMapping
    public String createGift() {
        System.out.println("GIFT CREATED!!!!");
        return "redirect:/";
    }

}
