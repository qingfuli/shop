package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.model.User;

@Controller
public class HomeController {


	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(@ModelAttribute User user){
		
		return "index";
	}
}
