package com.example.eventlistener.annotationListener;

import com.example.eventlistener.event.BlackListEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

@Slf4j
public class AnnotationListener {

    //@EventListener 만 선언해주면 된다. 인터페이스를 구현하지 않아도 된다.
    //event안에 text가 foo인 것만 리스너를 호출한다.
    //이벤트 리스너의 순서도 정할 수 있다.
    @EventListener(condition = "#event.text == 'test'")
    @Order(1)
    public void processBlackListEvent(BlackListEvent event) {
        log.info("이벤트 발생 시간 : {}", event.getTimestamp());
        log.info("관리자에게 알리자 : {} " ,"test가 들어간 단어 블락리스트 이벤트 발생!!");
    }

    @EventListener
    @Async
    @Order(2)
    public void processBlackListEventAsync(BlackListEvent event) {
        log.info("이벤트 발생 시간 : {}", event.getTimestamp());
        log.info("관리자에게 알리자 : {} " ,"블락 리스트 비동기 이벤트 발생!!");
    }

}
