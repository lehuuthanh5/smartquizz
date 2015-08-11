package ltvnc.java.lichking.controller;

import java.util.HashMap;

import ltvnc.java.lichking.modal.User;
import ltvnc.java.lichking.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getRegistrationPage() {
		return "signup";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginLTVNCChat(@RequestParam String username,
			@RequestParam String password) {
		return "redirect:/chatter";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody
	HashMap<String, String> registerNewUser(@RequestBody User user) {
		HashMap<String, String> errors = userService.valiRegisUserData(user);
		if (errors.isEmpty()) {
			userService.addUser(user);
		}
		return errors;
	}
}
