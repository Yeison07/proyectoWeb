package co.ufps.edu.webclothes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import co.ufps.edu.webclothes.dao.CategoriaDAO;
import co.ufps.edu.webclothes.dao.ImagenDAO;
import co.ufps.edu.webclothes.dao.MarcaDAO;
import co.ufps.edu.webclothes.dao.ProductoDAO;
import co.ufps.edu.webclothes.model.Categoria;
import co.ufps.edu.webclothes.model.Imagen;
import co.ufps.edu.webclothes.model.Producto;

/**
 * Servlet implementation class SuperServlet
 */
@WebServlet(name="SuperServlet", urlPatterns= {"/Super.do"})
public class SuperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductoDAO productoD;
	private CategoriaDAO categoriaD;
	private ImagenDAO imagenD;
	HttpSession session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		this.categoriaD=new CategoriaDAO();
		this.productoD=new ProductoDAO();
		this.imagenD=new ImagenDAO();
		
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
			case "detalle":
				detalles(request,response);
				break;
			case "detalleM":
				detallesMas(request,response);
				break;
			default:
				volver(request,response);
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
	
	
	
	private void detalles(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		PrintWriter out= response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		Producto producto = productoD.select(id);
		Categoria categoria = categoriaD.select(producto.getCategoria_id());
		Imagen imagen= imagenD.select(id);
		JSONObject json= new JSONObject();
		json.put("categoria", categoria.getDescripcion());
		json.put("valor", producto.getValor());
		json.put("producto", producto.getNombre());
		json.put("descripcion", producto.getDescripcion());
		json.put("detalle", producto.getDetalle());
		System.out.println(imagen.getRuta());
		json.put("imagen", imagen.getRuta());
		
		out.print(json);
		
		this.session = request.getSession(true);
		int data = id;
		session.setAttribute("id", data );
		
		
	}
	
	private void detallesMas(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {	
		int id = (int)session.getAttribute("id"); 
		Producto producto = productoD.select(id);
		Categoria categoria = categoriaD.select(producto.getCategoria_id());
		Imagen imagen = imagenD.select(id);
		request.setAttribute("producto", producto);
		request.setAttribute("categoria", categoria);
		request.setAttribute("imagen", imagen);
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaCuerpo/detalleProduc.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	public void volver(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException{
		response.sendRedirect(request.getContextPath()); 
		
	}
	
	


}
