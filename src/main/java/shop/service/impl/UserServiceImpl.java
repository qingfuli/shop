package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shop.mapper.UserMapper;
import shop.model.User;
import shop.service.UserService;
import shop.service.UsernameExistException;

@Service
public class UserServiceImpl implements UserService{
	private UserMapper userMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void create(User user) {
		User result = userMapper.findOneByUsername(user.getUsername());
		if(result != null){
			throw new UsernameExistException();
		}
		String encoderPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encoderPassword);
		
		userMapper.create(user);
	}
	
}
