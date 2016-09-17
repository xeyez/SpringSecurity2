package io.github.xeyez.security.handler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private String defaultTargetUrl;
	
	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,	HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		//addCookie(response, authentication);
		
		String retUrl = request.getParameter("returl");
		String redirectUrl = retUrl != null && !retUrl.trim().isEmpty() ? retUrl : defaultTargetUrl;
		response.sendRedirect(redirectUrl);
	}

	private void addCookie(HttpServletResponse response, Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		
		StringBuilder cookieValue = new StringBuilder();
		cookieValue.append(user.getUsername());
		
		if(authentication.getAuthorities() != null) {
			for(GrantedAuthority auth : authentication.getAuthorities()) {
				cookieValue.append(auth.getAuthority());
			}
		}
		
		try {
			Cookie cookie = new Cookie("AUTH", URLEncoder.encode(cookieValue.toString(), "UTF-8"));
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
