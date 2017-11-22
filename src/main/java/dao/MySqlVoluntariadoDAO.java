package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.VoluntariadoDTO;
import interfaces.VoluntariadoDAO;
import utils.MySqlDBConexion;

public class MySqlVoluntariadoDAO implements VoluntariadoDAO
{
	@Override
	public int registrarVoluntariado(VoluntariadoDTO obj) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="INSERT INTO tb_voluntariado values(null,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getCodigoAlumno());
			pstm.setInt(2, obj.getCodigoActividad());
			pstm.setString(3, obj.getAsistencia());
			pstm.setString(4, obj.getJustificacion());
			pstm.setInt(5, obj.getHoras());
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
	public List<VoluntariadoDTO> listarVoluntarios()
	{
		List<VoluntariadoDTO> data = new ArrayList<VoluntariadoDTO>();
		VoluntariadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select v.cod_vol, ac.nom_act,concat (u.nom_usu,' ',u.ape_usu) as nombrealumno, v.asistencia, v.justificacion, v.horas from tb_voluntariado v"+
					" inner join tb_alumno a on a.cod_alu = v.cod_alu inner join tb_actividad ac"+
					" on ac.cod_act = v.cod_act inner join tb_usuario u on u.cod_usu = a.cod_usu";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new VoluntariadoDTO();
						obj.setCodigo(rs.getInt(1));
						obj.setNomAlumno(rs.getString(2));
						obj.setNomActividad(rs.getString(3));
						obj.setAsistencia(rs.getString(4));
						obj.setJustificacion(rs.getString(5));
						obj.setHoras(rs.getInt(6));
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
	public VoluntariadoDTO buscarVoluntariado(int cod) 
	{
		VoluntariadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			cn = new MySqlDBConexion().getConexion();
			String sql = "SELECT * FROM tb_voluntariado WHERE cod_vol=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if(rs.next())
			{
				obj = new VoluntariadoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNomAlumno(rs.getString(2));
				obj.setNomActividad(rs.getString(3));
				obj.setAsistencia(rs.getString(4));
				obj.setJustificacion(rs.getString(5));
				obj.setHoras(rs.getInt(6));
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
	public int actualizarVoluntariado(VoluntariadoDTO obj)
	{
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="Update tb_voluntariado set cod_alu=?,cod_act=?,asistencia=?,justificacion=?,horas=? where cod_vol=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getCodigoAlumno());
			pstm.setInt(2, obj.getCodigoActividad());
			pstm.setString(3, obj.getAsistencia());
			pstm.setString(4, obj.getJustificacion());
			pstm.setInt(5, obj.getHoras());
			pstm.setInt(6, obj.getCodigo());
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
	public List<VoluntariadoDTO> buscarPorActividad(String nombreActividad) 
	{
		List<VoluntariadoDTO> data = new ArrayList<VoluntariadoDTO>();
		VoluntariadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql= "select v.cod_vol, ac.nom_act,concat (u.nom_usu,' ',u.ape_usu) as nombrealumno, v.asistencia, v.justificacion, v.horas from tb_voluntariado v"+
					" inner join tb_alumno a on a.cod_alu = v.cod_alu inner join tb_actividad ac"+
					" on ac.cod_act = v.cod_act inner join tb_usuario u on u.cod_usu = a.cod_usu Where ac.nom_act = ?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nombreActividad);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new VoluntariadoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNomActividad(rs.getString(2));
				obj.setNomAlumno(rs.getString(3));
				obj.setAsistencia(rs.getString(4));
				obj.setJustificacion(rs.getString(5));
				obj.setHoras(rs.getInt(6));
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
	public List<VoluntariadoDTO> buscarPorAlumno(String codigoAlumno) 
	{
		List<VoluntariadoDTO> data = new ArrayList<VoluntariadoDTO>();
		VoluntariadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql= "select v.cod_vol, ac.nom_act,concat (u.nom_usu,' ',u.ape_usu) as nombrealumno, v.asistencia, v.justificacion, v.horas from tb_voluntariado v"+
					" inner join tb_alumno a on a.cod_alu = v.cod_alu inner join tb_actividad ac"+
					" on ac.cod_act = v.cod_act inner join tb_usuario u on u.cod_usu = a.cod_usu Where v.cod_alu = ?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, codigoAlumno);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new VoluntariadoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNomAlumno(rs.getString(2));
				obj.setNomActividad(rs.getString(3));
				obj.setAsistencia(rs.getString(4));
				obj.setJustificacion(rs.getString(5));
				obj.setHoras(rs.getInt(6));
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
	public List<VoluntariadoDTO> controlDeAlumno(String codigoAlumno) 
	{
		List<VoluntariadoDTO> data = new ArrayList<VoluntariadoDTO>();
		VoluntariadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql= "select v.cod_vol, ac.nom_act, v.horas from tb_voluntariado v"+
					" inner join tb_alumno a on a.cod_alu = v.cod_alu inner join tb_actividad ac"+
					" on ac.cod_act = v.cod_act inner join tb_usuario u on u.cod_usu = a.cod_usu Where v.cod_alu = ?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, codigoAlumno);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new VoluntariadoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNomActividad(rs.getString(2));
				obj.setHoras(rs.getInt(3));
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
	public List<VoluntariadoDTO> buscarPorSeccion(String seccion) 
	{
		List<VoluntariadoDTO> data = new ArrayList<VoluntariadoDTO>();
		VoluntariadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql= "select v.cod_vol, a.seccion, a.nom_alu, ac.nom_act"+
					" from tb_voluntariado v inner join tb_alumno a on a.cod_alu = v.cod_alu inner join tb_actividad ac"+
					" on ac.cod_act = v.cod_act Where a.seccion= ?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, seccion);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new VoluntariadoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setJustificacion(rs.getString(2));
				obj.setNomAlumno(rs.getString(3));
				obj.setNomActividad(rs.getString(4));

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
	public List<VoluntariadoDTO> buscarHorasAlumno(String codigoAlumno) 
	{		
		List<VoluntariadoDTO> data = new ArrayList<VoluntariadoDTO>();
		VoluntariadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			cn = new MySqlDBConexion().getConexion();
			String sql = "SELECT a.nom_usu, SUM(v.horas)FROM tb_voluntariado v inner join tb_alumno a on "+
					"a.cod_alu=v.cod_alu WHERE v.cod_alu=?";
					
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, codigoAlumno);

			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new VoluntariadoDTO();
				obj.setNomAlumno(rs.getString(1));
				obj.setHoras(rs.getInt(2));
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
	public int eliminarVoluntariado(int cod) 
	{
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm =null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="delete from tb_voluntariado where cod_vol=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado=pstm.executeUpdate();
			//JOptionPane.showMessageDialog(null, "SE ELIMINÓ LOS DATOS!: "+estado);
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
	
}
