package progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import progetto.controller.validator.AttivitàValidator;

import progetto.model.Attività;

import progetto.service.AttivitàService;

@Controller
public class AttivitàController {

	@Autowired
    private AttivitàService attivitàService;
	
	@Autowired
    private AttivitàValidator validator;
	
	@RequestMapping("/indexAttivita")
	public String homeAttivita() {
		return "attività/gestioneAttività";
	}
	
	@RequestMapping("/attivita")
    public String attivita(Model model) {
        model.addAttribute("attivita", this.attivitàService.findAll());
        return "attività/attivitaList";
    }

    @RequestMapping("/addAttivita")
    public String addAttività(Model model) {
        model.addAttribute("attivita", new Attività());
        return "attività/attivitaForm";
    }
    

   
    @RequestMapping(value = "/attivita", method = RequestMethod.POST)
    public String newAttività(@Valid @ModelAttribute("attivita") Attività attivita, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(attivita, bindingResult);
        
        if (this.attivitàService.alreadyExists(attivita)) {
            model.addAttribute("exists", "Attività already exists");
            return "attività/attivitaForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.attivitàService.save(attivita);
                model.addAttribute("attivita", this.attivitàService.findAll());
                return "attività/attivitaList";
            }
        }
        return "attività/attivitaForm";
    }
    
    @RequestMapping("/cercaAttivita")
	public String cercaAttivita() {
		return "attività/cercaAttivita";
	}

	@RequestMapping(value = "/cercaNome")
	public String cercaAttivita(@RequestParam("nome") String nome, Model model) {

		if (!nome.equals("") && nome != null) {
			this.attivitàService.uploadString(nome);
			Attività attività = this.attivitàService.findByNome(nome);
 			if (attività == null) {
 				model.addAttribute("notexists", " Attività non esiste");
 				return "attività/cercaAttivita";
 			} else {
 				model.addAttribute("attivita", attività);
 				return "attività/attivitaList";
 			}
 		}
		model.addAttribute("errorParam", " Inserisci Nome");
		return "attività/cercaAttivita";
	}
	
}
