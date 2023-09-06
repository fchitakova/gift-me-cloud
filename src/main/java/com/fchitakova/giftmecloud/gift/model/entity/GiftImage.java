package com.fchitakova.giftmecloud.gift.model.entity;


import com.fchitakova.giftmecloud.gift.model.entity.Gift;
import lombok.Data;

@Data
public class GiftImage {
    private Long imageId;

    private String imageUrl;

    private Gift gift;
}