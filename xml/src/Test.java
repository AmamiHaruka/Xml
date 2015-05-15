import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xquery.XQException;

import org.xml.sax.SAXException;

import Dao.XmlDao;
import bean.Topic;
import bean.Users;


public class Test {

	public static void main(String[] args) throws TransformerFactoryConfigurationError, Exception {
		// TODO Auto-generated method stub
		List<Topic> list = new ArrayList<Topic>();
		Topic topic = new Topic("4","0","0","dps1","2000","dps","0", "111111111111");
		XmlDao dao = new XmlDao();
		dao.Addreplynum("2", "2");
		//dao.Publishtopic(topic, "2");
		//dao.Deletetopic("2", "2");
		//dao.Settopic("2", "2", "0","excellent");
		//list=dao.GetALLTopic("2", "0");
		//System.out.println(list);
	}

}
