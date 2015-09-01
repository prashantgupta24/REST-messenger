package org.prashant.messenger.model;

import java.util.*;

import org.prashant.messenger.database.MyDatabase;

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
	
	public Message editMessage(int messageId, Message message)
	{
		message.setId(messageId);
		messages.put(messageId, message);
		return message;
	}
	
	public void deleteMessage(int messageId)
	{
		messages.remove(messageId);
	}
}
