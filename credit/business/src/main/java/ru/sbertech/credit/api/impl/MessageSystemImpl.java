package ru.sbertech.credit.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbertech.credit.api.MessageSystem;
import ru.sbertech.credit.domain.Person;

/**
 * Created by anton on 12/1/16.
 */
public class MessageSystemImpl implements MessageSystem
{
    private static final Logger log = LoggerFactory.getLogger(MessageSystemImpl.class);

    public void sendApprove(Person p) {
        log.info("MessageSystemImpl.sendApprove");
    }

    public void sendDeny(Person p) {
        log.info("MessageSystemImpl.sendDeny");
    }
}
