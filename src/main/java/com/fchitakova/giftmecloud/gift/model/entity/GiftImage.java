package com.fchitakova.giftmecloud.gift.model.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@RequiredArgsConstructor
public class GiftImage {
    private UUID imageId;

    private final String imageUrl;
    @ManyToOne
    private final Gift gift;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
}