package org.prashant.messenger.model;

import java.util.*;

import org.prashant.messenger.database.MyDatabase;

public class MessageService {
	
	private HashMap<Integer, Message> messages = MyDatabase.getMessages();
	
	public MessageService()
	{
		messages.put(1, new Message(1,"adfasdfasgdf asdgfaskdgf jasgf ajsgfaskjdfgsadkjfg"));
	}

	public ArrayList<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
	}
	public Message getMessage(int id)
	{
		return messages.get(id);
	}
	public void addMessage(String message)
	{
		Message m = new Message(messages.size()+1, message);
		messages.put(messages.size()+1, m);
	}
}
