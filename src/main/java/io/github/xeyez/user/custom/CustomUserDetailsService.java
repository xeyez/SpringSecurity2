package io.github.xeyez.user.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	private Map<String, UserVO> userMap = new HashMap<>();
	private Map<String, List<UserPermission>> permMap = new HashMap<>();

	/* 임시 */
	public CustomUserDetailsService() {
		userMap.put("user_enc", new UserVO("user_enc", "", "none"));
		permMap.put("user_enc", Arrays.asList(new UserPermission(1L, "USER")));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserVO user = userMap.get(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		
		List<UserPermission> perms = permMap.get(user.getId());
		List<GrantedAuthority> auth = new ArrayList<>();
		for(UserPermission perm : perms) {
			auth.add(new SimpleGrantedAuthority(perm.getName()));
		}
		
		return new User(username, user.getPassword(), auth);
	}
}
