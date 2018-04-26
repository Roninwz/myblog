package com.zua.blog.tools;

import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.zua.blog.action.UserAction;
import com.zua.blog.dao.UserDao;
import com.zua.blog.entity.User;  

  

public class CookieUtils {  
    public static final String USER_COOKIE = "user.cookie";  
  
    public Cookie addCookie(User user) {  
        Cookie cookie = new Cookie(USER_COOKIE, user.getUsername() + ","  
                + user.getPassword());  
        System.out.println("���cookie");  
        cookie.setMaxAge(60 * 60 * 24 * 14);// cookie��������  
        return cookie;  
    }  
  
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
                        User user =new User("",username,password);
                       
                       boolean flag = userDAO.loginUsername(username,password);  
                        if (flag) {  
                            HttpSession session = request.getSession();  
                            session.setAttribute(UserAction.USER_SESSION, user);// ����û���session��  
                            return true;  
                        }  
                    }  
                }  
            }  
        }  
        return false;  
    }  
  
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

