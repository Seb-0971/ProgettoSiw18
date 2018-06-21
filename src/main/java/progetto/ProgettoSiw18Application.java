package progetto;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import progetto.ProgettoSiw18Application;
import progetto.model.Allievo;
import progetto.model.Attività;
import progetto.model.Centro;
import progetto.model.Responsabile;
import progetto.service.AllievoService;
import progetto.service.AttivitàService;
import progetto.service.CentroService;
import progetto.service.ResponsabileService;

@SpringBootApplication
public class ProgettoSiw18Application {
	final Logger logger = LoggerFactory.getLogger(ProgettoSiw18Application.class);
	@Autowired
	private AllievoService allievoService; 
	
	@Autowired
	private AttivitàService attivitaService;
	
	@Autowired
	private CentroService centroService;
	
	@Autowired
	private ResponsabileService responsabileService;

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSiw18Application.class, args);
	}
	
	@PostConstruct
	public void init(){
		Responsabile responsabile = new Responsabile();
		responsabile.setUsername("responsabile");
		responsabile.setPassword("responsabile");
		responsabile.setRuolo("RESPONSABILE");
		
		
		
		Responsabile responsabile2 = new Responsabile();
		responsabile2.setUsername("direttore");
		responsabile2.setPassword("direttore");
		responsabile2.setRuolo("DIRETTORE");
		
		Allievo a1 = new Allievo("Sebastiano", "Polosa", "seb@email.com",  new Date(), "Potenza");
		allievoService.save(a1);
		Allievo a2 = new Allievo("Francesco", "Cacini", "fra@email.com",  new Date(), "Roma");
		allievoService.save(a2);
		
		
		Attività yoga = new Attività("Yoga", new Date(),new Date(19-00));
		attivitaService.save(yoga);
		Attività calcio = new Attività("Calcio", new Date(),new Date());
		attivitaService.save(calcio);
		
		Centro centro = new Centro("CentroA","Via Paolo","centroA@roma3.it","061111","50");
		Centro centro2 = new Centro("CentroB","Via Boccia","centroB@roma3.it","062222","70");
		centroService.save(centro2);
		Centro centro3 = new Centro("CentroC","Piazza Palla","centroC@roma3.it","063333","90");
		centroService.save(centro3);
		Centro centro4 = new Centro("CentroD","Via Norma","centroD@roma3.it","064444","110");
		centroService.save(centro4);
	
	if (!responsabileService.alreadyExists(responsabile)) {
		responsabile.setCentro(centro);
		responsabileService.save(responsabile);
	}
	
	
	if (!responsabileService.alreadyExists(responsabile2)) {
		responsabileService.save(responsabile2);
	}
	
		
	}
}
