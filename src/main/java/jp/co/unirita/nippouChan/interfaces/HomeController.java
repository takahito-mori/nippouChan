package jp.co.unirita.nippouChan.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.unirita.nippouChan.application.AdminService;
import jp.co.unirita.nippouChan.application.NippouService;
import jp.co.unirita.nippouChan.application.user.NippouChanUserDetails;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.user.User;

@Controller
public class HomeController {

    @Autowired
    NippouService nippouService;
	@Autowired
	AdminService adminService;

    /**
     * (サンプル実装)
     * ホーム画面。この例ではDBから日報のリストを取得してビューに渡している。
     * @return
     */

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("pageno") Integer pageno, Nippou nippou,@AuthenticationPrincipal NippouChanUserDetails userDetails) {
    	User user = userDetails.getUser();
    	if (user.getUserFlag() == true) {
			List<User> users = adminService.getAll();
		//	List<User> users = adminService.getOne(user.getUserId());
			ModelAndView mav = new ModelAndView("adminhome_page");
			mav.addObject("allusers", users);
			mav.addObject("loginuser", user);
			return mav;
		} else {
			Page<Nippou> page = nippouService.getPage(pageno);
		      List<Nippou> report = page.getContent();
		      Integer totalPages = page.getTotalPages();


		      ModelAndView mav = new ModelAndView("home_page");

		      mav.addObject("nippouPage", totalPages);
		      mav.addObject("nippou", report);
		      mav.addObject("loginuser",user);

			return mav;
		}

    }

    @GetMapping("/mypage")
    public ModelAndView mypage(Nippou nippou,@AuthenticationPrincipal NippouChanUserDetails userDetails) {
      User user = userDetails.getUser();
      List<Nippou> report = nippouService.getListByUser(user);
    	ModelAndView mav = new ModelAndView("mypage");

        mav.addObject("nippou", report);
        mav.addObject("loginuser",user);
        return mav;
    }



}
