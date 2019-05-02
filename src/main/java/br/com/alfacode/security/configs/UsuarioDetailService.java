package br.com.alfacode.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.alfacode.security.domains.Usuario;
import br.com.alfacode.security.services.UsuarioService;

@Component
public class UsuarioDetailService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findUsuarioByName(username);
		
		if(usuario == null)
			throw new UsernameNotFoundException("Usuário não encontrado!");
		
		return usuario;
	}

}
