package io.github.xeyez.user;

import java.util.Arrays;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserJoinService {
	private UserDetailsManager userDetailsManager;

	public void setUserDetailsManager(UserDetailsManager userDetailsManager) {
		this.userDetailsManager = userDetailsManager;
	}

	@Transactional
	public void join(NewUser newUser) {
		UserDetails user = new User(newUser.getName(), newUser.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("USER")));
		
		try {
			userDetailsManager.createUser(user);
		} catch (DuplicateKeyException ex) {
			throw new DuplicateKeyException(String.format("Username [%s] is aleady exists", newUser.getName()), ex);
		}
	}
}
