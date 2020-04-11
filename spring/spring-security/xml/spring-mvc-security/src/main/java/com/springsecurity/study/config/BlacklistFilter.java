package com.springsecurity.study.config;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class BlacklistFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = Logger.getLogger("BlacklistFilter");

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		LOGGER.info("inside blacklist filter");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (Objects.nonNull(authentication) && "mike".equalsIgnoreCase(authentication.getName())) {
			LOGGER.warning("User black Listed. Will not be allowded to enter.");
			throw new AccessDeniedException("Blacklisted User:" + authentication.getName());
		}
		filterChain.doFilter(request, response);
	}

}
