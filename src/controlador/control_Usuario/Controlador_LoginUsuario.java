package controlador.control_Usuario;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.UsuarioDAO;

/**
 * Servlet implementation class Controlador_LoginUsuario
 */
@WebServlet("/Controlador_LoginUsuario")
public class Controlador_LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
	
	
    public Controlador_LoginUsuario() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibo los parámetros del loginUsuario.jsp
		try{
			usuarioDAO = new UsuarioDAO(miPool);
		}catch (Exception e) {
			throw new ServletException();
		}
			
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
					
		
		if(usuarioDAO.login(usuario,  contrasena)!=null) {
			request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
		}else
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
