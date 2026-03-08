package controller;

import java.util.List;

import model.*;

public interface ICrudService {
	public boolean inserisci(Prodotto prodotto, int idCategoria, int idMarca);
	public List<DtoProdotto> leggi();
	public Prodotto leggi(int id);
	public boolean modifica(Prodotto prodotto);
	public boolean rimuovi(int id);
}