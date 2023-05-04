package com.yijian.springcommon.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 类描述：SyncAccountListener
 *
 * @author yaojinhua
 * @version v1.0
 * @date 2023-02-15 17:54
 */
@Slf4j
@Component
public class SyncAccountListener {

    /**
     * 异步创建用户
     * @param event
     */
    @EventListener(AccountCreatedEvent.class)
    public void doAccountCreatedEvent(Object event) {
        try {
            log.debug("before" + event);
            Thread.sleep(1000);
            log.debug("after"  + event);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
