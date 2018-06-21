package progetto.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Azienda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@OneToOne
	private Responsabile direttore;
	
	@OneToMany
	@JoinColumn(name="azienda_id")
	private List<Allievo> allievi;
	
	@OneToMany
	@JoinColumn(name="azienda_id")
	private List<Centro> centri;
	
	public Azienda() {
		
	}

	public Azienda(String nome, Responsabile direttore) {
		this.nome = nome;
		this.direttore = direttore;
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

	public Responsabile getDirettore() {
		return direttore;
	}

	public void setDirettore(Responsabile direttore) {
		this.direttore = direttore;
	}
	
	
	
}
