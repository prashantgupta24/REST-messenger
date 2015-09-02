package org.prashant.messenger.model;

public class Link {

	private String uri;
	private String rel;
	
	public Link()
	{
		
	}
	
	public Link(String uri, String rel)
	{
		this.uri = uri;
		this.rel = rel;
	}
			
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
}
