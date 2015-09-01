package org.prashant.messenger.resources;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.prashant.messenger.model.Message;
import org.prashant.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms = new MessageService();
	
	@GET
	public ArrayList<Message> getAllMessages(@QueryParam("author") String authorName)
	{
		if(authorName!=null)
			return ms.getAllMessages(authorName);
		else
			return ms.getAllMessages();
	}
	
	@GET
	@Path("/{messageID}")
	public Message getMessage(@PathParam("messageID") int messageID)
	{
		Message message = ms.getMessage(messageID);
		if(message !=null)
		{
			return message;
		}
		else
			return null;
	}
	
	@GET
	@Path("/test")
	public String getMessage()
	{
		return new String("Adf");
	}
	
	
	@POST
	public Response addMessage(@Context UriInfo urinfo, Message message)
 {
		Message finalMessage = ms.addMessage(message);
		return Response.created(urinfo.getAbsolutePathBuilder().path(String.valueOf(finalMessage.getId())).build())
				.entity(finalMessage).build();

		// return ms.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")

	public Message editMessage(@PathParam("messageId") int messageId, Message message)
	{
		message.setId(messageId);
		return ms.editMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") int messageId)
	{
		ms.deleteMessage(messageId);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
}
