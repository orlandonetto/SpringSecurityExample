package br.com.alfacode.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alfacode.security.domains.Usuario;
import br.com.alfacode.security.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;

	public Optional<Usuario> findUsuarioById(Integer id) {
		return repository.findById(id);
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario findUsuarioByName(String name) {
		return repository.findByName(name).orElse(null);
	}
}
