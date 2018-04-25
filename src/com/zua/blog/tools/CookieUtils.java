package com.zua.blog.tools;

import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.zua.blog.action.UserAction;
import com.zua.blog.dao.UserDao;
import com.zua.blog.entity.User;  

  
/** 
 * cookie的增加、删除、查询 
 */  
public class CookieUtils {  
    public static final String USER_COOKIE = "user.cookie";  
  
    // 添加一个cookie  
    public Cookie addCookie(User user) {  
        Cookie cookie = new Cookie(USER_COOKIE, user.getUsername() + ","  
                + user.getPassword());  
        System.out.println("添加cookie");  
        cookie.setMaxAge(60 * 60 * 24 * 14);// cookie保存两周  
        return cookie;  
    }  
  
    // 得到cookie  
    public boolean getCookie(HttpServletRequest request, UserDao userDAO) {  
        Cookie[] cookies = request.getCookies();  
        System.out.println("cookies: " + cookies);  
        if (cookies != null) {  
            for (Cookie cookie : cookies) {  
                System.out.println("cookie: " + cookie.getName());  
                if (CookieUtils.USER_COOKIE.equals(cookie.getName())) {  
                    String value = cookie.getValue();  
                    if (StringUtils.isNotBlank(value)) {  
                        String[] split = value.split(",");  
                        String username = split[0];  
                        String password = split[1];  
                        User user =new User(username,password);
                       
                       boolean flag = userDAO.login(user);  
                        if (flag) {  
                            HttpSession session = request.getSession();  
                            session.setAttribute(UserAction.USER_SESSION, user);// 添加用户到session中  
                            return true;  
                        }  
                    }  
                }  
            }  
        }  
        return false;  
    }  
  
    // 删除cookie  
    public Cookie delCookie(HttpServletRequest request) {  
        Cookie[] cookies = request.getCookies();  
        if (cookies != null) {  
            for (Cookie cookie : cookies) {  
                if (USER_COOKIE.equals(cookie.getName())) {  
                    cookie.setValue("");  
                    cookie.setMaxAge(0);  
                    return cookie;  
                }  
            }  
        }  
        return null;  
    }  
}  

