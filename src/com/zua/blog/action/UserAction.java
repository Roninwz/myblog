package com.zua.blog.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.zua.blog.entity.User;
import com.zua.blog.service.UserService;
import com.zua.blog.tools.CheckFormat;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	public static final String USER_SESSION = "user.session"; 
	
	private UserService userService;
	private User user = new User();
//	private String remember;
	private ValueStack valueStack = ActionContext.getContext().getValueStack();

	/*public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}
*/
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ValueStack getValueStack() {
		return valueStack;
	}

	public void setValueStack(ValueStack valueStack) {
		this.valueStack = valueStack;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public String admin() {
	HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse();  
		String username = "";
		String password = "";
		ActionContext atx = ActionContext.getContext();
		//atx.put("username", user.getUsername());
		Map<String, Object> session = atx.getSession();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {// ��cookies�е����ݽ��б������ҵ��û��������������
				if ("username".equals(cookies[i].getName())) {
					username = cookies[i].getValue();
				System.out.println("admin-1:"+username);
				} else if ("password".equals(cookies[i].getName())) {
					password = cookies[i].getValue();
					System.out.println("admin-1:"+password);
				}
			}
			session.put("username", username);
			session.put("password", password);
		}
		
		
		return "login";
	}
	public String manage() {

		return "manage";
	}
	public String login() {
		boolean f =false;
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse();  
		String remember=request.getParameter("remember");
		String yanzhengma=request.getParameter("yanzhengma");
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		if(CheckFormat.checkEmail(name)){
			f= userService.loginEmail(name,pass);
			System.out.println("Email"+name);
		}else {
			f= userService.loginUsername(name,pass);
			System.out.println("Username"+name);
		}
		ActionContext atx = ActionContext.getContext();
		//atx.put("username", user.getUsername());
		Map<String, Object> session = atx.getSession();
		
		
		
		if (f) {
			if("y".equals(remember)){
				System.out.println(remember);
				Cookie username = new Cookie("username", name);  
		        Cookie password = new Cookie("password", pass);  
		        username.setMaxAge(60*60);//用户cookie过期时间为一天 
		        password.setMaxAge(60*60*24*60);//单位为秒
		        ServletActionContext.getResponse().addCookie(username);  
		        ServletActionContext.getResponse().addCookie(password);  

			session.put("is_loginerr","true");
			session.put("currentUser", user);
			
		} 
		return "login_success";
	}else {
		session.put("is_loginerr", "false");
		return "login_error";
	}
		//return "login_error";
	}
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse();  
		ActionContext atx = ActionContext.getContext();
		//atx.put("username", user.getUsername());
		Map<String, Object> session = atx.getSession();
		if(session.get("currentUser")!=null){
			session.remove("currentUser"); 
		}
		Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
        	if ("username".equals(cookie.getName())||"password".equals(cookie.getName())) {
        	cookie.setValue(null);
        	cookie.setMaxAge(0);
        	//cookie更改之后必须添加
        	 response.addCookie(cookie);
        	System.out.println(cookie);
        	System.out.println(cookie.getName());
        	System.out.println(2);
        	}
		
	}
		return "logout";
	}

}
