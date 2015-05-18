package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import Dao.XmlDao;
import bean.Users;

import com.opensymphony.xwork2.ActionSupport;

public class PasswordModifyAction extends ActionSupport implements SessionAware{
	String password;
	String passwordpre;
	String repassword;
	Map<String,Object> session;
	
	/*
	 * 进行密码的修改
	 */
	public String modifyPassword() throws Exception{
		XmlDao xml=new XmlDao();
		Users user=xml.FindUser((String)session.get("username"));
		System.out.println(password);
		user.setPw(password);
		xml.ChangeUser(user);
		return "passwordSuccess";
		
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordpre() {
		return passwordpre;
	}
	public void setPasswordpre(String passwordpre) {
		this.passwordpre = passwordpre;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}
	
}
