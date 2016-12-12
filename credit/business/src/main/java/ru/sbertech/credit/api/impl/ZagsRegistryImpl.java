package ru.sbertech.credit.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.sbertech.credit.api.ZagsRegistry;
import ru.sbertech.credit.domain.Person;

import java.util.List;

@Component(value = "zags")
public class ZagsRegistryImpl implements ZagsRegistry
{
    private static final Logger log = LoggerFactory.getLogger(ZagsRegistryImpl.class);

    @Value("SUPER super")
    private String testValue1;

    @Value("${test.testValue2}")
    private String testValue2;

    public Person getSpouse(Person p) {
        log.info("ZagsRegistryImpl.getSpouse:" + testValue1);
        return new Person();
    }

    public List<Person> getChildren(Person p) {
        log.info("ZagsRegistryImpl.getChildren:" + testValue2);
        return null;
    }
}
