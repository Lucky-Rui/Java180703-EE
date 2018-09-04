package com.situ.day036.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter1 implements Filter {
	// 多个Filter执行的顺序：
	// web服务器根据Filter在web.xml中注册的顺序，决定先调用哪个Filter
	// HelloFilter1.HelloFilter1()
	// HelloFilter1.init()
	// HelloFilter2.HelloFilter2()
	// HelloFilter2.init()
	// HelloFilter1.doFilter() before
	// HelloFilter2.doFilter() before
	// FilterServlet.service()
	// HelloFilter2.doFilter() after
	// HelloFilter1.doFilter() after
	public HelloFilter1() {
		System.out.println("HelloFilter1.HelloFilter1()");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("HelloFilter1.init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("HelloFilter1.doFilter() before");
		// 执行下一个过滤器或放行（访问servlet）
		chain.doFilter(request, response);
		System.out.println("HelloFilter1.doFilter() after");
	}

	@Override
	public void destroy() {
		System.out.println("HelloFilter1.destroy()");
	}

}
