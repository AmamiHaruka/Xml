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

import Dao.XmlDao;
import bean.Users;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {
	String username;
	String password;
	String repassword;
	String email;
	String sex;
	
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
		System.out.println(user.toString());
		
		return "register";
		
	}
	public String toRegister(){
		return "toRegister";
		
	}
	public String login() throws IOException{
		ActionContext actionContext=ActionContext.getContext();
		Map<String, Object> session=actionContext.getSession();
		System.out.println("username:"+username);
		session.put("username", username);
		
		return "login";

	}
	public String loginVerify() throws Exception{
		ServletResponse response= ServletActionContext.getResponse();
		XmlDao xml=new XmlDao();
		try {
			PrintWriter out=response.getWriter();
			if(xml.FindUser(username)==null){
				out.print("nouser");
				return null;
			}
			else if(xml.FindUser(username).getPw().equals(password)){
				System.out.println(xml.FindUser(username).getPw());
				out.print("ok");
				return null;
			}else {
				out.print("error");
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public String sightseer(){
		return "sightseer";
	}
	public String nameVerify() throws Exception{
		ServletResponse response= ServletActionContext.getResponse();
		System.out.println(username);
		XmlDao xml=new XmlDao();
		try {
			PrintWriter out=response.getWriter();
			if(username==null){
				out.print(1);
				return null;
			}else if(xml.FindUser(username)!=null){
				out.print(0);
				return null;
			}else{
				out.print(2);
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public String repasswordVerify(){
		ServletResponse response= ServletActionContext.getResponse();
		ServletRequest request=ServletActionContext.getRequest();
		repassword=request.getParameter("repassword");
		System.out.println(password+"  "+repassword);
		try {
			PrintWriter out=response.getWriter();
			if(repassword.equals(null)){
				out.print(0);
				return null;
			}
			else if(password.equals(repassword)){
				out.print(2);
				return null;
			} else{
				out.print(3);
				return null;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String pwdVerify(){
		ServletResponse response= ServletActionContext.getResponse();
		System.out.println(password);
		try {
			PrintWriter out=response.getWriter();
			if(password.equals(null)){
				out.print(0);
			}else{
				out.print(2);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	
}
