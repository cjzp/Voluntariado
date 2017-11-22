package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.AlumnoDTO;
import beans.UsuarioDTO;
import service.AlumnoService;
import service.UsuarioService;

/**
 * Servlet implementation class ServletAlumno
 */
@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioService serviceUsuario = new UsuarioService();
	AlumnoService service =new AlumnoService(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumno() {
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
		if(xtipo.equals("actividad"))
			actividad(request,response);
		
	}

	private void actividad(HttpServletRequest request, HttpServletResponse response) {
		
		/*antes de llegar aqui verificar si se cumplen condiciones 
		 * con jstl en lado cliente
		 */
		String codAlu = request.getParameter("txt_codAlu");
		int codAct = Integer.parseInt(request.getParameter("txt_codAct"));
		
		
		service.anotarActividad(codAlu, codAct);
		
		// request.getRequestDispatcher("??").forward(request, response);
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) {
		
		
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido"); 
		String carrera = request.getParameter("carrera"); //debe ser el codigo carrera el value del combo
		String seccion = request.getParameter("seccion"); //debe ser el codigo seccion el value del combo
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
		
		
		AlumnoDTO alumno = new AlumnoDTO();
		alumno.setCodigo_usuario(codigo); //igual 
		alumno.setCodigo(codigo);
		alumno.setCarrera(Integer.parseInt(carrera));
		alumno.setSeccion(Integer.parseInt(seccion));
		//se actualiza luego por una actividad existente
		alumno.setCod_actividad(0); 
		
		
		serviceUsuario.insertarUsuario(usuario); //siempre crear usuario primero
		
		service.insertarAlumno(alumno);
			//request.setAttribute("msg", "Usuario no existe...");
			// request.getRequestDispatcher("login.jsp").forward(request, response);
		
		
	}

}
