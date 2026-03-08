package model;

import java.util.Objects;

public class Marca {
	private int id;
	private String nomeMarca;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getNomeMarca() {
		return nomeMarca;
	}
	
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca= nomeMarca;
	}
	
	public Marca() {
	}
	
	public Marca(int id, String nomeMarca) {
		this.id=id;
		this.nomeMarca=nomeMarca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomeMarca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		return id == other.id && Objects.equals(nomeMarca, other.nomeMarca);
	}
	
	public String toString() {
		return "Marca [id=" + id + ",nomeMarca=" + nomeMarca + "]";
	}
}
