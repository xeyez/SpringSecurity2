package io.github.xeyez.user;

import java.util.Arrays;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserJoinService {
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder;

	public void setUserDetailsManager(UserDetailsManager userDetailsManager) {
		this.userDetailsManager = userDetailsManager;
	}
	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void join(NewUser newUser) {
		String encodedPassword = passwordEncoder.encode(newUser.getPassword());
		
		UserDetails user = new User(newUser.getName(), encodedPassword,
				Arrays.asList(new SimpleGrantedAuthority("USER")));
		
		try {
			userDetailsManager.createUser(user);
		} catch (DuplicateKeyException ex) {
			throw new DuplicateKeyException(String.format("Username [%s] is aleady exists", newUser.getName()), ex);
		}
	}
}
