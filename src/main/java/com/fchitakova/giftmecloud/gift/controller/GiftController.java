package com.fchitakova.giftmecloud.gift.controller;


import com.fchitakova.giftmecloud.gift.model.dto.GiftDTO;
import com.fchitakova.giftmecloud.gift.model.entity.Gift;
import com.fchitakova.giftmecloud.gift.model.entity.GiftImage;
import com.fchitakova.giftmecloud.gift.model.mapper.GiftMapper;
import com.fchitakova.giftmecloud.gift.repository.GiftRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("api/v1/gifts")
@RequiredArgsConstructor
public class GiftController {

    private final GiftMapper giftMapper;
    private final GiftRepository giftRepository;

    @Value("${upload.directory}")
    private String uploadDirectory;

    @PostMapping
    public String createGift(@ModelAttribute("gift") @Valid GiftDTO gift) {
        Gift giftEntity = giftMapper.dtoToEntity(gift);
        giftEntity.setImages(saveAndGetGiftImages(gift.getImages(), giftEntity));
        Gift entity = giftRepository.save(giftEntity);

        log.info("Created gift with id {}.", entity.getId().toString());

        return "redirect:/";
    }

    @SneakyThrows
    private List<GiftImage> saveAndGetGiftImages(List<MultipartFile> multipartFiles, Gift gift) {
        List<GiftImage> giftImages = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            String fileName = file.getOriginalFilename();
            String filePath = uploadDirectory + "/" + fileName;
            file.transferTo(new File(filePath));

            GiftImage giftImage = new GiftImage(filePath, gift);
            giftImages.add(giftImage);
        }
        return giftImages;
    }

}
