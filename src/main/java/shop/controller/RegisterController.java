package shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.model.User;
import shop.service.UserService;
import shop.service.UsernameExistException;

@Controller
public class RegisterController {
	private UserService userService;

	@Autowired
	public RegisterController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String add(@ModelAttribute User user){
		
		return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String create(@ModelAttribute @Valid User user,
						BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "register";
		}
		try {
			userService.create(user);
		} catch (UsernameExistException ex) {
			bindingResult.rejectValue("username", "username.exist", "用户名已存在");
			return "register";
		}
		
		return "redirect:/login";
	}
}
