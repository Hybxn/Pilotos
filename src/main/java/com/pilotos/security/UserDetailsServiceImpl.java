package com.pilotos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pilotos.models.Piloto;
import com.pilotos.repositories.PilotoRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	PilotoRepository repositorioPilotos;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Piloto piloto = repositorioPilotos.findFirstPilotoByEmail(username);
		UserBuilder ub = null;
		
		if (piloto != null) {
			ub = User.withUsername(username);
			ub.disabled(false);
			ub.password(piloto.getPassword());
			ub.authorities(new SimpleGrantedAuthority("ROLE_USER"));
		} else 
			throw new UsernameNotFoundException("Usuario no encontrado");
		
		
		
		return ub.build();
	}

}
