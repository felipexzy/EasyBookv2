package com.algodaodoce.easybook.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.algodaodoce.easybook.entity.Permissao;
import com.algodaodoce.easybook.entity.Usuario;
import com.algodaodoce.easybook.repository.UsuarioRepository;

@Component
public class UserDetail implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = this.userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("Usuário pertencente ao email \"" + email + "\" não foi encontrado");
		}

		LoginDetailBean login = new LoginDetailBean(user.getNome(), user.getEmail(), user.getSenha());

		for (Permissao permission : user.getPermissoes()) {
			login.addRole(permission.getNome());
		}

		return login;
	}

}
