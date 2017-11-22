package service;

import java.sql.Date;
import java.util.List;


import beans.DocenteDTO;
import beans.InstitucionDTO;
import beans.ReporteActividadDTO;
import beans.ReporteAlumnoDTO;
import dao.DAOFactory;

import interfaces.DocenteDAO;

public class DocenteService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	DocenteDAO obj = fabrica.getDocente();
	
	public int insertarDocente(DocenteDTO docente)
	{
		return obj.insertarDocente(docente);
	}
	
	public List<DocenteDTO>  listarDocentes()
	{
		return obj.listarDocentes();
	}
	
	public int actualizarDocente (DocenteDTO docente)
	{
		return obj.actualizarDocente(docente);
	}
	
	public int eliminarDocente (String codigo)
	{
		 obj.eliminarDocente(codigo);
		UsuarioService serviUsuario = new UsuarioService();
		return serviUsuario.eliminarUsuario(codigo);
		
		//si se eliminar docente elimianr el usuario tambien
	}
	
	public List<ReporteAlumnoDTO>  reportePorCarrera(String carrera)
	{
		return obj.reportePorCarrera(carrera);
	}
	
	public List<ReporteAlumnoDTO> reportePorSeccion(String seccion)
	{
		return obj.reportePorSeccion(seccion);
	}
	
	
	

	
	public List<ReporteActividadDTO> reporteActividadPorFechas(Date f1,Date f2)
	{
		return obj.reporteActPorFecha(f1, f2);
	}
	
	public List<ReporteActividadDTO> reporteActividadPorEstado(String estado)
	{
		return obj.reporteActPorEstado(estado);
	}
	
	public List<InstitucionDTO> reporteIntituciones()
	{
		return obj.reporteInstituciones();
	}


}
