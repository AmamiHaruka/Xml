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
	 * 验证新密码
	 */
	public String pwdVerify(){
		ServletResponse response= ServletActionContext.getResponse();
		//System.out.println(password);
		try {
			PrintWriter out=response.getWriter();
			if(password.equals("")){
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
	/*
	 * 原密码验证
	 */
	public String passwordVerify(){
		ServletResponse response= ServletActionContext.getResponse();
		XmlDao xml=new XmlDao();
		
		try {
			PrintWriter out=response.getWriter();
			Users user=xml.FindUser((String)session.get("username"));
			
			if(user.getPw().equals(passwordpre)){
				out.print(2);
				return null;
			}else{
				out.print(1);
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
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
	/*
	 * 验证第二次输入新密码
	 */
	public String repasswordVerify(){
		ServletResponse response= ServletActionContext.getResponse();
		ServletRequest request=ServletActionContext.getRequest();
		//repassword=request.getParameter("repassword");
		//System.out.println(password+"  "+repassword);
		try {
			PrintWriter out=response.getWriter();
			if(repassword.equals("")){
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
