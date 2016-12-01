package ru.sbertech.credit.api;

import ru.sbertech.credit.domain.Person;

/**
 * Created by anton on 12/1/16.
 */
public interface CityPersonRegistry
{
    boolean checkPerson(Person p);
}
