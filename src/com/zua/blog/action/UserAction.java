package com.zua.blog.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.zua.blog.entity.User;
import com.zua.blog.service.UserService;

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
		for (int i = 0; i < cookies.length; i++) {// 对cookies中的数据进行遍历，找到用户名、密码的数据
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
		
		return "login";
	}
	public String manage() {

		return "manage";
	}
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse();  
		String remember=request.getParameter("remember");
		String yanzhengma=request.getParameter("yanzhengma");
		//System.out.println(remember);
		//System.out.println(yanzhengma);
		boolean f = userService.login(user);
		ActionContext atx = ActionContext.getContext();
		//atx.put("username", user.getUsername());
		Map<String, Object> session = atx.getSession();
		// 对应于 WylInterceptor.java拦截器，这个拦截器里需要用到
		
		
		if (f) {
			if("y".equals(remember)){
//				System.out.println(1);
				Cookie username = new Cookie("username", user.getUsername());  
		        Cookie password = new Cookie("password", user.getPassword());  
		        username.setMaxAge(60*60);//周期是一个小时  
		        password.setMaxAge(60*60*24*60);//周期是60天  以秒为单位
		        ServletActionContext.getResponse().addCookie(username);  
		        ServletActionContext.getResponse().addCookie(password);  

			session.put("is_loginerr","true");
			session.put("currentUser", user);
			return "login_success";
		} else {
			session.put("is_loginerr", "false");
			System.out.println("登录失败");
			return "login_error";
		}
	}
		return "login_error";
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
		//清楚cookie
		Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
        	if ("username".equals(cookie.getName())||"password".equals(cookie.getName())) {
        	cookie.setValue(null);
        	cookie.setMaxAge(0);
        	//cookie只要做过更改都要添加到请求中
        	 response.addCookie(cookie);
        	System.out.println(cookie);
        	System.out.println(cookie.getName());
        	System.out.println(2);
        	}
		
	}
		return "logout";
	}

}
