package progetto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progetto.model.Attività;
import progetto.model.Centro;
import progetto.repository.AttivitàRepository;

@Transactional
@Service
public class AttivitàService {
	
	@Autowired
	private AttivitàRepository attivitàRepository; 
	
	public Attività save(Attività attività) {
		return this.attivitàRepository.save(attività);
	}

	public List<Attività> findAll() {
		return (List<Attività>) this.attivitàRepository.findAll();
	}
	
	public Attività findById(Long id) {
		Optional<Attività> attivita = this.attivitàRepository.findById(id);
		if (attivita.isPresent()) 
			return attivita.get();
		else
			return null;
	}
	
	public Attività findByNome(String nome) {
		return this.attivitàRepository.findByNome(nome);
	}
	
	public List<Attività> findByNomeAndCentro(String nome,Centro centro) {
		List<Attività> listaAttivita = this.attivitàRepository.findByNomeAndCentro(nome,centro);
		return listaAttivita;
	}

	public boolean alreadyExists(Attività attivita) {
		List<Attività> listaAttivita = this.attivitàRepository.findByNomeAndCentro(attivita.getNome(), attivita.getCentro());
		if (listaAttivita.size() > 0)
			return true;
		else 
			return false;
	}

	public void uploadString(String nome) {
	
	}	

}
