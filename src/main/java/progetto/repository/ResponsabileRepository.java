package progetto.repository;

import org.springframework.data.repository.CrudRepository;

import progetto.model.Responsabile;


public interface ResponsabileRepository extends CrudRepository<Responsabile, Long >{
	public Responsabile findByUsername(String username);
	public Responsabile findByPassword(String password);
}
