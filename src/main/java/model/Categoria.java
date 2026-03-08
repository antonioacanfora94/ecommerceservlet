package model;

import java.util.Objects;

public class Categoria {
	private int id;
	private String nomeCategoria;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria=nomeCategoria;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nomeCategoria);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return id == other.id && Objects.equals(nomeCategoria, other.nomeCategoria);
	}
	
	public String toString() {
		return "Categoria [id=,"+ id + ", nomeCategoria="+ nomeCategoria + "]";
	}
}
