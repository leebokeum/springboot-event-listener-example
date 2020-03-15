package com.example.eventlistener.implementListener;

import com.example.eventlistener.event.BlackListEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

@Slf4j
public class EventListener implements ApplicationListener<BlackListEvent> {

    @Order(3)
    @Override
    public void onApplicationEvent(BlackListEvent event) {
        log.info("이벤트 발생 시간 : {}", event.getTimestamp());
        log.info("관리자에게 알리자 : {} " , "블락 리스트 이벤트 발생!!");
    }
}
