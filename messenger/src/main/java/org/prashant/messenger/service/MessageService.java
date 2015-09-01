package org.prashant.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.prashant.messenger.database.MyDatabase;
import org.prashant.messenger.model.Message;

public class MessageService {
	
	private HashMap<Integer, Message> messages = MyDatabase.getMessages();
	
	public MessageService()
	{
		messages.put(1, new Message(1,"First message", "Prashant"));
		messages.put(2, new Message(2,"Second message", "Testing"));
	}

	public ArrayList<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
	}
	public ArrayList<Message> getAllMessages(String authorName)
	{
		ArrayList<Message> finalList = new ArrayList<Message>();
		ArrayList<Message> al = new ArrayList<Message>(messages.values());
		for(Message m : al)
		{
			if(m.getAuthor().equals(authorName))
				finalList.add(m);
				
		}
		return finalList;
	}
	public Message getMessage(int id)
	{
		return messages.get(id);
	}
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		//Message m = new Message(messages.size()+1, message.getMessage());
		messages.put(messages.size()+1, message);
		return message;
	}
	
	public int getMessageCount()
	{
		return messages.size();
	}
	
	public Message editMessage(Message message)
	{
		messages.put(message.getId(), message);
		return message;
	}
	
	public void deleteMessage(int messageId)
	{
		messages.remove(messageId);
	}
}
