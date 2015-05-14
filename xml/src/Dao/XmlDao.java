package Dao;

import java.io.*;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import bean.Users;

public class XmlDao {
	String url="C://Users//UltrA//Workspaces//MyEclipse Professional 2014//Web//WebRoot//xml//Users.xml";
	public Document initload(String url) throws SAXException, IOException, Exception{
		Document document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(url);
        document.normalize();
        return document;
	}
	public void CreateUser(Users Auser) throws TransformerFactoryConfigurationError, Exception{
		Element users = null;
		Element user = null;
		Element account = null;
		Element pw = null;
		Element email = null;
		Element sex = null;
		Element roleID = null;
		Element registerTime =null;
		Element userLevel = null;
		Document doc = initload(url);
		NodeList nl = doc.getElementsByTagName("users");
		users =(Element)nl.item(0);
		user = doc.createElement("user");
		account = doc.createElement("account");
		account.appendChild(doc.createTextNode(Auser.getAccount()));
		user.appendChild(account);
		pw = doc.createElement("pw");
		pw.appendChild(doc.createTextNode(Auser.getPw()));
		user.appendChild(pw);
		email = doc.createElement("email");
		email.appendChild(doc.createTextNode(Auser.getEmail()));
		user.appendChild(email);
		sex = doc.createElement("sex");
		sex.appendChild(doc.createTextNode(Auser.getSex()));
		user.appendChild(sex);
		userLevel = doc.createElement("userlevel");
		userLevel.appendChild(doc.createTextNode(Auser.getUserLevel()));
		user.appendChild(userLevel);
		roleID = doc.createElement("role_id");
		roleID.appendChild(doc.createTextNode(Auser.getRoleID()));
		user.appendChild(roleID);
		registerTime = doc.createElement("reg_id");
		registerTime.appendChild(doc.createTextNode(Auser.getRegisterTime()));
		user.appendChild(registerTime);
		users.appendChild(user);
		Transformer transformer =TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(new DOMSource(doc), new StreamResult(new File(url)));
		
		
	}
	public Users FindUser(String name) throws Exception{
		Users user = new Users();
		XQDataSource xq = new SaxonXQDataSource();
		XQConnection xqconnection = xq.getConnection();
		XQExpression xqexpression = xqconnection.createExpression();
		String str = "for $x in doc('"+url+"')/users/user "
				+ "where $x/account='"+ name+"'"+
				" return $x";
		XQResultSequence res = xqexpression.executeQuery(str);
		if(res.next()){
			user=Domxml(res.getItemAsString(null));
			return user;
		}
		  	return null;
		//System.out.println(res.getItemAsString(null));
		
	}
	private Users Domxml(String xmlstr) throws Exception {
		Users user = new Users();
		Element xuser = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new java.io.ByteArrayInputStream(xmlstr.getBytes()));
		NodeList nl = doc.getElementsByTagName("user");
		xuser =(Element)nl.item(0);
		user.setAccount(xuser.getElementsByTagName("account").item(0).getTextContent());
		user.setPw(xuser.getElementsByTagName("pw").item(0).getTextContent());
		user.setEmail(xuser.getElementsByTagName("email").item(0).getTextContent());
		user.setSex(xuser.getElementsByTagName("sex").item(0).getTextContent());
		user.setUserLevel(xuser.getElementsByTagName("userlevel").item(0).getTextContent());
		user.setRoleID(xuser.getElementsByTagName("role_id").item(0).getTextContent());
		user.setRegisterTime(xuser.getElementsByTagName("reg_id").item(0).getTextContent());
		return user;
		
	}
	public boolean ChangeUser(Users Auser) throws Exception{
		try{
			String name=Auser.getAccount();
			
			Document doc = initload(url);
			NodeList nl = doc.getElementsByTagName("user");
			for(int i =0;i<nl.getLength();i++){
				String username = doc.getElementsByTagName("account").item(i).getFirstChild().getNodeValue();
				if(username.equals(name)){
					doc.getElementsByTagName("pw").item(i).getFirstChild().setNodeValue(Auser.getPw());
					doc.getElementsByTagName("email").item(i).getFirstChild().setNodeValue(Auser.getEmail());
					doc.getElementsByTagName("sex").item(i).getFirstChild().setNodeValue(Auser.getSex());
					Transformer transformer =TransformerFactory.newInstance().newTransformer();
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.transform(new DOMSource(doc), new StreamResult(new File(url)));
				}
					
			}
			return true;
		}catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
		
	}
}
