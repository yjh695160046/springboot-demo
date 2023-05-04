package com.validation.event;

/**
 * 类描述：AccountCreatedEvent
 *
 * @author yaojinhua
 * @version v1.0
 * @date 2023-02-15 17:40
 */
public class AccountCreatedEvent extends AccountEvent {

    public AccountCreatedEvent(Object source, AccountEventData eventData) {
        super(source, eventData);
    }
}