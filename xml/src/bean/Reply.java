package bean;

public class Reply {
	private String rname;
	private String date;
	private String content;
	private String id;
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Reply(String rname,String date,String content,String id)
	{
		this.rname=rname;
		this.date=date;
		this.content=content;
		this.id=id;
	}
	public Reply()
	{
		
		
	}
	 
}
