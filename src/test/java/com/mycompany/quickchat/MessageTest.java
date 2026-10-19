/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;

import com.mycompany.quickchatpart2.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testCheckRecipientCellSuccess() {
        Message msg = new Message();
        assertTrue(msg.checkRecipientCell("+278312345"));
    }

    @Test
    public void testCheckRecipientCellFailure() {
        Message msg = new Message();
        assertFalse(msg.checkRecipientCell("083123456789"));
    }

    @Test
    public void testCreateMessageHash() {
        // Test Case 1 specification
        Message msg = new Message("0012345678", 0, "+278312345", "HI THANKS");
        assertEquals("00:0:HITHANKS", msg.createMessageHash());
    }

    @Test
    public void testSentMessageOptions() {
        Message msg = new Message("0012345678", 1, "+278312345", "Hello World");
        
        assertEquals("Message successfully sent.", msg.sentMessage(1));
        assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
        assertEquals("Message successfully stored.", msg.sentMessage(3));
    }
}