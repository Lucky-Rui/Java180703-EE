package com.situ.student.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.situ.student.entity.User;

/**
 * 监听session对象的创建或销毁:HttpSessionAttributeListener
 * 
 * 监听session销毁，把当前登陆用户从onLineUserList移除！
 * 
 * @author WANGRUI
 *
 */
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// //1、获取session对象，ServletContext对象
		// HttpSession httpSession = se.getSession();
		// ServletContext servletContext = httpSession.getServletContext();
		//
		// //2、获取Session中的user
		// User user = (User) httpSession.getAttribute("user");
		//
		// //3、获取ServletContext中存储的在线用户列表集合
		// List<User> onLineUserList = (List<User>)
		// servletContext.getAttribute("onLineUserList");
		// //判断
		// if (user !=null) {
		// onLineUserList.remove(user);
		// }
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

}
