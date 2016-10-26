package org.elearning.portfolio.services;

import java.util.List;
import java.util.ArrayList;
import org.mockito.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


import org.elearning.portfolio.message.Message;
import org.elearning.portfolio.message.MessageDAO;
import org.elearning.portfolio.services.MessageService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest{

    @Mock
    MessageDAO messageDao;

    @Mock
    MessageService messageSer; // przy tym nie dostaję pustą listę bez tego dostaję null exeption


    @Test
    public void test() {

        Message message1 = new Message();
        Message message2 = new Message();
        message1.setTitle("a");
        message2.setTitle("a");
        List<Message> messages = new ArrayList<Message>();

        messages.add(message1);
        messages.add(message2);
        List<Message> listMessages ;
        List<Message> messagesCorrect = new ArrayList<Message>();
        messagesCorrect.add(message1);

//        MessageService messageSer = new MessageService();




        when(messageDao.getMessages()).thenReturn(messages);

        listMessages = messageSer.getMessagesWithStringInTitle("a");
//        listMessages = messageDao.getMessages();
//        Message t= listMessages.get(0);
        assertEquals(messages,listMessages);

    }
}