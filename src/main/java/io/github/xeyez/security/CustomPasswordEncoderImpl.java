package io.github.xeyez.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoderImpl implements CustomPasswordEncoder {

	PasswordEncoder encoder = null;
	
	public CustomPasswordEncoderImpl() {
		encoder = new BCryptPasswordEncoder();
	}
	
	@Override
	public String encode(CharSequence paramCharSequence) {
		return encoder.encode(paramCharSequence);
	}

	@Override
	public boolean matches(CharSequence paramCharSequence, String paramString) {
		return encoder.matches(paramCharSequence, paramString);
	}

}
