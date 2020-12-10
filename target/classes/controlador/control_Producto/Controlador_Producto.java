package controlador.control_Producto;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.ProductoDAO;
import modelo.Producto;

/**
 * Servlet implementation class Controlador_Productos
 */
@WebServlet("/Controlador_Producto")
public class Controlador_Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup="jdbc/MVC_JSP")
	private DataSource miPool;
	
	private ProductoDAO productoDAO;
	
    public Controlador_Producto() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try{
			productoDAO = new ProductoDAO(miPool);
		}catch (Exception e) {
			throw new ServletException();
		}
		
		String comando = request.getParameter("instruccion");
		
		if(comando == null)
			comando = "listar";
		
		switch(comando) {
			case "listar":
				listarProductos(request, response);
				break;
			case "cargaParaActualizar":
				cargarProducto(request, response);
				break;
			case "insertar":
				insertarProducto(request,response);
				break;
			case "actualizar":
				actualizarProducto(request, response);
				break;
			case "eliminar":
				eliminarProducto(request,response);
				break;
			default:
				listarProductos(request, response);
		}
	}


	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Producto> productos = productoDAO.readAll();
		
		request.setAttribute("listaProductos", productos);
		request.getRequestDispatcher("vistasProducto/mostrarTodosProductos.jsp").forward(request, response);
	}
	
	
	protected void insertarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codProd = request.getParameter("codProd");
		String seccion = request.getParameter("seccion");
		String nombreProd = request.getParameter("nombreProd");
		Double precio = Double.parseDouble(request.getParameter("precio"));
		LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
		Boolean importado = Boolean.parseBoolean(request.getParameter("importado"));
		String pais = request.getParameter("pais");
		
		Producto p = new Producto(codProd, seccion, nombreProd, precio, fecha, importado, pais);
		
		try {
			this.productoDAO.create(p);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listarProductos(request, response);
			
	}
	
	protected void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codProd = request.getParameter("codProd");
		System.out.println(codProd);
		
		productoDAO.delete(codProd);
		listarProductos(request, response);
			
	}
	
	protected void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codProd = request.getParameter("codProd");
		String seccion = request.getParameter("seccion");
		String nombreProd = request.getParameter("nombreProd");
		Double precio = Double.parseDouble(request.getParameter("precio"));
		LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
		Boolean importado = Boolean.parseBoolean(request.getParameter("importado"));
		String pais = request.getParameter("pais");
		
		Producto p = new Producto(codProd, seccion, nombreProd, precio, fecha, importado, pais);
		
		if(productoDAO.update(p))
			listarProductos(request, response);
			
	}
	
	protected void cargarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codProd = request.getParameter("codProd");
		
		if(!codProd.isEmpty()) {
			Producto p = productoDAO.read(codProd);
			if(p != null) {
				request.setAttribute("productoEncontrado", p);
				request.getRequestDispatcher("vistasProducto/actualizarProducto.jsp").forward(request, response);
			}else
				request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);
		}else
			request.getRequestDispatcher("vistasProducto/error.jsp").forward(request, response);		
			
	}	
}
