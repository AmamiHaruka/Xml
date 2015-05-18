package action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.xml.sax.SAXException;

import Dao.XmlDao;

import com.opensymphony.xwork2.ActionSupport;

public class RootAction extends ActionSupport implements RequestAware{
	Map<String,Object> request;
	String topicID;
	String themeID;
	public String delete() throws SAXException, IOException, Exception{
		XmlDao xml=new XmlDao();
		ServletRequest req=ServletActionContext.getRequest();
		xml.Deletetopic(themeID, topicID);
		
		return "delete";
	}
	public String excellent() throws SAXException, IOException, Exception{
		XmlDao xml=new XmlDao();
		xml.Settopic(themeID, topicID, "1", "excellent");
		return SUCCESS;
	}
	public String deExcellent() throws SAXException, IOException, Exception{
		XmlDao xml=new XmlDao();
		xml.Settopic(themeID, topicID, "0", "excellent");
		return SUCCESS;
	}
	public String top() throws SAXException, IOException, Exception{
		XmlDao xml=new XmlDao();
		xml.Settopic(themeID, topicID, "1", "top");
		
		return SUCCESS;
	}
	public String detop() throws SAXException, IOException, Exception{
		XmlDao xml=new XmlDao();
		ServletRequest req=ServletActionContext.getRequest();
		System.out.println(req.getParameter("themeID")+" "+topicID);
		xml.Settopic(themeID, topicID, "0", "top");
		
		return SUCCESS;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
	public String getTopicID() {
		return topicID;
	}
	public void setTopicID(String topicID) {
		this.topicID = topicID;
	}
	public String getThemeID() {
		return themeID;
	}
	public void setThemeID(String themeID) {
		this.themeID = themeID;
	}
	
}
