import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

import Dao.XmlDao;
import bean.Users;


public class Test {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		// TODO Auto-generated method stub
		Users user = new Users("lili", "111111", "123@qq.com", "female", "user", "2015-5-6");
		XmlDao dao = new XmlDao();
		dao.CreateUser(user);
	}

}
