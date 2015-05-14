package action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import Dao.XmlDao;
import bean.Users;

import com.opensymphony.xwork2.ActionSupport;

public class ModifyAction extends ActionSupport implements SessionAware{
	String username;
	String email;
	String sex;
	String photoPath;
	File photo;
	Map session;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
		
	}
	public String toModify() throws Exception{
		ServletRequest request=ServletActionContext.getRequest();
		String name=(String) session.get("username");
		XmlDao xml=new XmlDao();
		Users user=xml.FindUser(name);
		request.setAttribute("email", user.getEmail());
		request.setAttribute("sex", user.getSex());
		return "toModify";
	}
	public String toModifyPassword(){
		return "toModifyPassword";
	}
	
	public String upload(){
		String path=ServletActionContext.getServletContext().getRealPath("C:\\Study\\"+this.photoPath);
		return null;
	}
	public void copy(File source,File target){
		InputStream inputStream=null;
		OutputStream outputStream=null;
		try {
			inputStream=new BufferedInputStream(new FileInputStream(source),40*40);
			outputStream=new BufferedOutputStream(new FileOutputStream(target),40*40);
			byte[] buffer=new byte[40*40];
			int length=0;
			while((length=inputStream.read(buffer))>0){
				outputStream.write(buffer,0,length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=inputStream){
				try{
					inputStream.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
			if(null!=outputStream){
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
}
