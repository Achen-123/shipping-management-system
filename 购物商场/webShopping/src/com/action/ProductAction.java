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
	
	//查询商品信息
	public String showProduct() {
		
		//连接数据库，获取商品信息
//		String sql = "select id,name,price,img,sale from product";
		String sql = "select new Product(id,name,price,img,sale) from Product";
//		DataProcess data = new DataProcess();
//		Vector vector = data.getData(sql);//记录集合
//		
//		//关系型数据库转换为对象数据
//		ArrayList<Product> listProduct = new ArrayList<>();//商品对象集合
//		//一条记录转换为一个对象
//		for(int i=0;i<vector.size();i++) {
//			Vector rowData = (Vector)vector.get(i);//读取一条记录
//			Product product = new Product(); //商品对象
//			product.setId(Integer.parseInt((String)rowData.get(0)));//记录中的字段数据赋值给对象的属性
//			product.setName((String)rowData.get(1));
//			product.setPrice(Float.parseFloat(((String)rowData.get(2))));
//			product.setImg((String)rowData.get(3));
//			product.setSale(Integer.parseInt((String)rowData.get(4)));
//			
//			listProduct.add(product);
//		}
		

		List<Product> listProduct = productDAO.getProduct(sql);
		ActionContext.getContext().put("listProduct", listProduct);
//		//调用Service完成查询操作
//	    PageBean<Product> pageBean =productDAO.findByPage(page,listProduct.size());
//	    //将数据传递到页面上
//	    ActionContext.getContext().getValueStack().set("pageBean", pageBean);

		return "showProductSuccess";
	}
	
	//显示商品详细信息
	public String showProductDetail() {
		//连接数据库，获取商品信息
		String sql = "select new Product(id,name,sort,price,oneprice,img,sale,face,body,length,quantity) from Product where id="+this.id; 
//			DataProcess data = new DataProcess();
//			Vector vector = data.getData(sql);//记录集合
//			
		//关系型数据库转换为对象数据

		//一条记录转换为一个对象
//			Vector rowData = (Vector)vector.get(0);//读取一条记录			
//			Product product = new Product();//商品对象
//			product.setId(Integer.parseInt((String)rowData.get(0)));//记录中的字段数据赋值给对象的属性
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
	
	//分类商品信息
	public String showProductBySort() {
		String sql = "select new Product(id,name,price,img,sale) from Product where sort="+this.sort;
		List<Product> listProduct = productDAO.getProduct(sql);
		ActionContext.getContext().put("listProduct", listProduct);
		return "showProductSuccess";
	}
}
