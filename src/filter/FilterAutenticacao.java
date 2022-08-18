package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import conection.SingleConnection;

@WebFilter(urlPatterns = { "/principal/*" })
public class FilterAutenticacao implements Filter {

	private static Connection connection;

	public FilterAutenticacao() {

	}

	/* Encerra os processos quando o servidor é parado */
	public void destroy() {

		try {

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {

			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();

			String usuarioLogado = (String) session.getAttribute("usuario");

			String urlparaAutenticar = req.getServletPath(); /* url que está sendo acessada */

			/* Validar se estiver Logado, senão redireciona para tela de login */

			if (usuarioLogado == null && !urlparaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {

				RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlparaAutenticar);
				request.setAttribute("msg", "Por favor realize o login!");
				redireciona.forward(request, response);
				return;
			} else {

				chain.doFilter(request, response);
			}
			
			connection.commit();

		} catch (Exception e) {

			e.printStackTrace();
			
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);

			try {

				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}

	/* Inícia a conexão quando roda o projeto */
	public void init(FilterConfig fConfig) throws ServletException {

		connection = SingleConnection.getConnection();
	}

}
