package service;

import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;

public class UsuarioService 
{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDAO objUsuario = fabrica.getUsuario();
	
	public UsuarioDTO iniciarSesion(String login)
	{
		return objUsuario.iniciarSesion(login);
	}

	public int insertarUsuario(UsuarioDTO usuario) {
		
		return objUsuario.insertarUsuario(usuario);
		
	}
	
	public int actualizarUsuario(UsuarioDTO obj)
	{
		return objUsuario.actualizarUsuario(obj);
				
	}
	
	public int eliminarUsuario(String codigo) {
		
		AlumnoService serviAlumno = new AlumnoService();
		serviAlumno.eliminarAlumno(codigo);
		
		return objUsuario.eliminarUsuario(codigo);
		// siempre de eliminar usuario eliminar alumno tambien
		
		
	}

	public UsuarioDTO buscarCodigoUsuario(String cod) {
		// TODO Auto-generated method stub
		return objUsuario.buscarCodigoUsuario(cod);
	}
	
	public void habilitarUsuario(String codigo,boolean habilitado) {
		// TODO Auto-generated method stub
		 objUsuario.habilitarUsuario(codigo, habilitado);
	}
	
	
	public void cambiarPass(String codigo, String nuevoPass)
	{
		objUsuario.cambiarPass(codigo, nuevoPass);
	}
	
}
