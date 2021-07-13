package com.action;

import java.util.List;

import com.dao.CartDAO;
import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.po.Cart;
import com.po.Product;
import com.po.Userinfo;

public class CartAction {
	
	CartDAO cartDAO = new CartDAO();
	private Integer cartid;
	private String username;
	private Integer productid;
	private Integer count;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCartid() {
		return cartid;
	}

	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}

	
	public String showCartByUsername() {
	
		//��֤�Ƿ��½
		Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
		if(userinfo.getUsername() == null){//û�е�½�ɹ�
			return "loginError";
		}
		float sum = 0;
		String sql = "select new Cart(c.cartid,c.count,p.name,p.price,c.count*p.price) from Product p,Cart c where p.id=c.productid and c.username='"+userinfo.getUsername()+"'";
		List<Cart> cartList = cartDAO.getData(sql);
		for(Cart cart:cartList) {
			sum += cart.getCount()*cart.getPrice();
		}
		ActionContext.getContext().put("cartList", cartList);
		ActionContext.getContext().put("sum", sum);
		return "showCartSuccess";
	}
	
	//ɾ�����ﳵ����Ʒ
	public String deleteProductOfCart() {
		String sql = "delete from Cart where cartid ="+this.cartid;
		//List<Cart> cartList = cartDAO.getData(sql);
		cartDAO.deleteCart(sql);
		return "updateProductSuccess";
	}
	
	//��ո��û����ﳵ
	public String clearCart() {
		Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
		String sql = "delete from Cart where username='"+userinfo.getUsername()+"'";
		cartDAO.deleteCart(sql);
		return "updateProductSuccess";
	}
	//�����Ʒ�����ﳵ
	public String addToCart() {
		//��֤�Ƿ��½
		Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
		if(userinfo.getUsername() == null){//û�е�½�ɹ�
			return "loginError";
		}
		Cart cart = new Cart(username,productid);
		//��ѯ���û��ĸ���Ʒ�Ƿ��Ѿ�����
		String sql="from Cart where username='"+this.username+"' and productid="+productid;
		List<Cart> cartList = cartDAO.getData(sql);
		if(cartList.size()>0){
			cart.setCartid(cartList.get(0).getCartid());
			count +=  cartList.get(0).getCount();
		}
		cart.setCount(count);
		cartDAO.saveCart(cart);
		
		return "addCartSuccess";
	}
	
	public String pay() {	
		Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
		String sql1 = "select new Cart(c.cartid,c.productid,c.count) from Cart c where username='"+userinfo.getUsername()+"'";
		List<Cart> cartList = cartDAO.getData(sql1);
		Product product  = new Product();
		for(Cart cart:cartList) {
			String sql2 = "update Product SET sale=sale+"+cart.getCount()+" where id="+cart.getProductid();
			cartDAO.deleteCart(sql2);
		}
		String sql3 = "delete from Cart where username='"+userinfo.getUsername()+"'";
		cartDAO.deleteCart(sql3);
		return "paySuccess";
	}
}
