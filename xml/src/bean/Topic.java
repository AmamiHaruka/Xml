package bean;
public class Topic {
	public Topic(){
		
	}
	public Topic(String id,String exc,String top,String title, String postT,String author,String num,String content){
		this.author=author;
		this.content = content;
		this.excellent = exc;
		this.id = id;
		this.title = title;
		this.replynum = num;
		this.top = top;
		this.postTime=postT;
	}
	private String id;
	private String excellent;
	private String top;
	private String title;
	private String postTime;
	private String author;
	private String replynum;
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExcellent() {
		return excellent;
	}
	public void setExcellent(String excellent) {
		this.excellent = excellent;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReplynum() {
		return replynum;
	}
	public void setReplynum(String replynum) {
		this.replynum = replynum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String toString(){
		return author+" "+title+" "+postTime+" "+id;
	}
}