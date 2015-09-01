package org.prashant.messenger.resources;

import javax.ws.rs.*;

@Path("/")
public class CommentResource {

	@GET
	public String test()
	{
		return "You've reached the comments section!";
	}
}
