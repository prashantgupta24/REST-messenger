package org.prashant.messenger.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private int id;
	private String message;
	private String author;
	private ArrayList<Link> links = new ArrayList<Link>();
	
	public Message()
	{
		
	}
	
	public Message(int id, String message, String author)
	{
		this.id = id;
		this.message = message;
		this.author = author;
	}
			
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public ArrayList<Link> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}


}
