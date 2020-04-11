package com.springsecurity.study.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationManager implements AuthenticationManager {

	private static final Logger LOGGER = Logger.getLogger("CustomAuthenticationManager");
	private final UserDao userDao = new UserDao();
	private final PasswordEncoder passowrdEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		LOGGER.info("Performing custom authentication for :" + authentication);
		DbUser dbUser = userDao.searchUser(authentication.getName());
		if (Objects.isNull(dbUser)
				|| !passowrdEncoder.matches((String) authentication.getCredentials(), dbUser.getPassword())) {
			throw new BadCredentialsException("Username and password not valid");
		}
		LOGGER.info("User details are good and ready to go");
		return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(),
				getAuthorities(dbUser.getAccess()));

	}

	private List<GrantedAuthority> getAuthorities(Integer access) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		if (access.compareTo(1) == 0) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return authorities;
	}

}
