package action;

import java.beans.XMLDecoder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import Dao.XmlDao;

import com.opensymphony.xwork2.ActionSupport;

public class VerifyAction extends ActionSupport implements SessionAware{
	String password;
	String passwordpre;
	String repassword;
	String email;
	String username;
	Map<String,Object> session;
	/*
	 * 验证邮箱空返回0
	 * 可用返回2
	 */
	public String emailVerify(){
		ServletResponse response= ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			if(email.trim().equals("")){
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
	/*
	 * 验证原始密码
	 * 空返回0
	 * 与原密码不一致返回1
	 * 正确返回2
	 */
	public String preVerify() throws Exception{
		ServletResponse response= ServletActionContext.getResponse();
		XmlDao xml=new XmlDao();
		String p=xml.FindUser((String)session.get("username")).getPw();
		
		try {
			PrintWriter out=response.getWriter();
			
			if(passwordpre.equals("")){
				
				out.print(0);
				
				return null;
			}else if(p.equals(passwordpre.trim())){
				System.out.println(2);
				out.print(2);
				
				return null;
			}
			else{
				System.out.println(1);
				out.print(1);
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/*
	 * 验证密码是否正确可用
	 */
	public String pwdVerify(){
		ServletResponse response= ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			
			if(password.trim().equals("")){
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
	/*
	 * 登陆的检验,没有这个用户返回 nouser
	 * 用户名密码不致返回ok
	 * 不一致返回error
	 */
	public String loginVerify() throws Exception{
		ServletResponse response= ServletActionContext.getResponse();
		XmlDao xml=new XmlDao();
		try {
			PrintWriter out=response.getWriter();
			if(xml.FindUser(username)==null){
				out.print("nouser");
				return null;
			}
			else if(xml.FindUser(username).getPw().equals(password.trim())){
				
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
	/*
	 * 在此输入密码验证repassword
	 * 为空返回0
	 * 两次不一致返回2
	 * 一致返回3
	 */
	public String repasswordVerify(){
		ServletResponse response= ServletActionContext.getResponse();
		ServletRequest request=ServletActionContext.getRequest();
		//repassword=request.getParameter("repassword");
		
		try {
			PrintWriter out=response.getWriter();
			if(repassword.trim().equals("")){
				out.print(0);
				return null;
			}
			else if(password.trim().equals(repassword)){
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
	/*
	 * 检验注册用户名是否合法
	 * 空返回1
	 * 用户名已存在返回0
	 * 可用返回2
	 */
	public String nameVerify() throws Exception{
		ServletResponse response= ServletActionContext.getResponse();
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
	

}
