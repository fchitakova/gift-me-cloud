package com.fchitakova.giftmecloud.gift.model.mapper;

import com.fchitakova.giftmecloud.gift.model.dto.GiftDTO;
import com.fchitakova.giftmecloud.gift.model.entity.Gift;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface GiftMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(source = "images", target = "images", ignore = true)
    Gift dtoToEntity(GiftDTO giftDTO);
}