package interfaces;

import java.sql.Date;
import java.util.List;

import beans.DocenteDTO;
import beans.InstitucionDTO;
import beans.ReporteActividadDTO;
import beans.ReporteAlumnoDTO;

public interface DocenteDAO {
	
	public List<DocenteDTO> listarDocentes();
	public int insertarDocente(DocenteDTO docente);
	public int actualizarDocente(DocenteDTO docente);
	public int eliminarDocente(String codigo);
	DocenteDTO buscarCodigoDocente(String cod);
	
	public List<ReporteAlumnoDTO> reportePorCarrera(String carrera);
	public List<ReporteAlumnoDTO> reportePorSeccion(String seccion);
	public List<InstitucionDTO> reporteInstituciones();
	public List<ReporteActividadDTO> reporteActPorEstado(String estado);
	public List<ReporteActividadDTO> reporteActPorFecha(Date f1, Date f2);

}
