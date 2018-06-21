package progetto.model;

import java.util.Date;

import java.util.LinkedList;
import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Allievo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable=false)
	private String nome;
	

	@Column(nullable=false)
	private String cognome;
	
	@Column
	private String email;
	
	@Column
	@DateTimeFormat(iso=ISO.DATE)
	private Date nato;
	
	@Column(nullable=false)
	private String luogoNascita;
	
	
	@ManyToMany(mappedBy = "allievi")
	private List<Attività> corsi;
	
	public Allievo() {
		
	}

	public Allievo(String nome, String cognome, String email, Date nato, String città) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.nato = nato;
		this.luogoNascita = città;
		this.corsi = new LinkedList<>();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNato() {
		return nato;
	}

	public void setNato(Date nato) {
		this.nato = nato;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String città) {
		this.luogoNascita = città;
	}

	

	public List<Attività> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Attività> corsi) {
		this.corsi = corsi;
	} 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Allievo other = (Allievo) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
