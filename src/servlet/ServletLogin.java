package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelLogin;


@WebServlet("/ServletLogin") /*Mapeamento de dados que vem da tela*/
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletLogin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

    /*Recebe os dados enviado por um formuário*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
				
				ModelLogin modelLogin = new ModelLogin();
				
				modelLogin.setLogin(login);
				modelLogin.setSenha(senha);
				
				if(modelLogin.getLogin().equalsIgnoreCase("admin") && 
						modelLogin.getSenha().equalsIgnoreCase("admin")) {
					
					request.getSession().setAttribute("usuario", modelLogin.getLogin());
					
					RequestDispatcher redirecionar = request.getRequestDispatcher("principal/principal.jsp");
					redirecionar.forward(request, response);
				}
				else {
					
					RequestDispatcher redirecionar =  request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg", "Informe Login e senha corretamente");
					redirecionar.forward(request, response);
				}
			}
			else {
				
				RequestDispatcher redirecionar =  request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Informe Login e senha corretamente");
				redirecionar.forward(request, response);
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
