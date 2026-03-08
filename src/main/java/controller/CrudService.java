package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;
import utility.Connettore;

public class CrudService implements ICrudService{
	Connettore connettore = Connettore.getInstance();
	@Override
	public boolean inserisci(Prodotto prodotto, int idCategoria, int idMarca) {
		boolean risultatoOp = false;
		Connection conn = connettore.apriConnessione();
		String sql = "insert into prodotti (nomeProdotto,prezzo,dataProduzione,quantita, id_categorie, id_marche) values (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, prodotto.getNomeProdotto());
			ps.setDouble(2, prodotto.getPrezzo());
			ps.setDate(3, prodotto.getDataProduzione());
			ps.setInt(4, prodotto.getQuantita());
			ps.setInt(5, idCategoria);
			ps.setInt(6, idMarca);
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
			}
		}
		return risultatoOp;
	}
	

	@Override
	public List<DtoProdotto> leggi() {
		List<DtoProdotto> prodotti = new ArrayList<>();
		Connection conn = connettore.apriConnessione();
		DtoProdotto prodotto = null;
		String sql = "select * from prodottiTotali ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				prodotto = new DtoProdotto();
				prodotto.setId(rs.getInt("id_prodotto"));
				prodotto.setNomeProdotto(rs.getString("nomeProdotto"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				prodotto.setDataProduzione(rs.getDate("dataProduzione"));
				prodotto.setQuantita(rs.getInt("quantita"));
				prodotto.setId_categorie(rs.getInt("id_categoria"));
				prodotto.setId_marche(rs.getInt("id_marca"));

			    prodotto.setNomeCategoria(rs.getString("nomeCategoria")); // fai join con tabella categorie
			    prodotto.setNomeMarca(rs.getString("nomeMarca"));  
				prodotti.add(prodotto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prodotti;
	}

	@Override
	public Prodotto leggi(int id) {
		Connection conn = connettore.apriConnessione();
		Prodotto prodotto = null;
		String sql = "select * from prodotti where id=?";
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.first()) {
				prodotto = new Prodotto();
				prodotto.setId(rs.getInt("id"));
				prodotto.setNomeProdotto(rs.getString("nomeProdotto"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				prodotto.setDataProduzione(rs.getDate("dataProduzione"));
				prodotto.setQuantita(rs.getInt("quantita"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prodotto;
		
	}

	@Override
	public boolean modifica(Prodotto prodotto) {
		boolean risultatoOp = false;
		Connection conn = connettore.apriConnessione();
		String sql = "update prodotti set nomeProdotto=?, prezzo=?, dataProduzione=?, quantita=?, id_categorie=?, id_marche=? where id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, prodotto.getNomeProdotto());
			ps.setDouble(2, prodotto.getPrezzo());
			ps.setDate(3, prodotto.getDataProduzione());
			ps.setInt(4, prodotto.getQuantita());
			ps.setInt(5, prodotto.getId_categorie());
			ps.setInt(6, prodotto.getId_marche());
			ps.setInt(7, prodotto.getId());
			ps.execute();
			risultatoOp = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally { // è il blocco che viene eseguito a PRESCINDERE della cattura dell'eccezione (chiude la connesione)
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
		String sql = "delete from prodotti where id = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			risultatoOp = true;
		} catch (SQLException e){
			e.printStackTrace();
		} finally { 
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return risultatoOp;
	}

}