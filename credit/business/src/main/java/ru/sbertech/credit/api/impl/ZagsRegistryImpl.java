package ru.sbertech.credit.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbertech.credit.api.ZagsRegistry;
import ru.sbertech.credit.domain.Person;

import java.util.List;

/**
 * Created by anton on 12/1/16.
 */
public class ZagsRegistryImpl implements ZagsRegistry
{
    private static final Logger log = LoggerFactory.getLogger(ZagsRegistryImpl.class);

    public Person getSpouse(Person p) {
        log.info("ZagsRegistryImpl.getSpouse");
        return new Person();
    }

    public List<Person> getChildren(Person p) {
        log.info("ZagsRegistryImpl.getChildren");
        return null;
    }
}
