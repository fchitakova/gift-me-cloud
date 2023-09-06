package com.fchitakova.giftmecloud.gift.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gift {
    private UUID giftId;
    private String title;
    private String description;
    private boolean isActive;
    private List<GiftImage> images;

//    private User owner;
//    private Group group;
//    private User takenBy;
}