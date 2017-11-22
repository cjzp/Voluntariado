package interfaces;

import java.sql.Date;
import java.util.List;

import beans.ActividadDTO;


public interface ActividadDAO 
{

	public int registrarActividad(ActividadDTO obj);
	public List<ActividadDTO> listarActividades();
	public ActividadDTO buscarActividad(int cod);
	public int actualizarActividad(ActividadDTO obj);
	public int eliminarActividad(int cod);
	List<ActividadDTO> buscarPorEstado(String nombreEstado);
	public List<ActividadDTO> listarActividadesVolu();
	public List<ActividadDTO> buscarPorFecha(Date fecha);
	
	public int cambiarEstado(int codAct, int codEst );//1 aprobado 2 en revision 3 descartado
	public int alumnosAnotados(int codAct);
	
}
