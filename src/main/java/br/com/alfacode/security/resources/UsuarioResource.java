package br.com.alfacode.security.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alfacode.security.domains.Usuario;
import br.com.alfacode.security.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

	@Autowired
	UsuarioService service;

	@GetMapping(value = "/{id}")
	public Optional<Usuario> findUsuarioById(@PathVariable Integer id) {
		return service.findUsuarioById(id);
	}
	
	@GetMapping(value = "/{name}")
	public Usuario findUsuarioById(@PathVariable String name) {
		return service.findUsuarioByName(name);
	}

	@PostMapping(value = "/save")
	public Usuario save(@RequestBody Usuario usuario) {
		return service.save(usuario);
	}

}
