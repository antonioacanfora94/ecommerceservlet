package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;
import utility.Connettore;

public class CrudMarca implements ICrudMarca{
	Connettore connettore = Connettore.getInstance();

	@Override
	public boolean inserisci(Marca marca) {
		Connection conn = connettore.apriConnessione();
		String sql = "INSERT INTO marche (nomeMarca) VALUES (?)";
		PreparedStatement ps = null;
		boolean risultatoOp = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, marca.getNomeMarca());
			ps.execute();
			risultatoOp=true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally { 
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					ps.close();
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return risultatoOp;
	}

	@Override
	public List<Marca> leggi() {
		List<Marca> marche = new ArrayList<Marca>();
		Connection conn = connettore.apriConnessione();
		Marca marca = null;
		String sql = "select * from marche";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				marca = new Marca();
				marca.setId(rs.getInt("id"));
				marca.setNomeMarca(rs.getString("nomeMarca"));
				marche.add(marca);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return marche;
	}

	@Override
	public Marca leggi(int id) {
		Connection conn= connettore.apriConnessione();
		Marca marca = null;
		String sql= "select * from marche where id=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.first()) {
				marca = new Marca();
				marca.setId(rs.getInt("id"));
				marca.setNomeMarca(rs.getString("nomeMarca"));
			}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					ps.close();
					conn.close();	
				}catch (SQLException e) {
					e.printStackTrace();
			}
		}
				return marca;
	}

	@Override
	public boolean modifica(Marca marca) {
		boolean risultatoOp = false;
		Connection conn = connettore.apriConnessione();
		String sql = "update marche set nomeMarca=? where id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, marca.getNomeMarca());
			ps.execute();
			risultatoOp = true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return risultatoOp;
	}

	@Override
	public boolean rimuovi(int id) {
		boolean risultatoOp = false;
		Connection conn = connettore.apriConnessione();
		String sql = "delete from marche where id = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			risultatoOp = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return risultatoOp;
	}
	
}
