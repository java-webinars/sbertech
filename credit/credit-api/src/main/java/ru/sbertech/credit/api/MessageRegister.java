package ru.sbertech.credit.api;


import ru.sbertech.credit.domain.Person;

public interface MessageRegister
{
    Long savePerson(Person p);
}
