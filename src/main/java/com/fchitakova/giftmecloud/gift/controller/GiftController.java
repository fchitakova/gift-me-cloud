package com.fchitakova.giftmecloud.gift.controller;


import com.fchitakova.giftmecloud.gift.model.dto.GiftDTO;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("api/v1/gifts")
public class GiftController {

    @Value("${upload.directory}")
    private String uploadDirectory;

    @PostMapping
    public String createGift(@ModelAttribute("gift") GiftDTO gift) {
        log.info("GIFT CREATED!!!!");
        try {
            for (MultipartFile file : gift.getImages()) {
                String fileName = file.getOriginalFilename();
                String filePath = uploadDirectory + "/" + fileName;
                file.transferTo(new File(filePath));
                // You can save the file path in your GiftDTO or database for reference
            }
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
