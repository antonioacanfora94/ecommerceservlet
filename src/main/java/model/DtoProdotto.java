package model;

import java.sql.Date;

public class DtoProdotto {
	private int id;
    private String nomeProdotto;
    private double prezzo;
    private Date dataProduzione;
    private int quantita;
    private String nomeCategoria;
    private String nomeMarca;
    int id_marche;
    int id_categorie;
    
    
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

	public DtoProdotto() {
    	
    }
    
    public DtoProdotto(int id, String nomeProdotto, double prezzo, Date dataProduzione, int quantita, String nomeCategoria, String nomeMarca, int id_marche, int id_categorie) {
    	this.id=id;
    	this.nomeProdotto=nomeProdotto;
    	this.prezzo=prezzo;
    	this.dataProduzione=dataProduzione;
    	this.quantita=quantita;
    	this.nomeCategoria=nomeCategoria;
    	this.nomeMarca=nomeMarca;
    	this.id_categorie=id_categorie;
    	this.id_marche=id_marche;
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
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public String getNomeMarca() {
		return nomeMarca;
	}
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
}
