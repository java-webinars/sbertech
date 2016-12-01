package ru.sbertech.credit.api;

import ru.sbertech.credit.domain.Person;

public interface MessageSystem
{
    void sendApprove(Person p);
    void sendDeny(Person p);
}
