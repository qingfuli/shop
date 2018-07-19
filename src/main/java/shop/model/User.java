package shop.model;

import java.util.Collection;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

public class User {
	private Long id;
	
	@Pattern(regexp = "^(?!\\d+$)[a-zA-Z0-9-_]{2,16}+$", message="2~16位，仅限数字字母、连字符-、下划线_")
	private String username;
	
	@Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,64}$", message="6~64位，仅限数字字母、英文标点")
	private String password;
	
	@Size(max = 1024, message="小于1024")
	private String description;
	
	
	public User() {
	}

	public User(Long id, String username, String password, String description) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
