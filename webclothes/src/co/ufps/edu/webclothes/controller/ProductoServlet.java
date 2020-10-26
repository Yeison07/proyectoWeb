package co.ufps.edu.webclothes.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.webclothes.dao.ProductoDAO;
import co.ufps.edu.webclothes.model.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name="ProductoServlet", urlPatterns= {"/Producto.do"})
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoD;
       
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		this.productoD=new ProductoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= (request.getParameter("action") != null) ? request.getParameter("action"):"list";
		System.out.println(action);
		
		try {
			switch (action) {
			case "new":
				showNewForm(request,response);
				break;
			case "insert":
				insertarProducto(request,response);
				break;
			case "delete":
				eliminarProducto(request,response);
				break;
			case "edit":
				showEditForm(request,response);
				break;
			case "update":
				actualizarProducto(request,response);
				break;
			default:
				listProducto(request,response);
				break;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ServletException (e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaProducto/registroProducto.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarProducto(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		String referencia=request.getParameter("referencia");
		String nombre=request.getParameter("nombre");
		String descripcion=request.getParameter("descripcionC");
		String detalle=request.getParameter("detalle");
		String palabrasC=request.getParameter("palabrasC");
		String estado=request.getParameter("estado");
		Double valor=Double.valueOf(request.getParameter("valor"));
		int categoria_id=Integer.valueOf(request.getParameter("categoriaID"));
		int marca_id=Integer.valueOf(request.getParameter("marcaID"));
				
		
		Producto Producto= new Producto(referencia,nombre,descripcion,detalle,palabrasC,estado,valor,categoria_id,marca_id);
		productoD.insert(Producto);
		response.sendRedirect(request.getContextPath()); 
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("id"));
		
		Producto producto=productoD.select(id);
		
		request.setAttribute("producto", producto);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaProducto/registroProducto.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		int id=Integer.valueOf(request.getParameter("id"));
		String referencia=request.getParameter("referencia");
		String nombre=request.getParameter("nombre");
		String descripcion=request.getParameter("descripcion");
		String detalle=request.getParameter("detalle");
		String palabrasC=request.getParameter("palabras");
		String estado=request.getParameter("estado");
		Double valor=Double.valueOf(request.getParameter("valor"));
		int categoria_id=Integer.valueOf(request.getParameter("categoriaID"));
		int marca_id=Integer.valueOf(request.getParameter("marcaID"));
		
		Producto producto= new Producto(id,referencia,nombre,descripcion,detalle,palabrasC,estado,valor,categoria_id,marca_id);
		
		productoD.update(producto);
		response.sendRedirect(request.getContextPath()); 
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		productoD.delete(id);
		
		response.sendRedirect(request.getContextPath()); 
		
	}
	
	private void listProducto(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		List <Producto> listProducto = productoD.selectAll();
		request.setAttribute("listProducto", listProducto);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaProducto/ListaProducto.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
