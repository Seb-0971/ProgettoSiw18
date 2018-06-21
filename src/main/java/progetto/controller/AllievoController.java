package progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import progetto.controller.validator.AllievoValidator;
import progetto.model.Allievo;
import progetto.service.AllievoService;

@Controller
public class AllievoController {

	@Autowired
    private AllievoService allievoService;
	
	@Autowired
    private AllievoValidator validator;
	
	@RequestMapping("/indexAllievo")
	public String homeAllievo() {
		return "allievo/gestioneAllievi";
	}
	
	@RequestMapping("/allievi")
    public String allievi(Model model) {
        model.addAttribute("allievi", this.allievoService.findAll());
        return "allievo/allieviList";
    }

    @RequestMapping("/addAllievo")
    public String addAllievo(Model model) {
        model.addAttribute("allievo", new Allievo());
        return "allievo/allievoForm";
    }
    

    @RequestMapping(value = "/allievo/{id}", method = RequestMethod.GET)
    public String getAllievo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("allievo", this.allievoService.findById(id));
    	return "allievo/showAllievo";
    }
    
    @RequestMapping(value = "/allievi", method = RequestMethod.POST)
    public String newAllievo(@Valid @ModelAttribute("allievo") Allievo allievo, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(allievo, bindingResult);
        
        if (this.allievoService.alreadyExists(allievo)) {
            model.addAttribute("exists", "Allievo already exists");
            return "allievo/allievoForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.allievoService.save(allievo);
                model.addAttribute("allievi", this.allievoService.findAll());
                return "allievo/allieviList";
            }
        }
        return "allievo/allievoForm";
    }
    
 // Ricerca Allievo metodo Supporto
 	@RequestMapping("/cercaAllievo")
 	public String cercaAllievo() {
 		return "allievo/cercaAllievo";
 	}
 
 	@RequestMapping(value = "/cercaEmail")
 	public String findAllievo(@RequestParam("email") String email, Model model) {

 		if (!email.equals("") && email != null) {

 			Allievo allievo = this.allievoService.findByEmail(email.toLowerCase());

 			if (allievo == null) {
 				model.addAttribute("notexists", " Allievo non esiste");
 				return "allievo/cercaAllievo";
 			} else {
 				model.addAttribute("allievo", allievo);
 				return "allievo/showAllievo";
 			}
 		}
 		model.addAttribute("errorParam", "  Inserisci Email");
 		return "allievo/cercaAllievo";
 	}
 
 	@RequestMapping(value = "/cancAllievo/{id}", method = RequestMethod.GET)
 	public String cancelllaAllievo(@PathVariable("id") Long id, Model model) {
 		this.allievoService.delete(id);
 		return "allievo/cancAllievo";
 	}
}
