package controller;

import java.util.List;

import model.Categoria;

public interface ICrudCategoria {
	
	public boolean inserisci(Categoria categoria);
	public List<Categoria> leggi();
	public Categoria leggi(int id);
	public boolean modifica (Categoria categoria);
	public boolean rimuovi(int id);
	}

