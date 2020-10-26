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

import co.ufps.edu.webclothes.dao.ImagenDAO;
import co.ufps.edu.webclothes.model.Imagen;


/**
 * Servlet implementation class ImagenServlet
 */
@WebServlet(name="ImagenServlet", urlPatterns= {"/Imagen.do"})
public class ImagenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ImagenDAO imagenD;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImagenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
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
			case "imagenlist":
				listImagen(request,response);
				break;
			default:
				listImagen(request,response);
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
	
	private void listImagen(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		List <Imagen> imagen = imagenD.selectAll();
		request.setAttribute("imagen", imagen);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vistaCuerpo/listProduc.jsp");
		dispatcher.forward(request, response);
		
		
	}
	

}
