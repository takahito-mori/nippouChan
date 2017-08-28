package jp.co.unirita.nippouChan.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.unirita.nippouChan.application.AdminService;
import jp.co.unirita.nippouChan.application.user.NippouChanUserDetails;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.user.User;

/*新規作成したとき*/
@Controller
@RequestMapping("/user")
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/**
	 * (サンプル実装) [登録]ボタンをクリックしたときの処理。 ユーザーオブジェクトをAdminServiceのユーザー作成処理に渡す。
	 *
	 * @param user
	 * @return
	 */
	@PostMapping
	public ModelAndView create(@Validated User user, BindingResult result,@AuthenticationPrincipal NippouChanUserDetails userDetails) {
		User loginuser = userDetails.getUser();
		if (loginuser.getUserFlag() == false) {
			ModelAndView mav = new ModelAndView("redirect:/home?pageno=0");
			return mav;
		}
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		adminService.create(user);
		ModelAndView mav = new ModelAndView("adminhome_page");
		List<User> users = adminService.getAll();
		mav.addObject("loginuser",loginuser);
		mav.addObject("allusers", users);
		return mav;
	}

	@GetMapping
	public ModelAndView write(@Validated Nippou nippou, BindingResult result,
			@AuthenticationPrincipal NippouChanUserDetails userDetails) {
		User loginuser = userDetails.getUser();
		if (loginuser.getUserFlag() == false) {
			ModelAndView mav = new ModelAndView("redirect:/home?pageno=0");
			return mav;
		}
		ModelAndView mav = new ModelAndView("adminwrite_page");
		mav.addObject("user",new User());
		return mav;
	}
}
