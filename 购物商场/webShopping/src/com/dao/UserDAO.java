package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.po.Userinfo;

public class UserDAO {
	//连接数据库获取登录用户的信息
		public List<Userinfo> getData(String sql){
			 List<Userinfo> list=new ArrayList<Userinfo>();
			try { 
				   SessionFactory sf = new Configuration().configure().buildSessionFactory();
				   Session session1 = sf.openSession(); 
				   list=session1.createQuery(sql).list();    
				  } catch (HibernateException e) { 
				   e.printStackTrace(); 
				  }	
			return list;
		}
		
		//注册用户
		public boolean saveUser(Userinfo userinfo){
			boolean isSuccess=false;//不成功
			
			try { 
				   SessionFactory sf = new Configuration().configure().buildSessionFactory();
				   Session session1 = sf.openSession(); 
				   Transaction tx = session1.beginTransaction();
				   session1.save(userinfo);
				   tx.commit();
				   isSuccess=true;
				   session1.clear();
				   session1.close();
				   
				  } catch (HibernateException e) { 
				   e.printStackTrace(); 
				  }
			return isSuccess;
		}
}
