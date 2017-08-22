package jp.co.unirita.nippouChan.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value = { "/", "/login_page"} )
	String loginForm() {
		return "login/login_page";
	}
}