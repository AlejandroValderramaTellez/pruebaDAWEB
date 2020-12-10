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
 * Servlet implementation class Controlador_eliminarPorClave
 */
@WebServlet("/Controlador_eliminarPorClave")
public class Controlador_eliminarPorClave extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
    
	
    public Controlador_eliminarPorClave() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			usuarioDAO = new UsuarioDAO(miPool);
			Long id = Long.parseLong(request.getParameter("id_usuario"));
			
			if(usuarioDAO.delete(id)) {
				request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
			}else
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
			
		}catch (NumberFormatException e1) {
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}catch (Exception e) {
			throw new ServletException();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
