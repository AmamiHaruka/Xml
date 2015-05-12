import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xquery.XQException;

import org.xml.sax.SAXException;

import Dao.XmlDao;
import bean.Users;


public class Test {

	public static void main(String[] args) throws TransformerFactoryConfigurationError, Exception {
		// TODO Auto-generated method stub
		Users user = new Users("dps", "123456", "123@qq.com", "female","A", "user", "2015-5-6");
		Users reuser = new Users();
		XmlDao dao = new XmlDao();
		//dao.CreateUser(user);
		dao.ChangeUser(user);
		reuser  =dao.FindUser("dps");
		System.out.println(reuser.getAccount());
		System.out.println(reuser.getEmail());
		System.out.println(reuser.getPw());
		System.out.println(reuser.getRegisterTime());
		System.out.println(reuser.getRoleID());
		System.out.println(reuser.getUserLevel());
		System.out.println(reuser.getSex());
		
	}

}
