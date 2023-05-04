package com.yijian.springcommon.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yaojinhua
 * 账户相关的事件
 */
public abstract class AccountEvent extends ApplicationEvent {

    /**
     * 该类型事件携带的信息
     */
    private AccountEventData eventData;

    /**
     *
     * @param source 最初触发该事件的对象
     * @param eventData 该类型事件携带的信息
     */
    public AccountEvent(Object source, AccountEventData eventData) {
        super(source);
        this.eventData = eventData;
    }

    public AccountEventData getEventData() {
        return eventData;
    }

}
