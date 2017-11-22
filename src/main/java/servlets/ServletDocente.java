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

import beans.DocenteDTO;
import beans.UsuarioDTO;
import service.DocenteService;
import service.UsuarioService;

/**
 * Servlet implementation class ServletDocente
 */
@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioService serviceUsuario = new UsuarioService();
	DocenteService service = new DocenteService();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String xtipo = request.getParameter("tipo");
		if(xtipo.equals("registrar"))
			registrar(request,response);
		else if(xtipo.equals("porSeccion"))
			try {
				reporteSeccion(request,response);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(xtipo.equals("porCarrera"))
			try {
				reporteCarrera(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(xtipo.equals("estado"))
			try {
				reporteEstado(request,response);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(xtipo.equals("fechas"))
			try {
				reporteFechas(request,response);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(xtipo.equals("reporInst"))
				reporteInstituciones(request,response);
			}

	private void reporteInstituciones(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("data", service.reporteIntituciones());
		{
			try{
				request.getRequestDispatcher("reporteInstitucion.jsp").forward(request, response);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	private void reporteFechas(HttpServletRequest request, HttpServletResponse response) throws ParseException{
		String f_1=request.getParameter("txt_f1");
		String f_2=request.getParameter("txt_f2");
		
		java.util.Date ftemp1=new SimpleDateFormat("yyyy-MM-dd").parse(f_1);
		Date sqlDate1= new Date(ftemp1.getTime());
		
		java.util.Date ftemp2=new SimpleDateFormat("yyyy-MM-dd").parse(f_2);
		Date sqlDate2= new Date(ftemp2.getTime());
		
		request.setAttribute("data", service.reporteActividadPorFechas(sqlDate1,sqlDate2));
		
		try
			{
				request.getRequestDispatcher("reporteActividadFechas.jsp").forward(request, response);
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

	private void reporteEstado(HttpServletRequest request, HttpServletResponse response) throws ParseException{
		request.setAttribute("data", service.reporteActividadPorEstado(request.getParameter("cbo_estado")));
		
		try
			{
				request.getRequestDispatcher("reporteActividadEstado.jsp").forward(request, response);
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

	private void reporteCarrera(HttpServletRequest request, HttpServletResponse response) throws ParseException{
		// TODO Auto-generated method stub
		request.setAttribute("data", service.reportePorCarrera( request.getParameter("cbo_carrera")));
		
		try
			{
				request.getRequestDispatcher("reporteAlumnoCarrera.jsp").forward(request, response);
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
	
	private void reporteSeccion(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		request.setAttribute("data", service.reportePorSeccion( request.getParameter("cbo_seccion")));
		
		try
			{
				request.getRequestDispatcher("reporteAlumnoSeccion.jsp").forward(request, response);
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
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) {
		
		
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido"); 
		String fono = request.getParameter("fono");
		String correo = request.getParameter("correo");
		

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setCodigo(codigo);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setTelefono(fono);
		usuario.setEstado(10); //10 activo, 11 inactivo fijo en bd
		usuario.setLogin(codigo);
		usuario.setPassword(codigo);
		usuario.setCorreo(correo);
		
		
		DocenteDTO docente = new DocenteDTO();
		docente.setCodigo(codigo);
		docente.setCod_usuario(codigo); //mismo?
		
		
		serviceUsuario.insertarUsuario(usuario);
		
		service.insertarDocente(docente);
		
	
			try {
				request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	
			
		
	}

}
