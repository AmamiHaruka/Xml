package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.ws.Response;

import net.sf.saxon.functions.Data;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import Dao.XmlDao;
import bean.Users;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport implements SessionAware{
	String username;
	String password;
	String repassword;
	String email;
	String sex;
	Map<String,Object> session;
	
	public String register() throws TransformerFactoryConfigurationError, Exception{
		XmlDao xml=new XmlDao();
		Users user=new Users();
		user.setAccount(username);
		user.setPw(password);
		user.setEmail(email);
		user.setSex(sex);
		user.setRoleID("common");
		user.setUserLevel("F");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setRegisterTime(df.format(new Date()));
		xml.CreateUser(user);
		session.put("username", username);
		//System.out.println(user.toString());
		
		return "register";
		
	}
	public String toRegister(){
		return "toRegister";
		
	}
	public String login() throws IOException{
		ActionContext actionContext=ActionContext.getContext();
		Map<String, Object> session=actionContext.getSession();
		//System.out.println("username:"+username);
		session.put("username", username);
		
		return "login";

	}
	
	/*
	 * 游客登陆
	 */
	public String sightseer(){
		return "sightseer";
	}
	
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
		
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
