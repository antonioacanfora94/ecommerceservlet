package controller;

import java.util.List;

import model.Marca;

public interface ICrudMarca {
	public boolean inserisci(Marca marca);
	public List<Marca> leggi();
	public Marca leggi(int id);
	public boolean modifica (Marca marca);
	public boolean rimuovi(int id);
}
