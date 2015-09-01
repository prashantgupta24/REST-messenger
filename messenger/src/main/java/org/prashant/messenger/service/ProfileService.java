package org.prashant.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.prashant.messenger.database.MyDatabase;
import org.prashant.messenger.model.Profile;

public class ProfileService {

	private HashMap<String, Profile> profiles = MyDatabase.getProfiles();
	
	public ProfileService()
	{
		profiles.put("Prashant", new Profile(1,"Prashant", "Prashant", "Gupta"));
		profiles.put("Test", new Profile(2,"Test", "Te", "st"));
	}

	public ArrayList<Profile> getAllprofiles()
	{
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public int getMessageCount()
	{
		return profiles.size();
	}
	
	public Profile editProfile(Profile profile)
	{
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public void deleteProfile(String profileName)
	{
		profiles.remove(profileName);
	}
}
