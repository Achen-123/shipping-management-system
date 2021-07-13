package com.action;

import java.util.List;

import com.dao.ProductDAO;
import com.po.PageBean;
import com.po.Product;
import com.opensymphony.xwork2.ActionContext;

public class ProductAction {
	private String id;
	private Integer sort;
	private Integer page;

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	ProductDAO productDAO = new ProductDAO();
	
	//��ѯ��Ʒ��Ϣ
	public String showProduct() {
		
		//�������ݿ⣬��ȡ��Ʒ��Ϣ
//		String sql = "select id,name,price,img,sale from product";
		String sql = "select new Product(id,name,price,img,sale) from Product";
//		DataProcess data = new DataProcess();
//		Vector vector = data.getData(sql);//��¼����
//		
//		//��ϵ�����ݿ�ת��Ϊ��������
//		ArrayList<Product> listProduct = new ArrayList<>();//��Ʒ���󼯺�
//		//һ����¼ת��Ϊһ������
//		for(int i=0;i<vector.size();i++) {
//			Vector rowData = (Vector)vector.get(i);//��ȡһ����¼
//			Product product = new Product(); //��Ʒ����
//			product.setId(Integer.parseInt((String)rowData.get(0)));//��¼�е��ֶ����ݸ�ֵ�����������
//			product.setName((String)rowData.get(1));
//			product.setPrice(Float.parseFloat(((String)rowData.get(2))));
//			product.setImg((String)rowData.get(3));
//			product.setSale(Integer.parseInt((String)rowData.get(4)));
//			
//			listProduct.add(product);
//		}
		

		List<Product> listProduct = productDAO.getProduct(sql);
		ActionContext.getContext().put("listProduct", listProduct);
//		//����Service��ɲ�ѯ����
//	    PageBean<Product> pageBean =productDAO.findByPage(page,listProduct.size());
//	    //�����ݴ��ݵ�ҳ����
//	    ActionContext.getContext().getValueStack().set("pageBean", pageBean);

		return "showProductSuccess";
	}
	
	//��ʾ��Ʒ��ϸ��Ϣ
	public String showProductDetail() {
		//�������ݿ⣬��ȡ��Ʒ��Ϣ
		String sql = "select new Product(id,name,sort,price,oneprice,img,sale,face,body,length,quantity) from Product where id="+this.id; 
//			DataProcess data = new DataProcess();
//			Vector vector = data.getData(sql);//��¼����
//			
		//��ϵ�����ݿ�ת��Ϊ��������

		//һ����¼ת��Ϊһ������
//			Vector rowData = (Vector)vector.get(0);//��ȡһ����¼			
//			Product product = new Product();//��Ʒ����
//			product.setId(Integer.parseInt((String)rowData.get(0)));//��¼�е��ֶ����ݸ�ֵ�����������
//			product.setName((String)rowData.get(1));
//			product.setOneprice(Float.parseFloat((String)rowData.get(2)));
//			product.setPrice(Float.parseFloat(((String)rowData.get(3))));
//			product.setSale(Integer.parseInt((String)rowData.get(4)));
//			product.setSort(Integer.parseInt((String)rowData.get(5)));
//			product.setFace((String)rowData.get(6));
//			product.setBody((String)rowData.get(7));
//			product.setQuantity((Integer.parseInt((String)rowData.get(8))));
//			product.setLength(Float.parseFloat(((String)rowData.get(9))));
//			product.setImg((String)rowData.get(10));
						
		List<Product> listProduct = productDAO.getProduct(sql);
		ActionContext.getContext().put("product", listProduct.get(0));
		return "showProductDetailSuccess";
	}
	
	//������Ʒ��Ϣ
	public String showProductBySort() {
		String sql = "select new Product(id,name,price,img,sale) from Product where sort="+this.sort;
		List<Product> listProduct = productDAO.getProduct(sql);
		ActionContext.getContext().put("listProduct", listProduct);
		return "showProductSuccess";
	}
}
