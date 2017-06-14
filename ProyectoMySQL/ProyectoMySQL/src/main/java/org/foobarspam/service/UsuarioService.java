package org.foobarspam.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.foobarspam.entity.Usuario;
import org.foobarspam.entity.UsuarioRol;
import org.foobarspam.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		org.foobarspam.entity.Usuario usuario = usuarioRepository.findByNombre(nombre);
		
		List<GrantedAuthority> authorities = buildAuthorities(usuario.getUsuarioRol());
		return buildUser(usuario,authorities);
	}
	
	private User buildUser(org.foobarspam.entity.Usuario usuario, List<GrantedAuthority> authorities){
		
		return new User(usuario.getNombre(), usuario.getContraseña(), usuario.isDisponible(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set <UsuarioRol> userRol){
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for(UsuarioRol usuario : userRol){
			auths.add(new SimpleGrantedAuthority(usuario.getRol()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}

}
