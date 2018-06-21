package progetto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import progetto.model.Allievo;



public interface AllievoRepository  extends CrudRepository<Allievo, Long> {

	public List<Allievo> findByNome(String nome);
	
	public List<Allievo> findByNomeAndCognomeAndEmail(String nome, String cognome,String email);

	public Optional<Allievo> findByEmail(String email);
	
}
