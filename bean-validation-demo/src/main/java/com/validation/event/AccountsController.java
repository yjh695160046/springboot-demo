package com.validation.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 类描述：AccountsController
 *
 * @author yaojinhua
 * @version v1.0
 * @date 2023-02-15 17:51
 */
@RestController
@RequestMapping("/event")
public class AccountsController {

    @Resource
    private ApplicationEventPublisher publisher;

    @PostMapping("/test1")
    public Object createAccount(@RequestBody Map<Object, Object> account) {

        // do something

//        publisher.publishEvent(new AccountCreatedEvent(this, new AccountEvent()));

        return account;
    }

}
