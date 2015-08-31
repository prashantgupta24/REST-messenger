package org.prashant.messenger;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.prashant.messenger.model.Message;
import org.prashant.messenger.model.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService ms = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Message> getAllMessage()
	{
		return ms.getAllMessages();
	}
	
	@GET
	@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageID") int messageID)
	{
		Message message = ms.getMessage(messageID);
		if(message !=null)
		{
			System.out.println("message got!"+message.getMessage());
			return message;
		}
		else
			return null;
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage()
	{
		return new String("Adf");
	}
}
