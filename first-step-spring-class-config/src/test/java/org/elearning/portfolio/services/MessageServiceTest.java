package org.elearning.portfolio.services;

import java.util.List;
import java.util.ArrayList;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.elearning.portfolio.message.Message;
import org.elearning.portfolio.message.MessageDAO;




@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest{

    @Mock
    private MessageDAO messageDao;


    @InjectMocks
    @Autowired
    MessageService messageSer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void shouldReturnListMessages() {

//        perpetrate data to test
        Message message1 = new Message();
        Message message2 = new Message();
        message1.setTitle("Title");
        message2.setTitle("Title");
        List<Message> messages = new ArrayList<Message>();
        messages.add(message1);
        messages.add(message2);


        System.out.println("Verifying ProductDao(product, ) is called");
        when(messageDao.getMessages()).thenReturn(messages);

        assertEquals(messages,messageSer.getMessagesWithStringInTitle("Title"));
    }
}