package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.xml.sax.SAXException;

import Dao.SuperDAO;
import Dao.XmlDao;
import Dao.XmlDaoReply;
import bean.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReplyAction extends ActionSupport implements SessionAware{
	String topicID;
	String themeID;
	String content;
	Topic Topic;
	Map<String,Object> session;
	public String toReply(){
		
		return "toReply";
	}
	public String showReplys() throws SAXException, IOException, Exception{
		XmlDaoReply d=new XmlDaoReply();
		SuperDAO xmlS=new SuperDAO();
		XmlDao xml=new XmlDao();
		ServletResponse response=ServletActionContext.getResponse();
		
		ServletRequest request=ServletActionContext.getRequest();
		Topic topic=xml.GetTopic(themeID, topicID);
		List<Reply> replys=d.search(topicID);
		
		request.setAttribute("replys", replys);
		
		request.setAttribute("topic", topic);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		return SUCCESS;
	}
	public String reply(){
		XmlDaoReply replyD=new XmlDaoReply();
		XmlDao xml=new XmlDao();

		String rname=(String) ActionContext.getContext().getSession().get("username");
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df2=new SimpleDateFormat("yyyyMMddHHmmss");
		String date2=df2.format(new Date());
		
		Reply reply=new Reply(rname, df.format(new Date()), content, topicID);
		replyD.Writein(reply);
		xml.Addreplynum(themeID, topicID);
		return SUCCESS;
	}
	public String getTopicID() {
		return topicID;
	}
	public void setTopicID(String topicID) {
		this.topicID = topicID;
	}
	public Topic getTopic() {
		return Topic;
	}
	public void setTopic(Topic topic) {
		Topic = topic;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
		this.session=arg0;
	}
	public String getThemeID() {
		return themeID;
	}
	public void setThemeID(String themeID) {
		this.themeID = themeID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
