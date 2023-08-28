package com.fchitakova.giftmecloud.gift.model;


import lombok.Data;

@Data
public class GiftImage {
    private Long imageId;

    private String imageUrl;

    private Gift gift;
}