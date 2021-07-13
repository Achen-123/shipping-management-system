package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.po.PageBean;
import com.po.Product;

public class ProductDAO {
	public List<Product> getProduct(String sql){
		List<Product> list = new ArrayList<Product>();
		
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			list = session.createQuery(sql).list();
		} catch (HibernateException e) {
			System.err.print(e);
		}
		
		return list;
	}
	public PageBean<Product> findByPage(Integer page,Integer count) {
	     PageBean<Product> pageBean=new PageBean<Product>();
	     //���õ�ǰҳ����
	     pageBean.setPage(page);
	     //����ÿҳ��ʾ��¼��
	      int limit=10;
	      pageBean.setLimit(limit);
	      //�����ܼ�¼����
	      pageBean.setTotalCount(count);
	      //������ҳ��
	      int totalPage=0;
	      if(count % limit==0){
		   totalPage=count/limit;
	      }else{
		    totalPage=count/limit+1;
	      }
	       pageBean.setTotalPage(totalPage);
	       //������ʾ��ҳ������ݵļ���
	       int begin=(page-1)*limit;
	       String sql = "select new Product(id,name,price,img,sale) from Product limit "+begin+","+limit;
	       List<Product> list=this.getProduct(sql);
	   		if(list!=null && list.size()>0){
	   			 pageBean.setList(list);
	   			 return pageBean;
	   		}
	   		return null;   
	}
}
