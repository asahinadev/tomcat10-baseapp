package com.example.tomcat10.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener("database")
public class DatabaseListener implements ServletContextListener {

	@SneakyThrows
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.debug("contextDestroyed", this.getClass());
	}

	@SneakyThrows
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.debug("contextInitialized", this.getClass());

		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/example01");

		log.debug("flyway {}", this.getClass().getName());
		Flyway flyway = Flyway.configure().dataSource(ds).load();
		flyway.migrate();
	}
}
