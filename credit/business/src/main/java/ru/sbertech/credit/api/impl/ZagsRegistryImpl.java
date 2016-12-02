package ru.sbertech.credit.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import ru.sbertech.credit.api.ZagsRegistry;
import ru.sbertech.credit.domain.Person;

import java.util.List;

/**
 * Created by anton on 12/1/16.
 */
public class ZagsRegistryImpl implements ZagsRegistry
{
    private static final Logger log = LoggerFactory.getLogger(ZagsRegistryImpl.class);

    private String testValue1;

    @Value("${test.testValue2}")
    private String testValue2;

    public void setTestValue1(String testValue1) {
        this.testValue1 = testValue1;
    }

    public Person getSpouse(Person p) {
        log.info("ZagsRegistryImpl.getSpouse:" + testValue1);
        return new Person();
    }

    public List<Person> getChildren(Person p) {
        log.info("ZagsRegistryImpl.getChildren:" + testValue2);
        return null;
    }
}
