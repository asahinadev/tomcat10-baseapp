package com.example.tomcat10;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DataSource ds;

	@SneakyThrows
	public void init(ServletConfig config) throws ServletException {
		log.debug("init {}", this.getClass().getName());
		super.init(config);

		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/example01");
	}

	@SneakyThrows
	protected Connection getConnection() {
		return ds.getConnection();
	}

	@SneakyThrows
	protected DataSource getDataSource() {
		return ds;
	}
}
