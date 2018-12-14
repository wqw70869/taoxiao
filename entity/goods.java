package entity;

import java.util.Date;

public class goods {
	private String goodname;
	private int goodid;
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	
}

class givegoods extends goods
{
	
	String description;
	
	public void Setrdescription(String description)
	{
		this.description=description;
		
	}
	
	public String getdescription()
	{
		return this.description;
		
	}
}
 class rentgoods extends goods
{
	
	String description;
	
	public void Setrdescription(String description)
	{
		this.description=description;
		
	}
	
	public String getdescription()
	{
		return this.description;
		
	}
}


