package ru.sbertech.credit.api;

import ru.sbertech.credit.domain.Person;

import java.util.List;

/**
 * Created by anton on 12/1/16.
 */
public interface ZagsRegistry
{
    Person getSpouse(Person p);
    List<Person> getChildren(Person p);
}
