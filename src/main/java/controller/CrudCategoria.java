package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;
import utility.Connettore;

public class CrudCategoria implements ICrudCategoria{
Connettore connettore = Connettore.getInstance();
	
	public boolean inserisci (Categoria categoria) {
		Connection conn = connettore.apriConnessione();
		String sql = "INSERT INTO categorie (nomeCategoria) VALUES (?)";
		PreparedStatement ps = null;
		boolean risultatoOp = false;
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, categoria.getNomeCategoria());
			ps.execute();
			risultatoOp=true;
		}catch (SQLException e){
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
		return risultatoOp;
	}

	@Override
	public List<Categoria> leggi() {
		List<Categoria> categorie = new ArrayList<Categoria>();
		Connection conn = connettore.apriConnessione();
		Categoria categoria = null;
		String sql = "select * from categorie";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setNomeCategoria(rs.getString("nomeCategoria"));
				categorie.add(categoria);
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
		return categorie;
	}

	@Override
	public Categoria leggi(int id) {
		Connection conn= connettore.apriConnessione();
		Categoria categoria = null;
		String sql= "select * from categorie where id=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.first()) {
				categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setNomeCategoria(rs.getString("nomeCategoria"));
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
				return categoria;
	}
				

	@Override
	public boolean modifica(Categoria categoria) {
		boolean risultatoOp = false;
		Connection conn = connettore.apriConnessione();
		String sql = "update categoria set nomeCategoria=? where id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, categoria.getNomeCategoria());
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
		String sql = "delete from categorie where id = ?";
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
