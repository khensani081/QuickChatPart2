/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchatpart2;

import java.util.Scanner;
import java.util.Random;

public class QuickChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Welcome to QuickChat.");

        boolean running = true;
        int totalMessagesAccumulated = 0;

        while (running) {
            System.out.println("\n================================");
            System.out.println("       QUICKCHAT MAIN MENU      ");
            System.out.println("================================");
            System.out.println("Option 1) Send Messages");
            System.out.println("Option 2) Show recently sent messages");
            System.out.println("Option 3) Quit");
            System.out.print("Choose an option (1-3): ");

            int choice = scan.nextInt();
            scan.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("\nHow many messages do you wish to enter? ");
                    int messageCount = scan.nextInt();
                    scan.nextLine();

                    for (int i = 0; i < messageCount; i++) {
                        System.out.println("\n--- Entering Message " + (i + 1) + " of " + messageCount + " ---");

                        Random random = new Random();
                        String messageID = String.format("%010d", Math.abs(random.nextLong() % 10000000000L));

                        Message validator = new Message();

                        String recipient;
                        while (true) {
                            System.out.print("Enter recipient cell number (max 10 chars with international code like +...): ");
                            recipient = scan.nextLine();
                            if (validator.checkRecipientCell(recipient)) {
                                System.out.println("Cell phone number successfully captured.");
                                break;
                            } else {
                                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                            }
                        }

                        String messageText;
                        while (true) {
                            System.out.print("Enter your message (max 250 characters): ");
                            messageText = scan.nextLine();
                            if (messageText.length() <= 250) {
                                System.out.println("Message sent");
                                break;
                            } else {
                                System.out.println("Please enter a message of less than 250 characters.");
                            }
                        }

                        Message msg = new Message(messageID, totalMessagesAccumulated, recipient, messageText);

                        System.out.println("Message ID generated: " + msg.getMessageID());
                        System.out.println("Message Hash: " + msg.createMessageHash());

                        System.out.println("\nChoose an action:");
                        System.out.println("1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message");
                        System.out.print("Choice: ");
                        int actionChoice = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Status: " + msg.sentMessage(actionChoice));

                        System.out.println("\n--- Summary ---");
                        System.out.println(msg.printMessages());

                        totalMessagesAccumulated++;
                    }

                    System.out.println("\nTotal messages processed this session: " + totalMessagesAccumulated);
                }

                case 2 -> System.out.println("\nComing Soon.");

                case 3 -> {
                    System.out.println("\nExiting QuickChat. Goodbye!");
                    running = false;
                }

                default -> System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }
        scan.close();
    }
}