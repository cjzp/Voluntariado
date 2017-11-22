package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MySqlDBConexion;


public class MySqlUsuarioDAO implements UsuarioDAO
{
	@Override
	public UsuarioDTO iniciarSesion(String login) 
	{
		UsuarioDTO em = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			cn = new MySqlDBConexion().getConexion();
			String sql = "Select * from tb_usuario WHERE login_usu=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1,  login);
			rs = pstm.executeQuery();
			if(rs.next())
			{
				em = new UsuarioDTO();
				em.setCodigo(rs.getString(1));
				em.setNombre(rs.getString(2));
				em.setApellido(rs.getString(3));
				em.setTelefono(rs.getString(4));
				em.setCorreo(rs.getString(5));
				em.setLogin(rs.getString(6));
				em.setPassword(rs.getString(7));
				em.setEstado(rs.getInt(8));
			}
				
		}catch(SQLException ex)
		{
			ex.printStackTrace();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return em;
	}

	@Override
	public int insertarUsuario(UsuarioDTO obj) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		

		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="INSERT INTO tb_usuario values(?,?,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getCodigo());
			pstm.setString(2, obj.getNombre());
			pstm.setString(3, obj.getApellido());
			pstm.setString(4, obj.getTelefono());
			pstm.setString(5, obj.getCorreo());
			pstm.setString(6, obj.getLogin());
			pstm.setString(7, obj.getPassword());
			pstm.setInt(8, obj.getEstado());
		
			
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
	public List<UsuarioDTO> listarUsuarios() {
		
		List<UsuarioDTO> data = new ArrayList<UsuarioDTO>();
		UsuarioDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select *"+
							" from tb_usuario";
					pstm = cn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new UsuarioDTO();
						obj.setCodigo(rs.getString(1));	
						obj.setNombre(rs.getString(2));
						obj.setApellido(rs.getString(3));
						obj.setTelefono(rs.getString(4));
						obj.setCorreo(rs.getString(5));
						obj.setLogin(rs.getString(6));
						obj.setPassword(rs.getString(7));
						obj.setEstado(rs.getInt(8));
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
	public UsuarioDTO buscarCodigoUsuario(String cod) {
		
	
		UsuarioDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				try {
					cn = new MySqlDBConexion().getConexion();
					String sql= "select *"+
							" from tb_usuario where cod_usu=?";
					pstm = cn.prepareStatement(sql);
					
					pstm.setString(1, cod);					
					rs = pstm.executeQuery();
					while (rs.next()){
						obj = new UsuarioDTO();
						obj.setCodigo(rs.getString(1));	
						obj.setNombre(rs.getString(2));
						obj.setApellido(rs.getString(3));
						obj.setTelefono(rs.getString(4));
						obj.setCorreo(rs.getString(5));
						obj.setLogin(rs.getString(6));
						obj.setPassword(rs.getString(7));
						obj.setEstado(rs.getInt(8));
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return obj;
	}



	@Override
	public int actualizarUsuario(UsuarioDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		

		try {
			cn= new MySqlDBConexion().getConexion();
			//Update tb_usuario set cod_usu=?,nom_usu=?,ape_usu=?,fono_usu=?, correo=?,login_usu=?,pass_usu=?,cod_estado=?"
			String sql="Update tb_usuario set nom_usu=?,ape_usu=?,fono_usu=?, correo=?,login_usu=?,pass_usu=?,cod_estado=? where cod_usu=?";
			pstm=cn.prepareStatement(sql);
			//pstm.setString(1, obj.getCodigo());
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getTelefono());
			pstm.setString(4, obj.getCorreo());
			pstm.setString(5, obj.getLogin());
			pstm.setString(6, obj.getPassword());
			pstm.setInt(7, obj.getEstado());
			
			pstm.setString(8, obj.getCodigo());
	
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
	public int eliminarUsuario(String codigo) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm =null;
		try {
			cn= new MySqlDBConexion().getConexion();
			String sql="delete from tb_usuario where cod_usu=?";
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
	public void habilitarUsuario(String codigo,boolean habilitado) {
		
		Connection cn=null;
		PreparedStatement pstm=null;
		
		String estado="10"; 		
		if(!habilitado)
			estado = "11";

		try {
			cn= new MySqlDBConexion().getConexion();
		
			String sql="Update tb_usuario set cod_estado=? where cod_usu=?";
			pstm=cn.prepareStatement(sql);
			
			pstm.setString(1, estado);
			pstm.setString(2, codigo);
			
	
			pstm.executeUpdate();
			
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
		
	}

	@Override
	public void cambiarPass(String codigo,String nuevoPass) {
		
		Connection cn=null;
		PreparedStatement pstm=null;
		

		try {
			cn= new MySqlDBConexion().getConexion();
			
			String sql="Update tb_usuario set pass_usu=? where cod_usu=?";
			pstm=cn.prepareStatement(sql);
			
			pstm.setString(1, nuevoPass);
			pstm.setString(2, codigo);
			
	
			pstm.executeUpdate();
			
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
		
		
	}
	
}
