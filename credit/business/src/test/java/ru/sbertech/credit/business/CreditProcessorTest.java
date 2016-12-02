package ru.sbertech.credit.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.sbertech.credit.api.BankingSystem;
import ru.sbertech.credit.api.CityPersonRegistry;
import ru.sbertech.credit.api.MessageSystem;
import ru.sbertech.credit.domain.Person;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by anton on 12/2/16.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:credit-spring.xml"})
public class CreditProcessorTest
{
    private static final Logger log = LoggerFactory.getLogger(CreditProcessorTest.class);

    @Autowired
    private CreditProcessor creditProcessor;

    @Test
    public void processPerson1() throws Exception {
        creditProcessor.processPerson(new Person());
    }

    @Test
    public void processPerson2() throws Exception {
        CityPersonRegistry c = mock(CityPersonRegistry.class);
        when(c.checkPerson(any(Person.class))).thenReturn(false);
        BankingSystem b = mock(BankingSystem.class);
        MessageSystem m = mock(MessageSystem.class);

        creditProcessor.setCityPersonRegistry(c);
        creditProcessor.setBankingSystem(b);
        creditProcessor.setMessageSystem(m);

        creditProcessor.processPerson(new Person());

        verify(c, times(1)).checkPerson(any(Person.class));
        verify(b, never()).checkLoan(any(Person.class));
        verify(m, only()).sendDeny(any(Person.class));
    }

}