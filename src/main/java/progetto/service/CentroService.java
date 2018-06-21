package progetto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progetto.model.Centro;
import progetto.repository.CentroRepository;

@Transactional
@Service
public class CentroService {
	
	@Autowired
	private CentroRepository centroRepository; 
	
	public Centro save(Centro centro) {
		return this.centroRepository.save(centro);
	}

	public List<Centro> findAll() {
		return (List<Centro>) this.centroRepository.findAll();
	}
	
	public Centro findById(Long id) {
		Optional<Centro> centro = this.centroRepository.findById(id);
		if (centro.isPresent()) 
			return centro.get();
		else
			return null;
	}

	public boolean alreadyExists(Centro centro) {
		List<Centro> listaCentro = this.centroRepository.findByNome(centro.getNome());
		if (listaCentro.size() > 0)
			return true;
		else 
			return false;
	}	

}
