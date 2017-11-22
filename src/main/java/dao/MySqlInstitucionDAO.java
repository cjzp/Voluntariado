package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.ComentariosDTO;
import beans.InstitucionDTO;
import beans.InstitucionNombresDTO;
import beans.ReporteComentCalificacionDTO;
import interfaces.InstitucionDAO;
import utils.MySqlDBConexion;

public class MySqlInstitucionDAO implements InstitucionDAO
{
	@Override
	public int registrarComentariosInstitucion(ComentariosDTO obj) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="update tb_institucion set comentarios=?,cod_calificacion=? where cod_ins=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getComentarios());
			pstm.setInt(2, obj.getCalificacion());
			pstm.setInt(3, obj.getCodigo());
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
	public List<ReporteComentCalificacionDTO> listarComentariosCalificacion() {
		List<ReporteComentCalificacionDTO> data = new ArrayList<ReporteComentCalificacionDTO>();
		ReporteComentCalificacionDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select i.nom_ins, i.comentarios, c.calificacion from tb_institucion i inner join tb_calificacion c on i.cod_calificacion=c.cod_calificacion";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new ReporteComentCalificacionDTO();
						obj.setNombre(rs.getString(1));
						obj.setComentarios(rs.getString(2));
						obj.setCalificacion(rs.getString(3));
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
	public List<InstitucionNombresDTO> listarInstitucionNombres() {
		List<InstitucionNombresDTO> data = new ArrayList<InstitucionNombresDTO>();
		InstitucionNombresDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select cod_ins,nom_ins from tb_institucion";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new InstitucionNombresDTO();
						obj.setCodigo(rs.getInt(1));
						obj.setNombre(rs.getString(2));
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
	public ComentariosDTO buscarInstitucionCOMENTARIOS(int cod) {
		
		ComentariosDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			cn = new MySqlDBConexion().getConexion();
			String sql = "SELECT i.cod_ins ,i.comentarios,c.cod_calificacion FROM tb_institucion "+
			" i inner join tb_calificacion c on i.cod_calificacion=c.cod_calificacion WHERE cod_ins=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if(rs.next())
			{
				obj = new ComentariosDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setComentarios(rs.getString(2));
				obj.setCalificacion(rs.getInt(3));		
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
	public InstitucionDTO buscarInstitucion(int cod) {
		
		InstitucionDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			cn = new MySqlDBConexion().getConexion();
			String sql = "SELECT * FROM tb_institucion WHERE cod_ins=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if(rs.next())
			{
				obj = new InstitucionDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setCaracteristicas(rs.getString(3));
				obj.setDireccion(rs.getString(4));
				obj.setTelefono(rs.getString(5));		
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
	public int registrarInstitucion(InstitucionDTO obj) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="INSERT INTO tb_institucion values(null,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getCaracteristicas());
			pstm.setString(3, obj.getDireccion());
			pstm.setString(4, obj.getTelefono());
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
	public List<InstitucionDTO> listarInstituciones() {
		List<InstitucionDTO> data = new ArrayList<InstitucionDTO>();
		InstitucionDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select * from tb_institucion";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new InstitucionDTO();
						obj.setCodigo(rs.getInt(1));
						obj.setNombre(rs.getString(2));
						obj.setCaracteristicas(rs.getString(3));
						obj.setDireccion(rs.getString(4));
						obj.setTelefono(rs.getString(5));
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
	public int actualizarInstitucion(InstitucionDTO obj) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="update tb_institucion set nom_ins=?,carac_ins=?,direc_ins=?,fono_ins=? where cod_ins=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getCaracteristicas());
			pstm.setString(3, obj.getDireccion());
			pstm.setString(4, obj.getTelefono());
			pstm.setInt(5, obj.getCodigo());
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
	public int eliminarInstitucion(int cod) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="delete from tb_institucion where cod_ins=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
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
}
