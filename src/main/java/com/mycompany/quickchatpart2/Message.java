/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchatpart2;

public final class Message {
    private String messageID;
    private int numMessagesSent;
    private String recipientCell;
    private String messageText;
    private String messageHash;

    public Message() {}
    public Message(String messageID, int numMessagesSent, String recipientCell, String messageText) {
        this.messageID = messageID;
        this.numMessagesSent = numMessagesSent;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    public boolean checkMessageID(String id) {
        return id != null && id.length() <= 10;
    }

    public boolean checkRecipientCell(String cell) {
        if (cell == null || cell.length() > 10) {
            return false;
        }
        return cell.startsWith("+") || cell.startsWith("00");
    }

    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2 || messageText == null || messageText.trim().isEmpty()) {
            return "";
        }
        
        String firstTwoId = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String combinedWords = (firstWord + lastWord).toUpperCase();

        return firstTwoId + ":" + numMessagesSent + ":" + combinedWords;
    }
public String sentMessage(int choice) {
        return switch (choice) {
            case 1 -> "Message successfully sent.";
            case 2 -> "Press 0 to delete the message.";
            case 3 -> storeMessage();
            default -> "Invalid selection.";
        };
    }

    public String storeMessage() {
        return "Message successfully stored.";
    }
    public String printMessages() {
        return "Message ID: " + messageID + 
               "\nMessage Hash: " + messageHash + 
               "\nRecipient: " + recipientCell + 
               "\nMessage: " + messageText;
    }

    public int returnTotalMessagess() {
        return numMessagesSent;
    }
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
}