package com.situ.day036.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter1 implements Filter {
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
