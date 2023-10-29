package com.fchitakova.giftmecloud.gift.repository;

import com.fchitakova.giftmecloud.gift.model.entity.Gift;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GiftRepository extends CrudRepository<Gift, UUID> {
}
