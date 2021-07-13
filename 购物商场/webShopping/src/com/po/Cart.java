package com.po;

public class Cart {
	private Integer cartid;
	private String username;
	private Integer productid;
	private Integer count;
	
	//“≥√Êœ‘ æ
	private String proName;
	private Float price;
	private Float sum;
	
	
	
	public Cart() {
		super();
	}

	public Cart(Integer cartid,Integer productid, Integer count) {
		super();
		this.cartid = cartid;
		this.productid = productid;
		this.count = count;
	}

	public Cart(String username, Integer productid) {
		super();
		this.username = username;
		this.productid = productid;
	}

	public Cart(Integer cartid, Integer count, String proName, Float price, Float sum) {
		super();
		this.cartid = cartid;
		this.count = count;
		this.proName = proName;
		this.price = price;
		this.sum = sum;
	}


	public Integer getCartid() {
		return cartid;
	}
	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}
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
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getSum() {
		return sum;
	}
	public void setSum(Float sum) {
		this.sum = sum;
	}	
}

