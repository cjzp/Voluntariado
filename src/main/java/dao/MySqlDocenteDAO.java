package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import beans.DocenteDTO;
import beans.InstitucionDTO;
import beans.ReporteActividadDTO;
import beans.ReporteAlumnoDTO;
import interfaces.DocenteDAO;
import utils.MySqlDBConexion;

public class MySqlDocenteDAO implements DocenteDAO {

	@Override
	public List<DocenteDTO> listarDocentes() {
		
		List<DocenteDTO> data = new ArrayList<DocenteDTO>();
		DocenteDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select *"+
							" from tb_docente";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new DocenteDTO();
						obj.setCodigo(rs.getString(1));
						obj.setCod_usuario(rs.getString(2));
						
											
						data.add(obj);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return data;
	}
	
	@Override
	public DocenteDTO buscarCodigoDocente(String cod) {
		

		DocenteDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select *"+
							" from tb_docente where cod_doc=?";
					pstm = cn.prepareStatement(sql);
					
					pstm.setString(1, cod);					
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new DocenteDTO();
						obj.setCodigo(rs.getString(1));
						obj.setCod_usuario(rs.getString(2));
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return obj;
	}
	
	
	
	@Override
	public int insertarDocente(DocenteDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="INSERT INTO tb_docente values(?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getCodigo());
			pstm.setString(2, obj.getCod_usuario());
			
			estado=pstm.executeUpdate();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally{
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int actualizarDocente(DocenteDTO obj) {
		int estado=-1;
		
		/*
		Connection cn=null;
		
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="Update tb_docente set cod_usu=?";
			pstm=cn.prepareStatement(sql);
			//pstm.setString(1, obj.getCodigo());
			pstm.setString(2, obj.getCod_usuario());
			
			estado=pstm.executeUpdate();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally{
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}*/
		return estado;
	}

	@Override
	public int eliminarDocente(String codigo) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm =null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="delete from tb_docente where cod_doc=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, codigo);
			estado=pstm.executeUpdate();
			
		} catch (Exception e) {
				e.printStackTrace();
			}
		finally{
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<InstitucionDTO> reporteInstituciones() {
		List<InstitucionDTO> data = new ArrayList<InstitucionDTO>();
		InstitucionDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select i.nom_ins, i.carac_ins, i.direc_ins, i.fono_ins from tb_institucion i";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new InstitucionDTO();
						obj.setNombre(rs.getString(1));
						obj.setCaracteristicas(rs.getString(2));
						obj.setDireccion(rs.getString(3));
						obj.setTelefono(rs.getString(4));
						data.add(obj);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return data;
			}
	
	
	
	
	@Override
	public List<ReporteActividadDTO> reporteActPorEstado(String estado) 
	{
		List<ReporteActividadDTO> data = new ArrayList<ReporteActividadDTO>();
		ReporteActividadDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql= "select i.nom_ins,a.nom_act, a.des_act, a.fecha_act, a.horainicio_act, "+
			" a.horafin_act, u.nom_usu, e.nom_estado,a.motivo_estado,a.max_vacantes "+
			" from tb_actividad a inner join tb_institucion i on i.cod_ins = a.cod_ins "+
			" inner join tb_estado e on e.cod_estado = a.cod_estado inner join tb_docente d "+
			" on d.cod_doc = a.cod_doc inner join tb_usuario u on d.cod_usu=u.cod_usu Where e.nom_estado = ?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, estado);

			rs = pstm.executeQuery();
			while(rs.next())
			{	
				obj = new ReporteActividadDTO();
				obj.setNom_institucion(rs.getString(1));
				obj.setNom_actividad(rs.getString(2));
				obj.setDesc_act(rs.getString(3));
				obj.setFecha_act(rs.getDate(4));
				obj.setHoraInicio(rs.getString(5));
				obj.setHoraFin(rs.getString(6));
				obj.setNom_docente(rs.getString(7));
				obj.setNom_estado(rs.getString(8));
				obj.setMotivo_estado(rs.getString(9));
				obj.setVacantes(rs.getInt(10));
				data.add(obj);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	@Override
	public List<ReporteActividadDTO> reporteActPorFecha(Date f1,Date f2) 
	{
		List<ReporteActividadDTO> data = new ArrayList<ReporteActividadDTO>();
		ReporteActividadDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql= "select i.nom_ins,a.nom_act, a.des_act, a.fecha_act, a.horainicio_act, "+
					" a.horafin_act, u.nom_usu, e.nom_estado,a.motivo_estado,a.max_vacantes "+
					" from tb_actividad a inner join tb_institucion i on i.cod_ins = a.cod_ins "+
					" inner join tb_estado e on e.cod_estado = a.cod_estado inner join tb_docente d "+
					" on d.cod_doc = a.cod_doc inner join tb_usuario u on d.cod_usu=u.cod_usu Where a.fecha_act between ? and ?";
					
					
			pstm = cn.prepareStatement(sql);
			pstm.setDate(1,f1);
			pstm.setDate(2,f2);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new ReporteActividadDTO();
				obj.setNom_institucion(rs.getString(1));
				obj.setNom_actividad(rs.getString(2));
				obj.setDesc_act(rs.getString(3));
				obj.setFecha_act(rs.getDate(4));
				obj.setHoraInicio(rs.getString(5));
				obj.setHoraFin(rs.getString(6));
				obj.setNom_docente(rs.getString(7));
				obj.setNom_estado(rs.getString(8));
				obj.setMotivo_estado(rs.getString(9));
				obj.setVacantes(rs.getInt(10));
				data.add(obj);
				data.add(obj);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	
	
	
	@Override
	public List<ReporteAlumnoDTO> reportePorCarrera(String carrera) {
		// TODO Auto-generated method stub
		List<ReporteAlumnoDTO> data = new ArrayList<ReporteAlumnoDTO>();
		ReporteAlumnoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql= "select u.cod_usu, u.nom_usu, u.ape_usu, s.seccion, c.carrera, u.fono_usu, u.correo from tb_usuario u inner join tb_alumno a on u.cod_usu=a.cod_usu inner join tb_seccion s on a.cod_seccion=s.cod_seccion inner join tb_carrera c on c.cod_carrera=a.cod_carrera Where c.carrera= ?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, carrera);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				//cod_usu, u.nom_usu, u.ape_usu, s.seccion, carrera. u.fono_usu, u.correo
				obj = new ReporteAlumnoDTO();
				obj.setCodigo(rs.getString(1));
				obj.setNombre(rs.getString(2));
				obj.setApellido(rs.getString(3));
				obj.setSeccion(rs.getString(4));
				obj.setCarrera(rs.getString(5));
				obj.setTelefono(rs.getString(6));
				obj.setCorreo(rs.getString(7));

				data.add(obj);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	@Override
	public List<ReporteAlumnoDTO> reportePorSeccion(String seccion) 
	{
		List<ReporteAlumnoDTO> data = new ArrayList<ReporteAlumnoDTO>();
		ReporteAlumnoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql= "select u.cod_usu, u.nom_usu, u.ape_usu, s.seccion, c.carrera, u.fono_usu, u.correo from tb_usuario u inner join tb_alumno a on u.cod_usu=a.cod_usu inner join tb_seccion s on a.cod_seccion=s.cod_seccion inner join tb_carrera c on c.cod_carrera=a.cod_carrera Where s.seccion= ?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, seccion);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new ReporteAlumnoDTO();
				obj.setCodigo(rs.getString(1));
				obj.setNombre(rs.getString(2));
				obj.setApellido(rs.getString(3));
				obj.setSeccion(rs.getString(4));
				obj.setCarrera(rs.getString(5));
				obj.setTelefono(rs.getString(6));
				obj.setCorreo(rs.getString(7));
				data.add(obj);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}


}
