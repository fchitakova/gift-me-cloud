package com.fchitakova.giftmecloud.gift.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * TO READ:
     * https://www.baeldung.com/websockets-spring
     * https://spring.io/guides/gs/messaging-stomp-websocket/
     * https://liuzhenglaichn.gitbook.io/system-design/news-feed/design-a-news-feed-system
     */
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic"); // Use "/topic" as the message broker prefix
//        config.setApplicationDestinationPrefixes("/app"); // Use "/app" as the application destination prefix
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws-endpoint").setAllowedOrigins("*").withSockJS(); // Define your WebSocket endpoint
//    }
}