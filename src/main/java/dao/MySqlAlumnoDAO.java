package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import beans.AlumnoDTO;
import interfaces.AlumnoDAO;
import utils.MySqlDBConexion;


public class MySqlAlumnoDAO implements AlumnoDAO {

	@Override
	public List<AlumnoDTO> listarAlumnos() {
		
		List<AlumnoDTO> data = new ArrayList<AlumnoDTO>();
		AlumnoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select *"+
							" from tb_alumno";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new AlumnoDTO();
						obj.setCodigo(rs.getString(1));	
						obj.setCodigo_usuario(rs.getString(2));									
						obj.setCarrera(rs.getInt(3));
						obj.setSeccion(rs.getInt(4));					
						obj.setCod_actividad(rs.getInt(5));
						
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
	public AlumnoDTO buscarCodigoAlumno (String cod) {
		
		AlumnoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select *"+
							" from tb_alumno where cod_alu=?";
					pstm = cn.prepareStatement(sql);
					
					pstm.setString(1, cod);					
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new AlumnoDTO();
						obj.setCodigo(rs.getString(1));	
						obj.setCodigo_usuario(rs.getString(2));									
						obj.setCarrera(rs.getInt(3));
						obj.setSeccion(rs.getInt(4));					
						obj.setCod_actividad(rs.getInt(5));
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return obj;
	}

	@Override
	public int insertarAlumno(AlumnoDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="INSERT INTO tb_alumno values(?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getCodigo());
			pstm.setString(2, obj.getCodigo_usuario());			
			pstm.setInt(3, obj.getCarrera());
			pstm.setInt(4, obj.getSeccion());
			pstm.setInt(5, obj.getCod_actividad());
		
			
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
	public int actualizarAlumno(AlumnoDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			//Update tb_alumno set cod_alu=?,cod_usu=?,cod_carrera=?,cod_seccion=?,cod_act=?";
			String sql="Update tb_alumno set cod_usu=?,cod_carrera=?,cod_seccion=?,cod_act=? where cod_alu=?";
			pstm=cn.prepareStatement(sql);
		
			//pstm.setString(1, obj.getCodigo());
			pstm.setString(1, obj.getCodigo_usuario());
			pstm.setInt(2, obj.getCarrera());
			pstm.setInt(3, obj.getSeccion());
			pstm.setInt(4, obj.getCod_actividad());
			
			pstm.setString(5, obj.getCodigo());
	
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
	public int eliminarAlumno(String codigo) {
		
				
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm =null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="delete from tb_alumno where cod_alu=?";
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
	public int anotarActividad(String codAlu, int codAct) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn= new MySqlDBConexion().getConexion();
			
			String sql="Update tb_alumno set cod_act=? where cod_alu=?";
			pstm=cn.prepareStatement(sql);
		
			
			pstm.setInt(1, codAct);
			pstm.setString(2, codAlu);
			
	
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



}
