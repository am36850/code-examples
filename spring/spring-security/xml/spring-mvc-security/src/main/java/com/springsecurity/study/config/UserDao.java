package com.springsecurity.study.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDao {

	private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	public DbUser searchUser(String username) {
		List<DbUser> users = internalUsers();
		return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElseGet(null);
	}

	private List<DbUser> internalUsers() {
		List<DbUser> dbUsers = new ArrayList<>();
		dbUsers.add(createDbUser("user", passwordEncoder.encode("user"), 0));
		dbUsers.add(createDbUser("admin", passwordEncoder.encode("admin"), 1));
		dbUsers.add(createDbUser("mike", passwordEncoder.encode("mike"), 0));
		dbUsers.add(createDbUser("jane", passwordEncoder.encode("jane"), 1));
		return dbUsers;
	}

	private DbUser createDbUser(String username, String password, Integer access) {
		DbUser dbUser = new DbUser();
		dbUser.setUsername(username);
		dbUser.setPassword(password);
		dbUser.setAccess(access);
		return dbUser;
	}
}
