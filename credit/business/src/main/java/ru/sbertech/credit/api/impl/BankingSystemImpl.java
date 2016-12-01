package ru.sbertech.credit.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbertech.credit.api.BankingSystem;
import ru.sbertech.credit.domain.Person;

/**
 * Created by anton on 12/1/16.
 */
public class BankingSystemImpl implements BankingSystem
{
    private static final Logger log = LoggerFactory.getLogger(BankingSystemImpl.class);

    public boolean checkLoan(Person p) {
        log.info("BankingSystemImpl.checkLoan");
        return false;
    }

    public void approveLoan(Person p) {
        log.info("BankingSystemImpl.approveLoan");
    }
}
