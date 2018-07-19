package shop.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import shop.model.User;


public class UserDetailsImpl extends org.springframework.security.core.userdetails.User{
	private User user;

	public UserDetailsImpl(User user) {
		super(user.getUsername(),
				user.getPassword(),
				true, true, true, true,
				buildAuthorities(user)
			);
		this.user = user;
	}

	private static Collection<? extends GrantedAuthority> buildAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return authorities;
	}

	public User getUser() {
		return user;
	}

}
