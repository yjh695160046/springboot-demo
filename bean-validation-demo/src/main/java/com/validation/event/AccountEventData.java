package com.validation.event;

/**
 * 类描述：AccountEventData
 *
 * @author yaojinhua
 * @version v1.0
 * @date 2023-02-15 17:38
 */
public class AccountEventData extends AccountEvent {
    /**
     * @param source    最初触发该事件的对象
     * @param eventData 该类型事件携带的信息
     */
    public AccountEventData(Object source, AccountEventData eventData) {
        super(source, eventData);
    }

}
