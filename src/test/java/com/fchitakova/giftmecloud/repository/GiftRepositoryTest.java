package com.fchitakova.giftmecloud.repository;

import com.fchitakova.giftmecloud.gift.model.entity.Gift;
import com.fchitakova.giftmecloud.gift.repository.GiftRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class GiftRepositoryTest {

    @Autowired
    private GiftRepository giftRepository;

    @Test
    public void testSaveGift() {
        Gift gift = new Gift();
        gift.setTitle("Test Gift");
        gift.setDescription("test description");

        giftRepository.save(gift);

        assertNotNull(gift.getId().toString());

        Optional<Gift> fetchedGift = giftRepository.findById(gift.getId());
        assertTrue(fetchedGift.isPresent());
        assertEquals(gift.getTitle(), fetchedGift.get().getTitle());
        assertEquals(gift.getDescription(), fetchedGift.get().getDescription());
    }
}