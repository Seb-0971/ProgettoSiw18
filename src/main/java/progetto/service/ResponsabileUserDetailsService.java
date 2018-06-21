package progetto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import progetto.model.Responsabile;
import progetto.repository.ResponsabileRepository;


@Service
public class ResponsabileUserDetailsService implements UserDetailsService{
	
	@Autowired
	ResponsabileRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Responsabile responsabile= repository.findByUsername(username);

	   UserBuilder builder=null;
	    if (responsabile!=null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.password(responsabile.getPassword());
	      builder.roles(responsabile.getRuolo());
	    } 
	    else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
		
	}

}


