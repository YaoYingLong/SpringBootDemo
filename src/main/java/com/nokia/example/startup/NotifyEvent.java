package com.nokia.example.startup;

import org.springframework.context.ApplicationEvent;

/**
 * @author by YingLong on 2021/6/17
 */
public class NotifyEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public NotifyEvent(Object source) {
        super(source);
    }
}
