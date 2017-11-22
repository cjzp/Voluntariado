package servlets;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.VoluntariadoDTO;
import service.ActividadService;
import service.AlumnoService;
import service.VoluntariadoService;

/**
 * Servlet implementation class ServletVoluntariado
 */
@WebServlet("/ServletVoluntariado")
public class ServletVoluntariado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	VoluntariadoService serviVoluntariado = new VoluntariadoService();
	AlumnoService serviAlumno = new AlumnoService();
	ActividadService serviActividad = new ActividadService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVoluntariado() 
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
		else if(xtipo.equals("buscarVol"))
			buscarVol(request,response);
		else if(xtipo.equals("porActividad"))
		{
			try {
				buscarActividad(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(xtipo.equals("controlAlumno"))
		{
			try {
				controlAlumno(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(xtipo.equals("porAlumno"))
		{
			try {
				buscarAlumno(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(xtipo.equals("porSeccion"))
		{
			try {
				buscarSeccion(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(xtipo.equals("horasAlumno"))
		{
			try {
				horasAlumno(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(xtipo.equals("porActividadDoc"))
		{
			try {
				buscarActividadDoc(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(xtipo.equals("porActividadVol"))
		{
			try {
				buscarActividadVol(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(xtipo.equals("registrar"))
			try {
				registrar(request,response);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(xtipo.equals("actualizar"))
			try {
				actualizar(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(xtipo.equals("actualizarPorVol"))
			try {
				actualizarVol(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(xtipo.equals("eliminar"))
			try {
				eliminar(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void buscarActividadDoc(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		request.setAttribute("data", serviVoluntariado.buscarPorActividad( request.getParameter("cbo_actividad")));
		
		try
			{
				request.getRequestDispatcher("buscarActividad.jsp").forward(request, response);
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

	private void buscarActividadVol(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		request.setAttribute("data", serviVoluntariado.buscarPorActividad( request.getParameter("cbo_actividad")));
		
		try
			{
				request.getRequestDispatcher("listarVoluntarios.jsp").forward(request, response);
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

	private void buscarActividad(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		request.setAttribute("data", serviVoluntariado.buscarPorActividad( request.getParameter("cbo_actividad")));
		
		try
			{
				request.getRequestDispatcher("controlAsistencia.jsp").forward(request, response);
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
	private void buscarAlumno(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		request.setAttribute("data", serviVoluntariado.buscarPorAlumno( request.getParameter("txt_codigo")));
		
		try
			{
				request.getRequestDispatcher("verParticipacionesRealizadas.jsp").forward(request, response);
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
	
	private void controlAlumno(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		request.setAttribute("data", serviVoluntariado.controlDeAlumno( request.getParameter("txt_codigo")));
		
		try
			{
				request.getRequestDispatcher("controlAlumno.jsp").forward(request, response);
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
	
	private void buscarSeccion(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		request.setAttribute("data", serviVoluntariado.buscarPorSeccion( request.getParameter("txt_seccion")));
		
		try
			{
				request.getRequestDispatcher("listarSeccion.jsp").forward(request, response);
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
	private void horasAlumno(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		request.setAttribute("data", serviVoluntariado.buscarHorasAlumno( request.getParameter("txt_codigo")));
		
		try
			{
				request.getRequestDispatcher("listarHorasAlumno.jsp").forward(request, response);
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
	

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ParseException 
	{
		int cod = Integer.parseInt(request.getParameter("cod"));
		serviVoluntariado.EliminaVoluntariado(cod);
		// necesario eliminar el codigo de actividad en alumno? 
		buscarActividad(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ParseException 
	{
		int cod, actividad;
		
		String alumno = request.getParameter("txt_alumno");	
		
		String asistencia = request.getParameter("r_asistencia");
		String justificacion = request.getParameter("txt_justificacion");
		String horas = request.getParameter("txt_horas");
	        
	    cod = Integer.parseInt(request.getParameter("txt_cod"));
	    actividad = Integer.parseInt(request.getParameter("cbo_actividad"));
		
		VoluntariadoDTO obj =new VoluntariadoDTO();
			obj.setCodigo(cod);
			obj.setCodigoAlumno(alumno);
			obj.setCodigoActividad(actividad);
			obj.setAsistencia(asistencia);
			obj.setJustificacion(justificacion);
			obj.setHoras(Integer.parseInt(horas));
			serviVoluntariado.actualizaVoluntariado(obj);
			serviAlumno.anotarActividad(alumno, actividad);
			buscarActividad(request, response);
	}
	private void actualizarVol(HttpServletRequest request, HttpServletResponse response) throws ParseException 
	{
		int cod, actividad;
		
		String alumno = request.getParameter("txt_alumno");	
		        
	    cod = Integer.parseInt(request.getParameter("txt_cod"));
	    actividad = Integer.parseInt(request.getParameter("cbo_actividad"));
		
		VoluntariadoDTO obj =new VoluntariadoDTO();
			obj.setCodigo(cod);
			obj.setCodigoAlumno(alumno);
			obj.setCodigoActividad(actividad);
			serviVoluntariado.actualizaVoluntariado(obj);
			serviAlumno.anotarActividad(alumno, actividad); // necesario?
			listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) 
	{
		request.setAttribute("data", serviVoluntariado.listaVoluntariado());
		{
			try{
				request.getRequestDispatcher("listarVoluntarios.jsp").forward(request, response);
			}catch(ServletException e)
			{
				e.printStackTrace();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Voluntariado",serviVoluntariado.buscaVoluntariado(cod));
		request.getRequestDispatcher("actualizarVoluntariado.jsp").
		forward(request, response);
	}
	private void buscarVol(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Voluntariado",serviVoluntariado.buscaVoluntariado(cod));
		request.getRequestDispatcher("actualizarMismoVoluntario.jsp").
		forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ParseException 
	{
		
		
		
		int actividad;
		
			
		String alumno = request.getParameter("txt_alumno");	
		actividad = Integer.parseInt(request.getParameter("cbo_actividad"));
		
		String asistencia = request.getParameter("r_asistencia");
		String justificacion = request.getParameter("txt_justificacion");
		
		//int nparticipantes = serviActividad.alumnosAnotados(actividad);
		//if(nparticipantes == )
	
		VoluntariadoDTO obj =new VoluntariadoDTO();
		
			obj.setCodigoAlumno(alumno);
			obj.setCodigoActividad(actividad);
			obj.setAsistencia(asistencia);
			obj.setJustificacion(justificacion);
			
			
			
			
			serviVoluntariado.registraVoluntariado(obj);
			
						
			serviAlumno.anotarActividad(alumno, actividad);
			listar(request, response);
	}

}
