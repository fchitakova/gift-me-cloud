package com.fchitakova.giftmecloud.controller;

import com.fchitakova.giftmecloud.gift.controller.GiftController;
import com.fchitakova.giftmecloud.gift.model.entity.Gift;
import com.fchitakova.giftmecloud.gift.model.mapper.GiftMapper;
import com.fchitakova.giftmecloud.gift.repository.GiftRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(GiftController.class)
public class GiftControllerTest {
    public static final String CREATE_GIFT_URL = "/api/v1/gifts";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GiftRepository giftRepository;

    @MockBean
    private GiftMapper giftMapper;

    @Test
    public void testCreateGiftSuccessfully(@Mock Gift gift) throws Exception {
        when(gift.getId()).thenReturn(UUID.randomUUID());
        when(giftMapper.dtoToEntity(any())).thenReturn(gift);
        when(giftRepository.save(any())).thenReturn(gift);

        mockMvc.perform(MockMvcRequestBuilders.multipart(CREATE_GIFT_URL)
                        .file(new MockMultipartFile("images", "test-image.jpg", "image/jpeg", "image data".getBytes()))
                        .param("title", "Test Gift")
                        .param("description", "DescrscriptionDescriptionDescriptionDescriptionDescription")
                )
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }

    @Test
    public void testCreateGiftThrowsBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart(CREATE_GIFT_URL)
                        .file(new MockMultipartFile("images", "test-image.jpg", "image/jpeg", "image data".getBytes()))
                        .param("title", "Test Gift")
                        .param("description", "D")
                )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

}

