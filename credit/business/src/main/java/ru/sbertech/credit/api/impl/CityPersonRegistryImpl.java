package ru.sbertech.credit.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbertech.credit.api.CityPersonRegistry;
import ru.sbertech.credit.domain.Person;

/**
 * Created by anton on 12/1/16.
 */
public class CityPersonRegistryImpl implements CityPersonRegistry
{
    private static final Logger log = LoggerFactory.getLogger(CityPersonRegistryImpl.class);

    public boolean checkPerson(Person p) {
        log.info("CityPersonRegistryImpl.checkPerson");
        return true;
    }
}
