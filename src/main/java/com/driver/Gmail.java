package com.driver;

import java.util.ArrayList;
import java.util.Date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class Gmail extends Email {


    int inboxCapacity; //maximum number of mails inbox can store
    LinkedHashMap<String,Mail> index;
    LinkedHashMap<String,Mail> trash;
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        index = new LinkedHashMap<>();
        trash = new LinkedHashMap<>();

    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(index.size()>=inboxCapacity)
        {

            String msg = findOldestMessage();
            deleteMail(msg);
        }
        index.put(message,new Mail(date,sender,message));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        if(index.containsKey(message))
        {
            trash.put(message,index.get(message));
            index.remove(message);
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        String st = "";
        for(String s : index.keySet())
        {

            st = s;

        }
        return st;


    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        String s = "";
//        Date d = new Date();
        for(String st : index.keySet())
        {
//            Mail mail = index.get(st);
//            if(mail.date.compareTo(d) <= 0)
//            {
//                s = st;
//            }
            return st;
        }
        return s;

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int i = 0;
        for(String st : index.keySet())
        {
            Mail mail = index.get(st);
            if(mail.date.compareTo(start) >= 0 && mail.date.compareTo(end) <= 0)
            {
                i++;
            }
        }
        return i;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return index.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }


    private static class Mail {
        Date date;
        String sender;
        String message;

        Mail(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }
    }
}