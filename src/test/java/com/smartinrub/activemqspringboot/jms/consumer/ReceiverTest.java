package com.smartinrub.activemqspringboot.jms.consumer;

import com.smartinrub.activemqspringboot.jms.producer.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class ReceiverTest {

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @Test
    public void testReceive() throws InterruptedException {
        sender.send("order-queue", "Hello Boot!");

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertEquals(0, receiver.getLatch().getCount());
    }
}
