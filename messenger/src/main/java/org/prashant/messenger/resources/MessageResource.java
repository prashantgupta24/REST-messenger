package org.prashant.messenger.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.prashant.messenger.model.ErrorMessage;
import org.prashant.messenger.model.Link;
import org.prashant.messenger.model.Message;
import org.prashant.messenger.service.MessageService;

@Path("/messages")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
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
	public Message getMessage(@PathParam("messageID") int messageID, @Context UriInfo uriInfo)
 {
		Message message = ms.getMessage(messageID);
		if (message != null) {
			message.getLinks().add(new Link(uriInfo.getAbsolutePath().toString(), "self"));
			message.getLinks().add(new Link(
					uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor()).toString(),
					"profile"));
			message.getLinks()
					.add(new Link(uriInfo.getBaseUriBuilder().path(MessageResource.class)
							.path(MessageResource.class, "getCommentResource")
							.resolveTemplate("messageId", message.getId()).toString(), "comments"));
			return message;
		} else {
			// throw new
			// WebApplicationException(Response.status(Status.NOT_FOUND).entity(new
			// ErrorMessage("No message found!", "Prashant Gupta")).build());
			throw new NotFoundException(Response.status(Status.NOT_FOUND)
					.entity(new ErrorMessage("No message found!", "Prashant Gupta")).build());
		}
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
