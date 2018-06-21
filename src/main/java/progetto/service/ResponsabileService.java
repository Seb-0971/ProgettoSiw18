package progetto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progetto.model.Responsabile;
import progetto.repository.ResponsabileRepository;



@Transactional
@Service
public class ResponsabileService {
	@Autowired
	private ResponsabileRepository responsabileRepository;
	
	public Responsabile save(Responsabile a) {
	    return this.responsabileRepository.save(a);
	}
	
	
	public List<Responsabile> findAll(){
	    return (List<Responsabile>) this.responsabileRepository.findAll();
	}
	
	public Responsabile findById(Long id) {
		Optional<Responsabile> responsabile= this.responsabileRepository.findById(id);
		if (responsabile.isPresent()) 
			return responsabile.get();
		else
			return null;
	}
	
	public Responsabile findByUsername(String username) {
		return responsabileRepository.findByUsername(username);
	}
	public Responsabile findByPassword(String password) {
		return responsabileRepository.findByUsername(password);
	}
	
	public void deleteAll() {
		responsabileRepository.deleteAll();
	}

	public boolean alreadyExists(Responsabile responsabile) {
		Responsabile responsabile2= this.responsabileRepository.findByUsername(responsabile.getUsername());
		if (responsabile2!=null)
			return true;
		else 
			return false;
	}	
}