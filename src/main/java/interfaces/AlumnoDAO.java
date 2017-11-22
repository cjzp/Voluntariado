package interfaces;

import java.util.List;

import beans.AlumnoDTO;


public interface AlumnoDAO {
	
	public List<AlumnoDTO> listarAlumnos();
	public int insertarAlumno(AlumnoDTO alumno);
	public int actualizarAlumno(AlumnoDTO alumno);
	public int eliminarAlumno(String codigo);
	public AlumnoDTO buscarCodigoAlumno(String cod);
	
	public int anotarActividad(String codAlu,int codAct);
	
}
