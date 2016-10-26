package org.elearning.portfolio.services;

import java.util.List;
import java.util.ArrayList;
import org.mockito.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


import org.elearning.portfolio.message.*;
import org.elearning.portfolio.services.MessageService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.*;



//@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest{




    @Test
    public void test() {

        Message message1 = new Message();
        Message message2 = new Message();
        message1.setTitle("");
        message2.setTitle("");
        List<Message> messages = new ArrayList<Message>();
        List<Message> listMessages = new ArrayList<Message>();
        messages.add(message1);
        messages.add(message2);

        List<Message> messagesCorrect = new ArrayList<Message>();
        messagesCorrect.add(message1);

        MessageService messageSer = mock(MessageService.class);
        MessageDAO messageDAO = mock(MessageDAO.class);



        when(messageDAO.getMessages()).thenReturn(messages);

        listMessages = messageSer.getMessagesWithStringInTitle("");
//        Message t= listMessages.get(0);
//        assertEquals(listMessages.get(0).getTitle(), messagesCorrect.get(0).getTitle());

    }
}