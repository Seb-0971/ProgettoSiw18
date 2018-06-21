package progetto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import progetto.model.Allievo;
import progetto.repository.AllievoRepository;

@Transactional
@Service
public class AllievoService  {
	
	@Autowired
	private AllievoRepository allievoRepository; 
	
	public Allievo save(Allievo allievo) {
		return this.allievoRepository.save(allievo);
	}

	public List<Allievo> findAll() {
		return (List<Allievo>) this.allievoRepository.findAll();
	}
	public List<Allievo> findByNome(String nome) {
		return this.allievoRepository.findByNome(nome);
	}
	
	public Allievo findByNomeAndCognomeAndEmail(String nome, String cognome,String email) {
		return (Allievo) this.allievoRepository.findByNomeAndCognomeAndEmail(nome, cognome,email);
	}
	
	
	public Allievo findById(Long id) {
		Optional<Allievo> allievo = this.allievoRepository.findById(id);
		if(allievo.isPresent())
			return allievo.get();
		else
			return null;
	}

	public boolean alreadyExists(Allievo allievo) {
		List<Allievo> allievi = this.allievoRepository.findByNomeAndCognomeAndEmail(allievo.getNome(), allievo.getCognome(),allievo.getEmail());
		if (allievi.size() > 0)
			return true;
		else 
			return false;
	}

	public Allievo findByEmail(String email) {
		Optional<Allievo> allievo = this.allievoRepository.findByEmail(email);
		if (allievo.isPresent())
			return allievo.get();
		else
			return null;
	}

	public void delete(Long id) {
		this.allievoRepository.deleteById(id);
	}
}
