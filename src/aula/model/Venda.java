package aula.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date dataVenda;
	
	@ManyToMany(mappedBy="vendas")
	private Set<CD> cds;
	
	
	public Venda() {
		cds = new HashSet<CD>();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public Set<CD> getCds() {
		return cds;
	}
	
	public void setCds(Set<CD> cds) {
		this.cds = cds;
	}
}
