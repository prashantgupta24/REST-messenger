package org.prashant.messenger.database;

import java.util.HashMap;

import org.prashant.messenger.model.Message;
import org.prashant.messenger.model.Profile;

public class MyDatabase {

	private static HashMap<Integer, Message> messages = new HashMap<Integer, Message>();
	private static HashMap<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static HashMap<String, Profile> getProfiles() {
		return profiles;
	}

	public static HashMap<Integer, Message> getMessages() {
		return messages;
	}
	
}
