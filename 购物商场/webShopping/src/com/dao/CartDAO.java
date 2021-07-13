package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.po.Cart;



public class CartDAO {
	
	//查询购物车
	public List<Cart> getData(String sql){
		 List<Cart> list=new ArrayList<Cart>();
		try { 
			   SessionFactory sf = new Configuration().configure().buildSessionFactory();
			   Session session1 = sf.openSession(); 
			   list=session1.createQuery(sql).list();    
			  } catch (HibernateException e) { 
			   e.printStackTrace(); 
			  }	
		return list;
	}
	
	//添加至购物车
	public boolean saveCart(Cart cart){
		boolean isSuccess=false;//不成功
		
		try { 
			   SessionFactory sf = new Configuration().configure().buildSessionFactory();
			   Session session1 = sf.openSession(); 
			   Transaction tx = session1.beginTransaction();
			   session1.saveOrUpdate(cart);
			   tx.commit();
			   isSuccess=true;
			   session1.clear();
			   session1.close();
			   
			  } catch (HibernateException e) { 
			   e.printStackTrace(); 
			  }
		return isSuccess;
	}
	//删除购物车中商品
	public boolean deleteCart(String sql){
		boolean isSuccess=false;//不成功
		try { 
			   SessionFactory sf = new Configuration().configure().buildSessionFactory();
			   Session session1 = sf.openSession(); 
			   Transaction tx = session1.beginTransaction();
			   Query query = session1.createQuery(sql);
			   query.executeUpdate();
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
