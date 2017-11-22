package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ActividadDTO;
import service.ActividadService;


/**
 * Servlet implementation class ServletActividad
 */
@WebServlet("/ServletActividad")
public class ServletActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ActividadService serviActividad = new ActividadService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActividad() 
    {
        super();   
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String xtipo = request.getParameter("tipo");
		if(xtipo.equals("listar"))
			listar(request,response);
		else if(xtipo.equals("buscar"))
			buscar(request,response);
		else if(xtipo.equals("listarVol"))
			listarVol(request,response);
		else if(xtipo.equals("listarActividadVol"))
			listarActividadVol(request,response);
		else if(xtipo.equals("porEstado"))
		{
			try {
				buscarEstado(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(xtipo.equals("porFecha"))
		{
			try {
				buscarFecha(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(xtipo.equals("registrar"))
			try {
				registrar(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(xtipo.equals("actualizar"))
			try {
				actualizar(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(xtipo.equals("eliminar"))
			eliminar(request,response);
	}
	private void buscarEstado(HttpServletRequest request, HttpServletResponse response) throws ParseException 
	{
		request.setAttribute("data", serviActividad.buscarPorEstado( request.getParameter("cbo_estado")));
		
		try
			{
				request.getRequestDispatcher("listarEstadoActividad.jsp").forward(request, response);
			}
		catch(ServletException e)
			{
				e.printStackTrace();
			}
		catch(IOException e)
			{
				e.printStackTrace();
			}		
	}
	
	private void buscarFecha(HttpServletRequest request, HttpServletResponse response) throws ParseException 
	{
		
		String f_registro=request.getParameter("txt_fecha");
		
		java.util.Date ftemp=new SimpleDateFormat("yyyy-MM-dd").parse(f_registro);
		Date sqlDate= new Date(ftemp.getTime());
		
		request.setAttribute("data", serviActividad.buscarPorFecha(sqlDate));
		try {
			request.getRequestDispatcher("listarFechaActividad.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) 
	{
		request.setAttribute("data", serviActividad.listaActividad());
		{
			try{
				request.getRequestDispatcher("listarActividad.jsp").forward(request, response);
			}catch(ServletException e)
			{
				e.printStackTrace();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ParseException  
	{
		int estado,institucion;
		
		String nombre = request.getParameter("txt_nom");
		String descripcion = request.getParameter("txt_des");
		String fecha = request.getParameter("txt_fecha");
		String horainicio = request.getParameter("cbo_inicio");
		String horafin = request.getParameter("cbo_fin");
		String docente = request.getParameter("cbo_docente");
		String motivo = request.getParameter("txt_motivo");
		
		
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date parsed = format.parse(fecha);
	        java.sql.Date sql = new java.sql.Date(parsed.getTime());

		estado = Integer.parseInt(request.getParameter("cbo_estado"));
		institucion = Integer.parseInt(request.getParameter("cbo_institucion"));
			
		ActividadDTO obj =new ActividadDTO();
			obj.setCod_institucion(institucion);
			obj.setNombre(nombre);
			obj.setDescripcion(descripcion);
			obj.setFecha(sql);
			obj.setHoraInicio(horainicio);
			obj.setHoraFin(horafin);
			obj.setCod_docente(docente);
			obj.setCodEstado(estado);
			obj.setMotivoEstado(motivo);
			serviActividad.registraActividad(obj);
			listar(request, response);
	}
	
	private void listarVol(HttpServletRequest request, HttpServletResponse response) 
	{
		request.setAttribute("data", serviActividad.listaActividadVolu());
		{
			try{
				request.getRequestDispatcher("registrarVoluntariado.jsp").forward(request, response);
			}catch(ServletException e)
			{
				e.printStackTrace();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	private void listarActividadVol(HttpServletRequest request, HttpServletResponse response) 
	{
		request.setAttribute("data", serviActividad.listaActividadVolu());
		{
			try{
				request.getRequestDispatcher("actividadesVoluntariado.jsp").forward(request, response);
			}catch(ServletException e)
			{
				e.printStackTrace();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) 
	{
		int cod = Integer.parseInt(request.getParameter("cod"));
		serviActividad.EliminaActividad(cod);
		listar(request, response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Actividad",serviActividad.buscaActividad(cod));
		request.getRequestDispatcher("actualizarActividad.jsp").
		forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ParseException 
	{
		int cod, estado, institucion;
	
		String nombre = request.getParameter("txt_nom");
		String descripcion = request.getParameter("txt_des");
		String fecha = request.getParameter("txt_fecha");
		String horainicio = request.getParameter("txt_inicio");//cbo_inicio
		String horafin = request.getParameter("txt_fin");//cbo_fin
		String docente = request.getParameter("txt_docente");
		String motivo = request.getParameter("txt_motivo");

		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date parsed = format.parse(fecha);
	        java.sql.Date sql = new java.sql.Date(parsed.getTime());
	        
	    cod = Integer.parseInt(request.getParameter("txt_cod"));
		estado = Integer.parseInt(request.getParameter("cbo_estado"));
		
		institucion = Integer.parseInt(request.getParameter("txt_institucion"));
		
		ActividadDTO obj =new ActividadDTO();
			obj.setCodigo(cod);
			obj.setCod_institucion(institucion);
			obj.setNombre(nombre);
			obj.setDescripcion(descripcion);
			obj.setFecha(sql);
			obj.setHoraInicio(horainicio);
			obj.setHoraFin(horafin);
			obj.setCod_docente(docente);
			obj.setCodEstado(estado);
			obj.setMotivoEstado(motivo);
			serviActividad.actualizaActividad(obj);
			listar(request, response);
	}

}
