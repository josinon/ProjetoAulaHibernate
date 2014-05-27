package aula.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gravadora {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy="gravadora")
	private Set<CD> cds;
	
	public Gravadora() {
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
	
	public Set<CD> getCds() {
		return cds;
	}
	
	public void setCds(Set<CD> cds) {
		this.cds = cds;
	}

}
