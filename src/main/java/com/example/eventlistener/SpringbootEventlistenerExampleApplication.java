package com.example.eventlistener;

import com.example.eventlistener.defaultEvent.annotationListener.AnnotationListener;
import com.example.eventlistener.defaultEvent.implementListener.EventListener;
import com.example.eventlistener.defaultEvent.event.EventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootEventlistenerExampleApplication {

    @Bean
    public EventPublisher eventPublisher(){
        EventPublisher eventPublisher = new EventPublisher();
        eventPublisher.setBlackList(Arrays.asList("test@test.com", "wonwoo@test.com", "5151@test.com"));
        return eventPublisher;
    }

    @Bean
    public EventListener eventListener(){
        EventListener eventListener = new EventListener();
        return eventListener;
    }

    @Bean
    public AnnotationListener annotationListener(){
        AnnotationListener annotationListener = new AnnotationListener();
        return annotationListener;
    }

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(SpringbootEventlistenerExampleApplication.class, args);
        //Spring 4.2 이전에는 어노테이션이 없어서 직접 상속받아 구현
        EventPublisher bean = run.getBean(EventPublisher.class);
        bean.publishEvent("wonwoo@test.com", "hi wonwoo");
        bean.publishEvent("wonwoo@test.com", "test");


    }

}
