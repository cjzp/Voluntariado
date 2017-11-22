package service;

import java.sql.Date;
import java.util.List;

import beans.ActividadDTO;
import dao.DAOFactory;
import interfaces.ActividadDAO;

public class ActividadService 
{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ActividadDAO objAct = fabrica.getActividad();
	
	public List<ActividadDTO> listaActividad()
	{
		return objAct.listarActividades();
	}
	public List<ActividadDTO> listaActividadVolu()
	{
		return objAct.listarActividadesVolu();
	}
	
	public ActividadDTO buscaActividad(int cod)
	{
		return objAct.buscarActividad(cod);
	}
	
	public int registraActividad(ActividadDTO obj)
	{
		return objAct.registrarActividad(obj);
	}
	
	public int actualizaActividad(ActividadDTO obj)
	{
		return objAct.actualizarActividad(obj);
	}
	
	public int EliminaActividad(int cod) 
	{
		return objAct.eliminarActividad(cod);
	}
	
	public List<ActividadDTO> buscarPorEstado(String nombreEstado)
	{
		return objAct.buscarPorEstado(nombreEstado);
	}
	
	public List<ActividadDTO> buscarPorFecha(Date fecha)
	{
		return objAct.buscarPorFecha(fecha);
	}
	
	public int cambiarEstado(int codAct, int codEst)
	{
		return objAct.cambiarEstado(codAct, codEst);
	}
	
	public int alumnosAnotados(int codAct)
	{
		//mejor usar jstl?
		return objAct.alumnosAnotados(codAct);
	}
	
	
}
