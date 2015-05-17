package Dao;

import java.io.PrintWriter;
import java.util.List;





import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

import bean.Users;
import net.sf.saxon.xqj.SaxonXQDataSource;

public class SuperDAO {
	 public String getReply(String topicID) throws XQException{
			
			XQDataSource ds=new SaxonXQDataSource();
			XQConnection conn=ds.getConnection();
			XQExpression expression=conn.createExpression();
			String query="for $x in doc('C:/Users/UltrA/Workspaces/MyEclipse Professional 2014/Web/WebRoot/xml/Message.xml')/replies/reply[id="+topicID+"] "
		//			+ "let $y :=concat($x/name,' Educator')"
		//			+ "where contains($x/emailaddress,'edu') "
		//			+ "return <person>{$x/(@*,node() except name)} <name>{$y}</name></person>";
			+"return $x";
					XQResultSequence res=expression.executeQuery(query);
					res.next();
			String s=res.getItemAsString(null);
		Object ob=res.getObject();
			System.out.println("sad");
			return null;
	 
	 
	 }
	
	 
	

}
