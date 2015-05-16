package Dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

import bean.Topic;
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
	public void Publishtopic(Topic Atopic,String Aid) throws SAXException, IOException, Exception{
		Element topics = null;
		Element topic = null;
		Element author = null;
		Element data = null;
		Element id = null;
		Element title = null;
		Element content = null;
		Element replynum = null;
		Element excellent = null;
		Element top = null;
		String Topicurl = "./Topic"+Aid+".xml";
		Document doc = initload(Topicurl);
		NodeList nl = doc.getElementsByTagName("topics");
		topics = (Element)nl.item(0);
		topic = doc.createElement("topic");
		id = doc.createElement("id");
		id.appendChild(doc.createTextNode(Atopic.getId()));
		topic.appendChild(id);
		title = doc.createElement("title");
		title.appendChild(doc.createTextNode(Atopic.getTitle()));
		topic.appendChild(title);
		author = doc.createElement("author");
		author.appendChild(doc.createTextNode(Atopic.getAuthor()));
		topic.appendChild(author);
		data = doc.createElement("data");
		data.appendChild(doc.createTextNode(Atopic.getPostTime()));
		topic.appendChild(data);
		content = doc.createElement("content");
		content.appendChild(doc.createTextNode(Atopic.getContent()));
		topic.appendChild(content);
		replynum = doc.createElement("replynum");
		replynum.appendChild(doc.createTextNode(Atopic.getReplynum()));
		topic.appendChild(replynum);
		excellent = doc.createElement("excellent");
		excellent.appendChild(doc.createTextNode(Atopic.getExcellent()));
		topic.appendChild(excellent);
		top = doc.createElement("top");
		top.appendChild(doc.createTextNode(Atopic.getTop()));
		topic.appendChild(top);
		topics.appendChild(topic);
		Transformer transformer =TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(new DOMSource(doc), new StreamResult(new File(Topicurl)));
		
	}
	//获得选择主题的不同种类的帖子 themeid  为主题 编号， tpye 为帖子种类编号 0 代表普通贴 1代表置顶贴
	public List<Topic> GetALLTopic(String themeid,String type) throws SAXException, IOException, Exception{
		String Topicurl = "./Topic"+themeid+".xml";
		Element xtopic = null;
		List<Topic> list=new ArrayList<Topic>();
		Document doc = initload(Topicurl);
		NodeList nl = doc.getElementsByTagName("topic");
		for(int i = 0 ;i<nl.getLength();i++){
			Topic topic = new Topic();
			xtopic = (Element)nl.item(i);
			if(xtopic.getElementsByTagName("top").item(0).getTextContent().equals(type)){
				topic.setId(xtopic.getElementsByTagName("id").item(0).getTextContent());
				topic.setTitle(xtopic.getElementsByTagName("title").item(0).getTextContent());
				topic.setAuthor(xtopic.getElementsByTagName("author").item(0).getTextContent());
				topic.setPostTime(xtopic.getElementsByTagName("data").item(0).getTextContent());
				topic.setContent(xtopic.getElementsByTagName("content").item(0).getTextContent());
				topic.setReplynum(xtopic.getElementsByTagName("replynum").item(0).getTextContent());
				topic.setExcellent(xtopic.getElementsByTagName("excellent").item(0).getTextContent());
				topic.setTop(xtopic.getElementsByTagName("top").item(0).getTextContent());
				list.add(topic);
			}
		}
		return list;
	}
	public boolean Settopic(String themeid,String topicID,String type,String operation) throws SAXException, IOException, Exception{
		try{
			String Topicurl = "./Topic"+themeid+".xml";
			Document doc = initload(Topicurl);
			NodeList nl = doc.getElementsByTagName("topic");
			for(int i = 0;i<nl.getLength();i++){
				if(doc.getElementsByTagName("id").item(i).getFirstChild().getNodeValue().equals(topicID)){
					doc.getElementsByTagName(operation).item(i).getFirstChild().setNodeValue(type);
					Transformer transformer =TransformerFactory.newInstance().newTransformer();
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.transform(new DOMSource(doc), new StreamResult(new File(Topicurl)));
					
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
		}
		
	}
	public boolean Deletetopic(String themeid ,String topicID) throws SAXException, IOException, Exception{
		try{
			String Topicurl = "./Topic"+themeid+".xml";
			Document doc = initload(Topicurl);
			NodeList nl = doc.getElementsByTagName("topic");
			for(int i = 0;i<nl.getLength();i++){
				if(doc.getElementsByTagName("id").item(i).getFirstChild().getNodeValue().equals(topicID)){
					Node delnode = nl.item(i);
					delnode.getParentNode().removeChild(delnode);
					Transformer transformer =TransformerFactory.newInstance().newTransformer();
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.transform(new DOMSource(doc), new StreamResult(new File(Topicurl)));
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
		}
	}
	public boolean Addreplynum(String themeid,String topicID){
		try{
			String Topicurl = "./Topic"+themeid+".xml";
			Document doc = initload(Topicurl);
			NodeList nl = doc.getElementsByTagName("topic");
			for(int i = 0;i<nl.getLength();i++){
				if(doc.getElementsByTagName("id").item(i).getFirstChild().getNodeValue().equals(topicID)){
					int count =Integer.parseInt(doc.getElementsByTagName("replynum").item(i).getFirstChild().getNodeValue());
					count++;
					doc.getElementsByTagName("replynum").item(i).getFirstChild().setNodeValue(count+"");
					Transformer transformer =TransformerFactory.newInstance().newTransformer();
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.transform(new DOMSource(doc), new StreamResult(new File(Topicurl)));
					
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

