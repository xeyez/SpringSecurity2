package io.github.xeyez.user.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private Map<String, UserVO> userMap = new HashMap<>();
	private Map<String, List<UserPermission>> permMap = new HashMap<>();
	
	/* 임시 */
	public CustomAuthenticationProvider() {
		userMap.put("user_enc", new UserVO("user_enc", "", "none"));
		permMap.put("user_enc", Arrays.asList(new UserPermission(1L, "USER")));
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
		
		// 사용자 정보 조회
		UserVO user = userMap.get(authToken.getName());
		if(user == null)
			throw new UsernameNotFoundException(authToken.getName());
		
		// Password 비교 (??????)
		if(!user.getPassword().equals(authToken.getCredentials()))
			throw new BadCredentialsException("not matching username or password");
		
		// 권한 목록 얻기
		List<GrantedAuthority> authorities = getAuthorities(user.getId());
		
		// 인증된 사용자 정보 반환
		UserVO principal = new UserVO(user.getId(), user.getName(), null);
		return new UsernamePasswordAuthenticationToken(principal, null, authorities);
	}
	
	private List<GrantedAuthority> getAuthorities(String id) {
		List<UserPermission> perms = permMap.get(id);
		if (perms == null)
			return Collections.emptyList();

		List<GrantedAuthority> authorities = new ArrayList<>(perms.size());
		for (UserPermission perm : perms) {
			authorities.add(new SimpleGrantedAuthority(perm.getName()));
		}
		return authorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
