package io.github.xeyez.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	private String logoutSuccessUrl;
	
	public void setLogoutSuccessUrl(String logoutSuccessUrl) {
		this.logoutSuccessUrl = logoutSuccessUrl;
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request,	HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		Cookie cookie = new Cookie("AUTH", "");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		//response.sendRedirect(request.getContextPath() + "/");
		
		response.sendRedirect(logoutSuccessUrl);
	}

}
