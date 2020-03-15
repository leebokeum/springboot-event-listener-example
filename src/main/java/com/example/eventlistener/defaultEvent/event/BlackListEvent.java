package com.example.eventlistener.defaultEvent.event;

import org.springframework.context.ApplicationEvent;

public class BlackListEvent extends ApplicationEvent {
    private final String address;
    public final String text;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public BlackListEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }
}
