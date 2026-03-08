package model;

import java.sql.Date;
import java.util.Objects;

public class Prodotto {
	private int id;
	private String nomeProdotto;
	private double prezzo;
	private Date dataProduzione;
	private int quantita;
	private int id_marche;
	private int id_categorie;
	
	
	public int getId_marche() {
		return id_marche;
	}
	public void setId_marche(int id_marche) {
		this.id_marche = id_marche;
	}
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Date getDataProduzione() {
		return dataProduzione;
	}
	public void setDataProduzione(Date dataProduzione) {
		this.dataProduzione = dataProduzione;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public Prodotto() {
		
	}
	public Prodotto(int id, String nomeProdotto, String marca, String categoria, double prezzo, Date dataProduzione, int quantita, int id_categorie, int id_marche) {
		this.id = id;
		this.nomeProdotto = nomeProdotto;
		this.prezzo = prezzo;
		this.dataProduzione = dataProduzione;
		this.quantita = quantita;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataProduzione, id, nomeProdotto, prezzo, quantita);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		return Objects.equals(dataProduzione, other.dataProduzione) && id == other.id
				&& Objects.equals(nomeProdotto, other.nomeProdotto)
				&& Double.doubleToLongBits(prezzo) == Double.doubleToLongBits(other.prezzo)
				&& quantita == other.quantita;
	}
	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nomeProdotto=" + nomeProdotto + ", prezzo=" + prezzo + ", dataProduzione="
				+ dataProduzione + ", quantita=" + quantita + "]";
	}
	
}
