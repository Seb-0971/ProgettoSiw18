package progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import progetto.model.Centro;

public interface CentroRepository extends CrudRepository<Centro, Long>{

	
	public List<Centro> findByNome(String nome);

}
