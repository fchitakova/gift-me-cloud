package com.fchitakova.giftmecloud.gift.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftDTO implements Serializable {
        @NotBlank(message = "Title is required.")
        @Size(min = 5, message = "Please choose a longer title.")
        private String title;

        @NotBlank(message = "Description is required.")
        @Size(min = 25, message = "Please choose a longer description.")
        private String description;

        @NotEmpty(message = "At least 3 images of the gift are required")
        @Size(min = 3, message = "Please upload at least 3 different photos of the gift.")
        private List<MultipartFile> images;
}
