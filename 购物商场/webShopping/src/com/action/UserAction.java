package com.action;


import com.dao.UserDAO;
import com.po.Userinfo;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private String username;
	private String pwd;
	private String pwd1;
	private String sex;
	private String[] hobby;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	
	public String reg(){
		//验证数据
		if(this.getUsername()==null ||this.getUsername().equals("") ||
				this.getPwd()==null ||this.getPwd().equals("") ||
				this.getPwd1()==null ||this.getPwd1().equals("") || 
				sex==null || hobby==null){
			ActionContext.getContext().put("mess", "不能为空！");
			return "regError";
		}
		
		if(!this.pwd.equals(this.pwd1)){
			ActionContext.getContext().put("mess", "两次密码不一致！");
			return "regError";
		}
		
		//连接数据库验证，该用户是否已经存在
		String sql="from Userinfo where username='"+this.username+"'";
		UserDAO userDAO=new UserDAO();
		if(userDAO.getData(sql).size()>0){
			ActionContext.getContext().put("mess", "该用户名已经存在！");
			return "regError";
		}
		//处理数据
		String items="";	
		for (int i=0;i<hobby.length;i++){
			items=items+hobby[i]+",";
		}
		
		if(!items.equals("")){
			items=items.substring(0, items.length()-1);
		}
		

		
		  //添加到数据库
//		sql="insert into userinfo values('"+this.username+"','"+this.pwd+"','"+this.sex+"','"+items+"')";
//		if(dataProcess.update(sql)==0){
//			ActionContext.getContext().put("mess", "注册失败，请联系管理员！"); 
//			return "regError"; 
//		}
		 
		
		Userinfo userinfo=new Userinfo();
		userinfo.setUsername(this.getUsername());
		userinfo.setPwd(this.getPwd());
		userinfo.setSex(sex);
		userinfo.setHobby(items);
		
		if(!userDAO.saveUser(userinfo)){
			ActionContext.getContext().put("mess", "注册失败，请联系管理员！");
			return "regError";
		}
		ActionContext.getContext().put("userinfo", userinfo);
		return "regSuccess";
	}
	
	
	
	public String login(){
		//验证数据
		if(username == null || username.equals("") || pwd == null || pwd.equals("")){
			ActionContext.getContext().put("mess", "不能为空！");
			return "loginError";
		}
		
		//登陆
		String sql="from Userinfo where username='"+this.username+"' and pwd='"+this.pwd+"'";
//		DataProcess processData=new DataProcess();
//		Vector vector=processData.getData(sql);
		
		UserDAO userDAO=new UserDAO();
		if(userDAO.getData(sql).size()==0){
			ActionContext.getContext().put("mess", "用户名或密码不正确");
			return "loginError";
		}
		Userinfo userinfo=new Userinfo(this.getUsername(),this.getPwd());
//		userinfo.setUsername(this.getUsername());
//		userinfo.setPassword(this.getPwd());
		
		ActionContext.getContext().getSession().put("userinfo", userinfo);
		return "loginSuccess";
	}
	
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return "logoutSuccess";
	}
}
