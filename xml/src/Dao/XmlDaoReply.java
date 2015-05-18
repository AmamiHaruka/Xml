package Dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.print.Doc;
import javax.swing.Spring;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import bean.*;
public class XmlDaoReply {
  private String url="C://Users//UltrA//Workspaces//MyEclipse Professional 2014//Web//WebRoot//xml//Message.xml";
  
  
 public void  Writein(Reply r ){
	 Document document=load();
	 Element root=document.getRootElement();
	 Element reply=root.addElement("reply");
	 Element rname=reply.addElement("rname");
	 rname.setText(r.getRname());
	 Element date=reply.addElement("date");
	 date.setText(r.getDate());
	 Element content=reply.addElement("content");
	 content.setText(r.getContent());
	 Element id=reply.addElement("id");
	 id.setText(r.getId());
	 
	 try {
		 OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(new OutputStreamWriter(new FileOutputStream(url),"UTF-8"),format);
		
		xmlWriter.write(document);
		xmlWriter.close();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	 
 }
 
 private Document load()
 {
	 Document document=null;
	 
	 try {
		 SAXReader saxReader = new SAXReader();
		document =saxReader.read(new File(url));
		
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return document;
 }
 
 public ArrayList<Reply> search(String id) {
	 ArrayList<Reply> rlist =new ArrayList<Reply>();
	 Document document =load();
	 Element root=document.getRootElement();
	 
	 for(Iterator i =root.elementIterator();i.hasNext();)
	 {
		 Element el=(Element) i.next();
		 if(id.equals(el.elementTextTrim("id")))
		 {
			 	
			 	Reply r=new Reply();
			 	 r.setRname(el.elementText("rname"));
			 	 r.setDate(el.elementText("date"));
			 	 r.setContent(el.elementText("content"));
			 	 r.setId(el.elementText("id"));
			 	 rlist.add(r);
		 }
	 }
	 
	return rlist;
}

	
	 
 
}