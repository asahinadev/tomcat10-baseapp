package com.example.tomcat10;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/")
public class IndexServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.debug("{} {}", request.getMethod(), request.getRequestURI());
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/index.jsp");
		dispatcher.forward(request, response);

	}
}
