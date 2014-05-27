package aula.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artista {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private Boolean banda;
	private String pais;
	
	@OneToMany(mappedBy="artista")
	private Set<CD> cds;
	
	public Artista() {
		cds = new HashSet<CD>();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Boolean getBanda() {
		return banda;
	}
	
	public void setBanda(Boolean banda) {
		this.banda = banda;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set<CD> getCds() {
		return cds;
	}
	
	public void setCds(Set<CD> cds) {
		this.cds = cds;
	}
}
