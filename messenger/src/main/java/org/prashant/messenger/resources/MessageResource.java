package org.prashant.messenger.resources;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.prashant.messenger.model.Message;
import org.prashant.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms = new MessageService();
	
	@GET
	public ArrayList<Message> getAllMessages()
	{
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
	public Message addMessage(Message message)
	{
		return ms.addMessage(message);
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
}
