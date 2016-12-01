package ru.sbertech.credit.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbertech.credit.api.*;
import ru.sbertech.credit.domain.Person;

/**
 * Created by anton on 12/1/16.
 */
public class CreditProcessor
{
    private MessageRegister messageRegister;
    private CityPersonRegistry cityPersonRegistry;
    private ZagsRegistry zagsRegistry;
    private BankingSystem bankingSystem;
    private MessageSystem messageSystem;

    public void setMessageRegister(MessageRegister messageRegister) {
        this.messageRegister = messageRegister;
    }

    public void setCityPersonRegistry(CityPersonRegistry cityPersonRegistry) {
        this.cityPersonRegistry = cityPersonRegistry;
    }

    public void setZagsRegistry(ZagsRegistry zagsRegistry) {
        this.zagsRegistry = zagsRegistry;
    }

    public void setBankingSystem(BankingSystem bankingSystem) {
        this.bankingSystem = bankingSystem;
    }

    public void setMessageSystem(MessageSystem messageSystem) {
        this.messageSystem = messageSystem;
    }

    public void processPerson(Person person) {
        messageRegister.savePerson(person);
        if(!cityPersonRegistry.checkPerson(person)) {
            messageSystem.sendDeny(person);
            return;
        }
        if(bankingSystem.checkLoan(person)) {
            messageSystem.sendDeny(person);
            return;
        }
        Person spouse = zagsRegistry.getSpouse(person);
        if(spouse != null) {
            if(bankingSystem.checkLoan(spouse)) {
                messageSystem.sendDeny(person);
                return;
            }
        }
        bankingSystem.approveLoan(person);
        messageSystem.sendApprove(person);
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"credit-spring.xml"});

        CreditProcessor cp = context.getBean("creditProcessor", CreditProcessor.class);
        cp.processPerson(new Person());

    }
}
