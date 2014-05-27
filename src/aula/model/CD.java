package aula.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class CD {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String faixas;
	
	@Lob
	private byte[] foto;
	private boolean duplo;
	
	@ManyToOne
	private Artista artista;
	
	@ManyToOne
	private Gravadora gravadora;
	
	@ManyToMany
	private Set<Venda> vendas;

	public CD() {
		vendas = new HashSet<Venda>();
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
	
	public String getFaixas() {
		return faixas;
	}
	
	public void setFaixas(String faixas) {
		this.faixas = faixas;
	}
	
	public byte[] getFoto() {
		return foto;
	}
	
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public boolean isDuplo() {
		return duplo;
	}
	
	public void setDuplo(boolean duplo) {
		this.duplo = duplo;
	}
	
	public Artista getArtista() {
		return artista;
	}
	
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Gravadora getGravadora() {
		return gravadora;
	}
	
	public void setGravadora(Gravadora gravadora) {
		this.gravadora = gravadora;
	}
	
	public Set<Venda> getVendas() {
		return vendas;
	}
	
	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}
}
