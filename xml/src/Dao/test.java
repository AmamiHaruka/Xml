package Dao;

import java.util.Date;

import javax.xml.xquery.XQException;

import bean.Reply;

public class test {

	public static void main(String[] args) throws XQException {
		// TODO Auto-generated method stub
		SuperDAO xml=new SuperDAO();
		System.out.println(xml.getReply("20150517015913824"));
	
	}

}
