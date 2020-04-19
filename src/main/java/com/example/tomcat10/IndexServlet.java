package com.example.tomcat10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/")
public class IndexServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	@SneakyThrows
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.debug("{} {}", request.getMethod(), request.getRequestURI());

		if (log.isDebugEnabled()) {
			Connection con = getConnection();

			PreparedStatement stm = con.prepareStatement("SHOW TABLES");

			ResultSet tables = stm.executeQuery();

			log.debug("TABLES -----------------------");
			while (tables.next()) {
				log.debug(tables.getString(1));
			}
			log.debug("------------------------------");

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/index.jsp");
		dispatcher.forward(request, response);

	}
}
