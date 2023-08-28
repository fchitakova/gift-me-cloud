package com.fchitakova.giftmecloud.gift.model;

import lombok.Data;

import java.util.List;

@Data
//@Entity
public class Gift {
    private Long giftId;

    private String title;
    private String description;

//    private User owner;
//
//    private Group group;
//
//    private User takenBy;

    private boolean isActive;

    private List<GiftImage> images;
}