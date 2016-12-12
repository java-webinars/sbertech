package ru.sbertech.credit.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import ru.sbertech.credit.api.MessageRegister;
import ru.sbertech.credit.domain.Person;


@Component
public class MessageRegisterImpl implements MessageRegister
{
    private static final Logger log = LoggerFactory.getLogger(MessageRegisterImpl.class);

    public Long savePerson(Person p) {
        log.info("MessageRegisterImpl.savePerson");
        return null;
    }
}
