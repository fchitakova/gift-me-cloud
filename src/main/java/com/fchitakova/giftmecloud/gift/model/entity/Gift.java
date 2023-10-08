package com.fchitakova.giftmecloud.gift.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gift {
    private UUID giftId;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private boolean isActive = true;
    @NotNull
    private List<GiftImage> images;

//    private User owner;
//    private Group group;
//    private User takenBy;
}