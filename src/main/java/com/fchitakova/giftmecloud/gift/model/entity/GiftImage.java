package com.fchitakova.giftmecloud.gift.model.entity;


import lombok.Data;

import java.util.UUID;

@Data
public class GiftImage {
    private UUID imageId;

    private String imageUrl;

    private Gift gift;
}