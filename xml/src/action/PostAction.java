package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.xml.sax.SAXException;

import bean.*;
import Dao.XmlDao;

import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport  implements SessionAware{
	String title;
	String theme;
	String content;
	Map<String,Object> session;
	String themeID;
	public String verifyTitle(){
		verify(title);
		return null;
		
	}
	public String verifyContent(){
		verify(content);
		return null;
	}
	private int verify(String vm){
		ServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			if(session.get("username")==null){
				out.print(1);
				return 0;
			}else if(vm.equals("")){
				out.print(0);
				return 0;
			}
			else{
				out.print(2);
				return 0;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public String post() throws SAXException, IOException, Exception{
		XmlDao xml=new XmlDao();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat df2=new SimpleDateFormat("yyyyMMddHHmmSS");
		String time=df.format(new Date());
		Topic topic=new Topic();
		topic.setAuthor((String)session.get("username"));
		topic.setContent(content);
		topic.setExcellent("0");
		topic.setId(df2.format(new Date())+Math.abs(new Random().nextInt())%1000);
		topic.setPostTime(time);
		topic.setReplynum("0");
		topic.setTitle(title);
		topic.setTop("0");
		xml.Publishtopic(topic, themeID);
		return "post";
	}
	public String toPost(){
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getThemeID() {
		return themeID;
	}
	public void setThemeID(String themeID) {
		this.themeID = themeID;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
}
