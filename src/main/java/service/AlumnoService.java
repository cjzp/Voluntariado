package service;

import java.util.List;

import beans.AlumnoDTO;
import dao.DAOFactory;
import interfaces.AlumnoDAO;

public class AlumnoService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	AlumnoDAO obj = fabrica.getAlumno();
	
	public int insertarAlumno(AlumnoDTO alumno)
	{
		return obj.insertarAlumno(alumno);
	}
	
	public List<AlumnoDTO>  listarAlumnos()
	{
		return obj.listarAlumnos();
	}
	
	public int actualizarAlumno(AlumnoDTO alumno)
	{
		return obj.actualizarAlumno(alumno);
	}
	
	public int eliminarAlumno(String codigo)
	{		
		obj.eliminarAlumno(codigo);
		UsuarioService serviUsuario = new UsuarioService();
		//si se eliminar alumno elimianr el usuario tambien
		return serviUsuario.eliminarUsuario(codigo);
	}

	public AlumnoDTO buscarCodigoAlumno(String cod) {
		// TODO Auto-generated method stub
		return obj.buscarCodigoAlumno(cod);
	}
	
	public int anotarActividad(String codAlu, int codAct)
	{
		return obj.anotarActividad(codAlu, codAct);
	}
	
	//public int 
	

}
