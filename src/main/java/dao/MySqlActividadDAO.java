package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.ActividadDTO;
import interfaces.ActividadDAO;
import utils.MySqlDBConexion;

public class MySqlActividadDAO implements ActividadDAO
{
	@Override
	public int registrarActividad(ActividadDTO obj) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="INSERT INTO tb_actividad values(null,?,?,?,?,?,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);			
			pstm.setInt(1,obj.getCod_institucion()); 
			pstm.setString(2, obj.getNombre());
			pstm.setString(3, obj.getDescripcion());
			pstm.setDate(4, obj.getFecha());
			pstm.setString(5, obj.getHoraInicio());
			pstm.setString(6, obj.getHoraFin());
			pstm.setString(7, obj.getCod_docente());
			pstm.setInt(8, obj.getCodEstado());
			pstm.setString(9, obj.getMotivoEstado());
			
			pstm.setInt(10, obj.getVacantesMax());
			pstm.setInt(11, obj.getVacantesMin());
			estado=pstm.executeUpdate();
			//JOptionPane.showMessageDialog(null, "DATOS REGISTRADOS!: "+estado);
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
	public List<ActividadDTO> listarActividades()
	{
		List<ActividadDTO> data = new ArrayList<ActividadDTO>();
		ActividadDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql="select a.cod_act, i.nom_ins,a.nom_act, a.des_act, a.fecha_act, a.horainicio_act, a.horafin_act, Concat(u.nom_usu,' ',u.ape_usu) as nombredocente, e.nom_estado,a.motivo_estado,"+
							" a.max_vacantes, a.min_vacantes from tb_actividad a inner join tb_institucion i on i.cod_ins = a.cod_ins inner join tb_estado e"+
							" on e.cod_estado = a.cod_estado inner join tb_docente d on d.cod_doc = a.cod_doc inner join tb_usuario u on u.cod_usu = d.cod_usu";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new ActividadDTO();
						obj.setCodigo(rs.getInt(1));
						obj.setNom_institucion(rs.getString(2));
						obj.setNombre(rs.getString(3));
						obj.setDescripcion(rs.getString(4));
						obj.setFecha(rs.getDate(5));
						obj.setHoraInicio(rs.getString(6));
						obj.setHoraFin(rs.getString(7));
						obj.setNom_usuario(rs.getString(8));
						obj.setNombreEstado(rs.getString(9));
						obj.setMotivoEstado(rs.getString(10));
						obj.setVacantesMax(rs.getInt(11));
						obj.setVacantesMin(rs.getInt(12));
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
	public List<ActividadDTO> listarActividadesVolu()
	{
		List<ActividadDTO> data = new ArrayList<ActividadDTO>();
		ActividadDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql="select a.cod_act, i.nom_ins,a.nom_act, a.des_act, a.fecha_act, a.horainicio_act, a.horafin_act, Concat(u.nom_usu,' ',u.ape_usu) as nombredocente, e.nom_estado,a.motivo_estado,"+
							" a.max_vacantes, a.min_vacantes from tb_actividad a inner join tb_institucion i on i.cod_ins = a.cod_ins inner join tb_estado e"+
							" on e.cod_estado = a.cod_estado inner join tb_docente d on d.cod_doc = a.cod_doc inner join tb_usuario u on u.cod_usu = d.cod_usu Where e.nom_estado = 'Aprobado'";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new ActividadDTO();
						obj.setCodigo(rs.getInt(1));
						obj.setNom_institucion(rs.getString(2));
						obj.setNombre(rs.getString(3));
						obj.setDescripcion(rs.getString(4));
						obj.setFecha(rs.getDate(5));
						obj.setHoraInicio(rs.getString(6));
						obj.setHoraFin(rs.getString(7));
						obj.setNom_usuario(rs.getString(8));
						obj.setNombreEstado(rs.getString(9));
						obj.setMotivoEstado(rs.getString(10));
						obj.setVacantesMax(rs.getInt(11));
						obj.setVacantesMin(rs.getInt(12));
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
	public ActividadDTO buscarActividad(int cod) 
	{
		ActividadDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			cn = new MySqlDBConexion().getConexion();
			String sql = "SELECT * FROM tb_actividad WHERE cod_act=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if(rs.next())
			{
				obj = new ActividadDTO();
				obj.setCodigo(rs.getInt(1));
				//obj.setNom_institucion(rs.getString(2)); //??
				obj.setCod_institucion(rs.getInt(2));
				obj.setNombre(rs.getString(3));
				obj.setDescripcion(rs.getString(4));
				obj.setFecha(rs.getDate(5));
				obj.setHoraInicio(rs.getString(6));
				obj.setHoraFin(rs.getString(7));
				obj.setCod_docente(rs.getString(8));
				//obj.setNom_usuario(rs.getString(8)); //??				
				obj.setCodEstado(rs.getInt(9));
				//obj.setNombreEstado(rs.getString(9)); //??
				obj.setMotivoEstado(rs.getString(10));
				
				obj.setVacantesMax(rs.getInt(11));
				obj.setVacantesMin(rs.getInt(12));
				
			}
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}finally
		{
			try{
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
				
			}catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
		
		return obj;
	}

	@Override
	public int actualizarActividad(ActividadDTO obj)
	{
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="Update tb_actividad set cod_ins=?,nom_act=?,des_act=?,fecha_act=?,horainicio_act=?,horafin_act=?,cod_doc=?,cod_estado=?,motivo_estado=?,min_vacantes=?,max_vacantes=? where cod_act=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, obj.getCod_institucion());
			pstm.setString(2, obj.getNombre());
			pstm.setString(3, obj.getDescripcion());
			pstm.setDate(4, obj.getFecha());
			pstm.setString(5,obj.getHoraInicio());
			pstm.setString(6,obj.getHoraFin());
			pstm.setString(7, obj.getCod_docente());
			pstm.setInt(8, obj.getCodEstado());
			pstm.setString(9, obj.getMotivoEstado());
			pstm.setInt(10, obj.getCodigo());
			
			pstm.setInt(11, obj.getVacantesMax());
			pstm.setInt(12, obj.getVacantesMin());
			
			estado=pstm.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS!: "+estado);
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
	public int eliminarActividad(int cod) 
	{
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm =null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="delete from tb_actividad where cod_act=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado=pstm.executeUpdate();
			//JOptionPane.showMessageDialog(null, "SE ELIMIN� LOS DATOS!: "+estado);
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
	public List<ActividadDTO> buscarPorEstado(String nombreEstado) 
	{
		List<ActividadDTO> data = new ArrayList<ActividadDTO>();
		ActividadDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql="select a.cod_act, i.nom_ins,a.nom_act, a.des_act, a.fecha_act, a.horainicio_act, a.horafin_act, Concat(u.nom_usu,' ',u.ape_usu) as nombredocente, e.nom_estado,a.motivo_estado,"+
					" a.max_vacantes, a.min_vacantes from tb_actividad a inner join tb_institucion i on i.cod_ins = a.cod_ins inner join tb_estado e"+
					" on e.cod_estado = a.cod_estado inner join tb_docente d on d.cod_doc = a.cod_doc inner join tb_usuario u on u.cod_usu = d.cod_usu Where e.nom_estado = ?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nombreEstado);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new ActividadDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNom_institucion(rs.getString(2));
				obj.setNombre(rs.getString(3));
				obj.setDescripcion(rs.getString(4));
				obj.setFecha(rs.getDate(5));
				obj.setHoraInicio(rs.getString(6));
				obj.setHoraFin(rs.getString(7));
				obj.setNom_usuario(rs.getString(8));
				obj.setNombreEstado(rs.getString(9));
				obj.setMotivoEstado(rs.getString(10));
				obj.setVacantesMax(rs.getInt(11));
				obj.setVacantesMin(rs.getInt(12));
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
	public List<ActividadDTO> buscarPorFecha(Date fecha) 
	{
		List<ActividadDTO> data = new ArrayList<ActividadDTO>();
		ActividadDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql="select a.cod_act, i.nom_ins,a.nom_act, a.des_act, a.fecha_act, a.horainicio_act, a.horafin_act, Concat(u.nom_usu,' ',u.ape_usu) as nombredocente, e.nom_estado,a.motivo_estado,"+
					" a.max_vacantes, a.min_vacantes from tb_actividad a inner join tb_institucion i on i.cod_ins = a.cod_ins inner join tb_estado e"+
					" on e.cod_estado = a.cod_estado inner join tb_docente d on d.cod_doc = a.cod_doc inner join tb_usuario u on u.cod_usu = d.cod_usu Where a.fecha_act = ?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setDate(1, fecha);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new ActividadDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNom_institucion(rs.getString(2));
				obj.setNombre(rs.getString(3));
				obj.setDescripcion(rs.getString(4));
				obj.setFecha(rs.getDate(5));
				obj.setHoraInicio(rs.getString(6));
				obj.setHoraFin(rs.getString(7));
				obj.setNom_usuario(rs.getString(8));
				obj.setNombreEstado(rs.getString(9));
				obj.setMotivoEstado(rs.getString(10));
				obj.setVacantesMax(rs.getInt(11));
				obj.setVacantesMin(rs.getInt(12));
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
	public int cambiarEstado(int codAct, int codEst) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="Update tb_actividad set cod_estado=? where cod_act=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codEst);
			pstm.setInt(2, codAct);
			
			
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
	public int alumnosAnotados(int codAct) {
		
		int num=0;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			cn = new MySqlDBConexion().getConexion();
			String sql = "select Count(cod_alu) from tb_alumno where cod_act=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codAct);
			rs = pstm.executeQuery();
			if(rs.next())
			{
				num = rs.getInt(1);
				
			}
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}finally
		{
			try{
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
				
			}catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
		
		
		return num;
	}
}
