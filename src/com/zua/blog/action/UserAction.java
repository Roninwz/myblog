package com.zua.blog.action;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.zua.blog.entity.User;
import com.zua.blog.service.UserService;
import com.zua.blog.tools.CheckFormat;
import com.zua.blog.tools.FileDownload;
import com.zua.blog.tools.MD5Util;

import net.sf.json.JSONObject;


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
	
	 private String returndata;
	    //从Action返回json数据给调用的Ajax，毕竟用用Ajax基本上要交互下嘛。
	    
	    //对应getter,setter
	    public String getReturndata() {
	        return returndata;
	    }

	    public void setReturndata(String returndata) {
	        this.returndata = returndata;
	    }

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
		String md5pass=MD5Util.string2MD5(pass);
		if(CheckFormat.checkEmail(name)){
			f= userService.loginEmail(name,md5pass);
			System.out.println("Email"+name);
		}else {
			f= userService.loginUsername(name,md5pass);
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
	@SuppressWarnings("deprecation")
	public String exportExcel() {
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse();  
		//创建HSSFWorkbook对象(excel的文档对象)
	   HSSFWorkbook wb = new HSSFWorkbook();
	//建立新的sheet对象（excel的表单）
	HSSFSheet sheet=wb.createSheet("用户表");
	HSSFCellStyle style = wb.createCellStyle();//设置列样式
	style.setAlignment(HorizontalAlignment.CENTER);// 水平居中  
	style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中

	//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
	HSSFRow row1=sheet.createRow(0);
	//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
	HSSFCell cell=row1.createCell(0);
	 //设置单元格内容
	cell.setCellValue("用户信息一览表");
	sheet.setDefaultRowHeightInPoints(20);//设置缺省列高sheet.setDefaultColumnWidth(20);//设置缺省列宽
	//设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
	 //setColumnWidth第一个参数为列序号
	sheet.setColumnWidth(0, 256 * 30);
	sheet.setColumnWidth(1, 256 * 50);
	//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
	sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
	//在sheet里创建第二行
	HSSFRow row2=sheet.createRow(1);    
	      //创建单元格并设置单元格内容
	      row2.createCell(0).setCellValue("用户名");
	      row2.createCell(1).setCellValue("邮箱"); 
	      List<User> users=userService.allUser();
	      int i=2;
	      for (User user:users) {
	    	
	    	  HSSFRow row=sheet.createRow(i);
	          row.createCell(0).setCellValue(user.getUsername());
	          row.createCell(1).setCellValue(user.getEmail());
	          i++;
		}
	      String filename=request.getParameter("filename");
	      String savepath="D:\\eclipsework\\myblog\\WebContent\\jsp\\upload";
	      System.out.println(savepath);
	      //FileDownload.download("D:\\"+filename+".xlsx", response);
	     boolean f= FileDownload.outFile(wb,savepath+"\\"+filename+".xls");
	     /* if(f){
	    	  PrintWriter out=null;
	    	  try {
	  			 out= response.getWriter();
	  		out.print("<script>alert('添加成功！')</script>");
	  		} catch (IOException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}finally{
	  			out.close();
	  		}
	      }*/
	     
	      return "export_success";
	}
	public String register(){
		
			return "register";
		
		
	}
	public String registerCheck(){
		User use=new User();
		use.setUsername(user.getUsername());
		use.setEmail(user.getEmail());
		use.setPassword(MD5Util.string2MD5(user.getPassword()));
		System.out.println(use.getPassword());
		System.out.println(use.getEmail());
		System.out.println(use.getUsername());
		boolean f=userService.register(use);
		if(f){
			return "register_success";
		}else {
			return "register_error";
		}
		
	}
	
	
	public String isExistUsername(){
		ActionContext atx = ActionContext.getContext();
		//atx.put("username", user.getUsername());
		 Map<String, String> map=new HashMap<>();
		 boolean f=userService.isExistUsername(user.getUsername());
		if(f){
			 map.put("isUsernameTrue","用户名已存在");
		}else {
			 map.put("isUsernameTrue","用户名符合要求");
		}
		
		//map.put("uname", "用户名");
		System.out.println("f:"+f);
		JSONObject json=JSONObject.fromObject(map);
		/*JSONObject json = new JSONObject();  
        Set<String> set = map.keySet();  
        for (Iterator<String> it = set.iterator();it.hasNext();) {  
            String key = it.next();  
            json.put(key, map.get(key));  
        }      */   
		//System.out.println(json);
	    returndata=json.toString();
	    //System.out.println("returndata:"+returndata);
		return "username_exist";
	}
	public String isExistEmail(){
		//String exist=null;
		ActionContext atx = ActionContext.getContext();
		//atx.put("username", user.getUsername());
		 Map<String, Object> map=atx.getSession();
		boolean f=userService.isExistEmail(user.getEmail());
		if(f){
			 map.put("isEmailTrue","邮箱已存在");
		}else {
			 map.put("isEmailTrue","邮箱符合要求");
		}
		//map.put("isEmailTrue",f);
		//map.put("uname", "用户名");
		System.out.println("ww");
		 JSONObject json=JSONObject.fromObject(map);
		 System.out.println(json);
	    returndata=json.toString();
		return "email_exist";
	}
}
