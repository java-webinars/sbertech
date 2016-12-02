package ru.sbertech.credit.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.sbertech.credit.api.MessageRegister;
import ru.sbertech.credit.domain.Person;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by anton on 12/2/16.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/credit-spring.xml"})
public class CreditProcessorTest
{
    private static final Logger log = LoggerFactory.getLogger(CreditProcessorTest.class);

    @Autowired
    private CreditProcessor creditProcessor;

    //@Test
    public void processPerson1() throws Exception {
        creditProcessor.processPerson(new Person());
    }

    @Test
    public void processPerson2() throws Exception {
        MessageRegister m = mock(MessageRegister.class);
        when(m.savePerson(any(Person.class))).then(new Answer<Long>() {
            public Long answer(InvocationOnMock invocationOnMock) throws Throwable {
                log.info("Fake Message save");
                return 99L;
            }
        });
        creditProcessor.setMessageRegister(m);
        creditProcessor.processPerson(new Person());

        verify(m, times(1)).savePerson(any(Person.class));
    }

}