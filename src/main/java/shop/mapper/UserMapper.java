package shop.mapper;

import shop.model.User;

public interface UserMapper {
	
	void create(User user);
	
	User findOneByUsername(String username);
}
