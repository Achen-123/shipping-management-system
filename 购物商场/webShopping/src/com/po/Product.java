package com.po;

public class Product {
	private Integer id;
	private String name;
	private Integer sort;
	private Float price;
	private Float oneprice;
	private String img;
	private String date;
	private Integer sale;
	private String face;
	private String body;
	private Float length;
	private Integer quantity;
	private String source;
	
	
	public Product() {
		super();
	}
	
	public Product(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product(Integer id, String name, Float price, String img, Integer sale) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
		this.sale = sale;
	}
	public Product(Integer id, String name, Integer sort, Float price, Float oneprice, String img, Integer sale,
			String face, String body, Float length, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.sort = sort;
		this.price = price;
		this.oneprice = oneprice;
		this.img = img;
		this.sale = sale;
		this.face = face;
		this.body = body;
		this.length = length;
		this.quantity = quantity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getOneprice() {
		return oneprice;
	}
	public void setOneprice(Float oneprice) {
		this.oneprice = oneprice;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Float getLength() {
		return length;
	}
	public void setLength(Float length) {
		this.length = length;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
}
