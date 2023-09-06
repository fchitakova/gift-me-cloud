package com.fchitakova.giftmecloud.gift.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftDTO implements Serializable {
        private String title;
        private String description;
        private List<MultipartFile> images;
}
