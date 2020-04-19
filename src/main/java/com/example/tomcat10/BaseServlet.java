package com.example.tomcat10;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		log.debug("init {}", this.getClass().getName());
		super.init(config);
	}

}
