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
import modelo.Usuario;

/**
 * Servlet implementation class Controlador_ActualizaUsuarioVersion2
 */
@WebServlet("/Controlador_ActualizaUsuarioVersion2")
public class Controlador_ActualizaUsuarioVersion2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private UsuarioDAO usuarioDAO;
	
	
    public Controlador_ActualizaUsuarioVersion2() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//Para que tanto al cargar los datos como al actualizar, respete los caracteres
		
		try{
			usuarioDAO = new UsuarioDAO(miPool);
		}catch (Exception e) {
			throw new ServletException();
		}
		
		Usuario u = null;
		
		if ("Busca usuario".equals(request.getParameter("botonBusca")))
			buscaUsuario(u,request,response);
		
		else if("Actualiza usuario".equals(request.getParameter("botonActualiza"))){
			System.out.println("entra en actualiza después de buscar");
			actualizaUsuario(u,request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void buscaUsuario(Usuario u, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		
		//Si los dos valores son distintos de "" entra en login
		if(!usuario.isEmpty() && !contrasena.isEmpty()) {
			u = usuarioDAO.login(usuario, contrasena);
			if(u != null) {
				//En el constructor: guardamos en la sesión el usuario encontrado
				request.getSession().setAttribute("usuarioEncontrado", u);
				System.out.println(u);
				request.getRequestDispatcher("vistasUsuario/actualizaUsuario.jsp").forward(request, response);
			}else
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}else
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
	}
	
	
	private void actualizaUsuario(Usuario u, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//compruebo si se encontro el usuario a modificar
		u = (Usuario)request.getSession().getAttribute("usuarioEncontrado");
		//U = (Usuario)request.getAttribute("usuarioEncontrado"); no existe este atributo en el request
		System.out.println(" llega a mostrar u: "+ u);
		
		
		if(u!=null) {
			Usuario u2 = new Usuario(Long.parseLong(request.getParameter("id_usuarioEnc")), 
					request.getParameter("nombreEnc"), 
					request.getParameter("apellidosEnc"),
					request.getParameter("usuarioEnc"),
					request.getParameter("contrasenaEnc"),
					request.getParameter("paisEnc"),
					request.getParameter("tecnologiaEnc"));
			
			//impt: actualizar la sesión antes del forward
			request.getSession().setAttribute("usuarioEncontrado", new Usuario());
			
			if(usuarioDAO.update(u2)) {
				request.getRequestDispatcher("vistasUsuario/exito.jsp").forward(request, response);
			}else
				request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		}else //Controla el botón actualiza cuando no se ha pulsado el botón busca
			request.getRequestDispatcher("vistasUsuario/error.jsp").forward(request, response);
		
	}

}
