package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ComentariosDTO;
import beans.InstitucionDTO;
import service.InstitucionService;


/**
 * Servlet implementation class ServletInstitucion
 */
@WebServlet("/ServletInstitucion")
public class ServletInstitucion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	InstitucionService serviInstitucion = new InstitucionService();
	
    public ServletInstitucion() 
    {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String xtipo = request.getParameter("tipo");
		if(xtipo.equals("listarIns"))
			listar(request,response);
		else if(xtipo.equals("buscar"))
			buscar(request,response);
		else if(xtipo.equals("registrar"))
			registrar(request,response);
		else if(xtipo.equals("actualizar"))
			actualizar(request,response);
		else if(xtipo.equals("eliminar"))
			eliminar(request,response);
		
		
		else if(xtipo.equals("registrarComentarios"))
			registrarComentarios(request,response);
		else if(xtipo.equals("reporteComentarios"))
			reporteComentarios(request,response);
		else if(xtipo.equals("insNombres"))
			insNombres(request,response);
		else if(xtipo.equals("buscarCOD"))
			buscarCOD(request,response);
	}
	
	private void insNombres(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("data", serviInstitucion.listaInstitucionNombre());
		{
			try{
				request.getRequestDispatcher("mostrarInstitucionesParaCalificar.jsp").forward(request, response);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private void reporteComentarios(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("data", serviInstitucion.listarComentariosCaliInstitucion());
		{
			try{
				request.getRequestDispatcher("reporteComentariosCalificacion.jsp").forward(request, response);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void buscarCOD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Institucion",serviInstitucion.buscaInstitucionParaCalificar(cod));
		request.getRequestDispatcher("registrarComentariosCalificacion.jsp").
		forward(request, response);
		
	}

	private void registrarComentarios(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String comentarios=request.getParameter("txt_comentarios");
		int calificacion=Integer.parseInt(request.getParameter("txt_calificacion"));
		int cod=Integer.parseInt(request.getParameter("txt_cod"));
		
		ComentariosDTO obj=new ComentariosDTO();
			obj.setCodigo(cod);
			obj.setComentarios(comentarios);
			obj.setCalificacion(calificacion);
			serviInstitucion.registraComentarios(obj);
			insNombres(request, response);
			request.setAttribute("msg", "Datos registrados!");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void registrar(HttpServletRequest request, HttpServletResponse response)
	{	
		String nombre=request.getParameter("txt_nombre");
		String caracteristica=request.getParameter("txt_carac");
		String direccion=request.getParameter("txt_direccion");
		String telefono=request.getParameter("txt_fono");

		InstitucionDTO obj=new InstitucionDTO();
			obj.setNombre(nombre);
			obj.setCaracteristicas(caracteristica);
			obj.setDireccion(direccion);
			obj.setTelefono(telefono);
			serviInstitucion.registraInstitucion(obj);
			listar(request, response);
			//request.getRequestDispatcher("mensaje.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
	{
		int cod;
		
		String nombre=request.getParameter("txt_nombre");
		String caracteristica=request.getParameter("txt_carac");
		String direccion=request.getParameter("txt_direccion");
		String telefono=request.getParameter("txt_fono");
		
		cod=Integer.parseInt(request.getParameter("txt_cod"));
		
		InstitucionDTO obj=new InstitucionDTO();
			obj.setCodigo(cod);
			obj.setNombre(nombre);
			obj.setCaracteristicas(caracteristica);
			obj.setDireccion(direccion);
			obj.setTelefono(telefono);
			serviInstitucion.actualizaInstitucion(obj);
			listar(request, response);
			request.setAttribute("msg", "Datos actualizados!");
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
	{
		int cod=Integer.parseInt(request.getParameter("cod"));
		serviInstitucion.EliminaInstitucion(cod);
		listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Institucion",serviInstitucion.buscaInstitucion(cod));
		request.getRequestDispatcher("actualizarInstitucion.jsp").
		forward(request, response);
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("data", serviInstitucion.listaInstitucion());
		{
			try{
				request.getRequestDispatcher("listarInstitucion.jsp").forward(request, response);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
