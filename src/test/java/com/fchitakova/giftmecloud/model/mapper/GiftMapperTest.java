package com.fchitakova.giftmecloud.model.mapper;

import com.fchitakova.giftmecloud.gift.model.dto.GiftDTO;
import com.fchitakova.giftmecloud.gift.model.entity.Gift;
import com.fchitakova.giftmecloud.gift.model.mapper.GiftMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GiftMapperTest {

    @Autowired
    private GiftMapper giftMapper;

    @Test
    public void testDtoToEntityMapping() {
        GiftDTO giftDTO = new GiftDTO();
        giftDTO.setTitle("Test Gift");
        giftDTO.setDescription("Sample description");

        Gift gift = giftMapper.dtoToEntity(giftDTO);

        assertEquals(giftDTO.getTitle(), gift.getTitle());
        assertEquals(giftDTO.getDescription(), gift.getDescription());
        assertTrue(gift.isActive());
    }
}