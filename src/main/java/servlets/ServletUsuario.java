package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsuarioDTO;
import service.UsuarioService;

/**
 * Servlet implementation class ServletUsuario
 */
  @WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UsuarioService servicio = new UsuarioService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() 
    {
        super();
        // TODO Auto-generated constructor stub
    }


    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String xtipo = request.getParameter("tipo");
		if(xtipo.equals("sesion"))
			iniciarSesion(request,response);
		else if (xtipo.equals("cerrarSesion"))
			cerrarSesion(request,response);
		else if (xtipo.equals("cambiarPass"))
			cambiarPass(request,response);
		
	}
	private void cambiarPass(HttpServletRequest request, HttpServletResponse response) {
		
		String codigo = request.getParameter("txt_codigoUsu");
		String nuevoPass = request.getParameter("txt_pass");
		
		servicio.cambiarPass(codigo, nuevoPass);
		
		//redirigir a ??
		//request.getRequestDispatcher("??").forward(request, response);
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		//request.setAttribute("msg", "Iniciar Sesion");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		if(request.getParameter("cerrarSesion")!=null)
		{
			sesion.invalidate();
		}
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String xlogin = request.getParameter("txt_login");
		String xpass = request.getParameter("txt_pass");
		
		UsuarioDTO obj = servicio.iniciarSesion(xlogin);
		
	
		
		if(obj!=null)//Si hay usuario
		{
			if(obj.getPassword().equals(xpass))
			{
				HttpSession sesion = request.getSession();
				sesion.setAttribute("datos", obj);
				sesion.setAttribute("usuario", obj.getLogin());
				sesion.setAttribute("nombre", obj.getNombre());
				
				if (obj.getLogin().substring(0, 1).equals("p"))
				{
					request.getRequestDispatcher("menuDocente.jsp").forward(request, response);
				}
				else if (obj.getLogin().substring(0, 2).equals("i2"))
				{
					request.getRequestDispatcher("menuAlumno.jsp").forward(request, response);
				}
				else if (obj.getLogin().substring(0, 1).equals("a"))
				{
					request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
				}
				
				
			}else{
				request.setAttribute("msg", "Contraseña incorrecta..."); //ñ muere?
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "Usuario no existe...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
