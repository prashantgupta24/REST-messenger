package org.prashant.messenger.resources;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.prashant.messenger.model.Profile;
import org.prashant.messenger.service.ProfileService;

@Path("/profiles")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService ps = new ProfileService();

	@GET
	public ArrayList<Profile> getAllProfiles()
	{
		return ps.getAllprofiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName)
	{
		return ps.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile)
	{
		return ps.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile editPRofile(@PathParam("profileName") String profileName, Profile profile)
	{
		profile.setProfileName(profileName);
		return ps.editProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName)
	{
		ps.deleteProfile(profileName);
	}
}
