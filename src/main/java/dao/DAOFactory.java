package dao;

import interfaces.ActividadDAO;
import interfaces.AlumnoDAO;
import interfaces.DocenteDAO;
import interfaces.UsuarioDAO;
import interfaces.InstitucionDAO;
import interfaces.VoluntariadoDAO;

public abstract class DAOFactory 
{
	public static final int MYSQL=1;
	public static final int ORACLE=2;
	public static final int DB2=3;
	public static final int SQLSERVER=4;
	public static final int XML=5;
	
	public abstract InstitucionDAO getInstitucion();
	public abstract VoluntariadoDAO getVoluntariado();
	public abstract UsuarioDAO getUsuario();
	public abstract ActividadDAO getActividad();
	
	public abstract DocenteDAO getDocente();	
	public abstract AlumnoDAO getAlumno();
	
	public static DAOFactory getDAOFactory(int withFactory)
	{
		switch(withFactory)
		{
		case MYSQL:
			return new MYSqlDAOFactory();
		case ORACLE:
		case DB2:
		case SQLSERVER:
		case XML:
			default:
				return null;
		}
	}
	
	

}
	


