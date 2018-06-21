package progetto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import progetto.model.Attività;
import progetto.model.Centro;

public interface AttivitàRepository extends CrudRepository<Attività, Long> {


	public Attività findByNome(String nome);
	
	public List<Attività> findByDataAndOrario(Date data,int orario);
	
	public List<Attività> findByNomeAndCentro(String nome, Centro centro);
	
}
