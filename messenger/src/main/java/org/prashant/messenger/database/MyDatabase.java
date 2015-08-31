package org.prashant.messenger.database;

import java.util.*;

import org.prashant.messenger.model.Message;

public class MyDatabase {

	private static HashMap<Integer, Message> messages = new HashMap<Integer, Message>();
	
	public static HashMap<Integer, Message> getMessages() {
		return messages;
	}
	
}
