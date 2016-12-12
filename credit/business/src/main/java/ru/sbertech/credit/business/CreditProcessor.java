package ru.sbertech.credit.business;

import com.sun.org.apache.xpath.internal.patterns.ContextMatchStepPattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.sbertech.credit.api.*;
import ru.sbertech.credit.api.impl.ZagsRegistryImpl;
import ru.sbertech.credit.domain.Person;

@Component
public class CreditProcessor
{
    private static final Logger log = LoggerFactory.getLogger(CreditProcessor.class);

    @Autowired
    private MessageRegister messageRegister;
    @Autowired
    private CityPersonRegistry cityPersonRegistry;
    @Autowired
    @Qualifier(value = "zags")
    private ZagsRegistry zagsRegistry;
    @Autowired
    private BankingSystem bankingSystem;
    @Autowired
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
        Long id = messageRegister.savePerson(person);
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
            zagsRegistry.getChildren(person);
            if(bankingSystem.checkLoan(spouse)) {
                messageSystem.sendDeny(person);
                return;
            }
        }
        bankingSystem.approveLoan(person);
        messageSystem.sendApprove(person);
    }

//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext ctx =
//                new ClassPathXmlApplicationContext("credit-spring.xml");
//
//        CreditProcessor cp = ctx.getBean(CreditProcessor.class);
//        cp.processPerson(new Person());
//    }

}
