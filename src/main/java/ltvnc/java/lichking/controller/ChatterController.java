package ltvnc.java.lichking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatterController {

	@RequestMapping(value = "/chatter", method = RequestMethod.GET)
	public String getChatterPage() {
		return "chatterpage";
	}
}
