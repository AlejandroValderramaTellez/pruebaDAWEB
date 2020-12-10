package controlador.control_Usuario;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.UsuarioDAO;
import modelo.Usuario;

/**
 * Servlet implementation class Controlador_Mostrar_Todos
 */
@WebServlet("/Controlador_Mostrar_Todos")
public class Controlador_Mostrar_Todos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
	
    public Controlador_Mostrar_Todos() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			usuarioDAO = new UsuarioDAO(miPool);
		}catch (Exception e) {
			throw new ServletException();
		}
		
		List<Usuario> usuarios = usuarioDAO.readAll();
		
		request.setAttribute("listaUsuarios", usuarios);
		request.getRequestDispatcher("vistasUsuario/mostrarTodosUsuarios.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
