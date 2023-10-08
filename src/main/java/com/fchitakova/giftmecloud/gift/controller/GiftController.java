package com.fchitakova.giftmecloud.gift.controller;

import com.fchitakova.giftmecloud.gift.model.dto.GiftDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("api/v1/gifts")
public class GiftController {

    @Value("${upload.directory}")
    private String uploadDirectory;

    //TO DO: ADD @Valid annotation to GiftDTO, once the bug is fixed
    @PostMapping
    public String createGift(@ModelAttribute("gift") GiftDTO gift) {
        try {
            for (MultipartFile file : gift.getImages()) {
                String fileName = file.getOriginalFilename();
                String filePath = uploadDirectory + "/" + fileName;
                file.transferTo(new File(filePath));
                // You can save the file path in your GiftDTO or database for reference
            }
            log.info("GIFT CREATED!!!!");
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
